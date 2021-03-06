package course.springdata.jsonprocessingex2.services.impl;

import course.springdata.jsonprocessingex2.models.dtos.CustomerSeedDto;
import course.springdata.jsonprocessingex2.models.dtos.export.CustomerExportDto;
import course.springdata.jsonprocessingex2.models.dtos.export.CustomerExportNameAndSalesDto;
import course.springdata.jsonprocessingex2.models.dtos.export.SaleExportDto;
import course.springdata.jsonprocessingex2.models.entities.Customer;
import course.springdata.jsonprocessingex2.models.entities.Sale;
import course.springdata.jsonprocessingex2.repositories.CustomerRepository;
import course.springdata.jsonprocessingex2.services.CarService;
import course.springdata.jsonprocessingex2.services.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final ModelMapper modelMapper;
    private final CustomerRepository customerRepository;
    private final Random random;
    private final CarService carService;

    public CustomerServiceImpl(ModelMapper modelMapper, CustomerRepository customerRepository, Random random, CarService carService) {
        this.modelMapper = modelMapper;
        this.customerRepository = customerRepository;
        this.random = random;
        this.carService = carService;
    }

    @Override
    public void seedCustomers(CustomerSeedDto[] dtos) {
        if (this.customerRepository.count() > 0) {
            return;
        }
        Arrays.stream(dtos)
                .map(dto -> this.modelMapper.map(dto, Customer.class))
                .forEach(this.customerRepository::saveAndFlush);
    }

    @Override
    public Customer getRandomCustomer() {
        long randomId = (long) this.random.nextInt((int) this.customerRepository.count()) + 1;
        return this.customerRepository.getOne(randomId);
    }

    @Override
    public List<CustomerExportDto> getAllCustomersOrderedByBirthDateAscIsYoungDriverAsc() {
        return this.customerRepository.getAllCustomersOrderedByBirthDateAscIsYoungDriverAsc()
        .stream()
                .map(entity -> {
            CustomerExportDto dto = this.modelMapper.map(entity, CustomerExportDto.class);
            dto.setSales(entity.getSales()
                    .stream()
                    .map(sale -> this.modelMapper.map(sale, SaleExportDto.class))
                    .collect(Collectors.toList()));
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<CustomerExportNameAndSalesDto> getCustomersCountOfSalesAndTotalMoneySpent() {
        return this.customerRepository.getCustomersWithAtLeastOneSale()
                .stream()
                .map(customer -> {
                    CustomerExportNameAndSalesDto dto = this.modelMapper.map(customer, CustomerExportNameAndSalesDto.class);
                    dto.setBoughtCars(customer.getSales().size());
                    dto.setSpentMoney(getTotalSumForCustomerCarsWithDiscount(customer));
                    return dto;
                })
                .sorted((a, b) -> {
                    int sort = b.getSpentMoney().compareTo(a.getSpentMoney());
                    if (sort == 0) {
                        sort = Integer.compare(b.getBoughtCars(), a.getBoughtCars());
                    }
                    return sort;
                })
                .collect(Collectors.toList());
    }


    private BigDecimal getTotalSumForCustomerCarsWithDiscount(Customer customer) {
        return customer.getSales()
                .stream()
                .map(sale -> {
                    BigDecimal carPrice = this.carService.getCarPriceById(sale.getCar().getId());
                    BigDecimal discount = sale.getDiscount();
                    return carPrice.multiply(BigDecimal.ONE.subtract(discount));
                })
        .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
