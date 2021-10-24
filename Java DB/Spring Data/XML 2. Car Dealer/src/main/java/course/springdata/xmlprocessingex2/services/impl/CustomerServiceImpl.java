package course.springdata.xmlprocessingex2.services.impl;

import course.springdata.xmlprocessingex2.models.dtos.CustomerSeedDto;
import course.springdata.xmlprocessingex2.models.dtos.CustomerSeedRootDto;
import course.springdata.xmlprocessingex2.models.dtos.export.*;
import course.springdata.xmlprocessingex2.models.entities.Customer;
import course.springdata.xmlprocessingex2.repositories.CustomerRepository;
import course.springdata.xmlprocessingex2.services.CarService;
import course.springdata.xmlprocessingex2.services.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public CustomerServiceImpl(ModelMapper modelMapper, CustomerRepository customerRepository, Random random, CarService carService) {
        this.modelMapper = modelMapper;
        this.customerRepository = customerRepository;
        this.random = random;
        this.carService = carService;
    }

    @Override
    public void seedCustomers(List<CustomerSeedDto> dtos) {
        if (this.customerRepository.count() > 0) {
            return;
        }
        dtos.stream()
                .map(dto -> this.modelMapper.map(dto, Customer.class))
                .forEach(this.customerRepository::saveAndFlush);
    }

    @Override
    public Customer getRandomCustomer() {
        long randomId = (long) this.random.nextInt((int) this.customerRepository.count()) + 1;
        return this.customerRepository.getOne(randomId);
    }

    @Override
    public CustomerViewRootDto getAllCustomersOrderedByBirthDateAscIsYoungDriverAsc() {
        List<CustomerExportDto> dtos = this.customerRepository.getAllCustomersOrderedByBirthDateAscIsYoungDriverAsc()
                .stream()
                .map(entity -> this.modelMapper.map(entity, CustomerExportDto.class))
                .collect(Collectors.toList());
        CustomerViewRootDto rootDto = new CustomerViewRootDto();
        rootDto.setCustomers(dtos);
        return rootDto;
    }

    @Override
    public CustomerNameAndSalesViewRootDto getCustomersCountOfSalesAndTotalMoneySpent() {
        List<CustomerExportNameAndSalesDto> dtos = this.customerRepository.getCustomersWithAtLeastOneSale()
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

        CustomerNameAndSalesViewRootDto rootDto = new CustomerNameAndSalesViewRootDto();
        rootDto.setCustomers(dtos);
        return rootDto;
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
