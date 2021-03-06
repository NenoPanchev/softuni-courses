package course.springdata.jsonprocessingex2.services.impl;

import course.springdata.jsonprocessingex2.models.dtos.export.CarExportWithoutIdDto;
import course.springdata.jsonprocessingex2.models.dtos.export.SaleExportFullInfoDto;
import course.springdata.jsonprocessingex2.models.entities.Sale;
import course.springdata.jsonprocessingex2.repositories.SaleRepository;
import course.springdata.jsonprocessingex2.services.CarService;
import course.springdata.jsonprocessingex2.services.CustomerService;
import course.springdata.jsonprocessingex2.services.SaleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class SaleServiceImpl implements SaleService {
    private final SaleRepository saleRepository;
    private final CarService carService;
    private final CustomerService customerService;
    private final Random random;
    private final ModelMapper modelMapper;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository, CarService carService, CustomerService customerService, Random random, ModelMapper modelMapper) {
        this.saleRepository = saleRepository;
        this.carService = carService;
        this.customerService = customerService;
        this.random = random;
        this.modelMapper = modelMapper;
    }

    @Transactional
    @Override
    public void seedSales() {
        if (this.saleRepository.count() > 0) {
            return;
        }
        Map<Integer, BigDecimal> discountValues = new HashMap<>();
        discountValues.put(0, BigDecimal.valueOf(0.0));
        discountValues.put(1, BigDecimal.valueOf(0.05));
        discountValues.put(2, BigDecimal.valueOf(0.1));
        discountValues.put(3, BigDecimal.valueOf(0.15));
        discountValues.put(4, BigDecimal.valueOf(0.2));
        discountValues.put(5, BigDecimal.valueOf(0.3));
        discountValues.put(6, BigDecimal.valueOf(0.4));
        discountValues.put(7, BigDecimal.valueOf(0.5));
        for (int i = 0; i < 50; i++) {
            Sale sale = new Sale();
            sale.setCar(this.carService.getRandomCar());
            sale.setCustomer(this.customerService.getRandomCustomer());
            int discountValue = this.random.nextInt(7);
            BigDecimal discountBonus = BigDecimal.valueOf(0);
            if (sale.getCustomer().isYoungDriver()) {
                discountBonus = BigDecimal.valueOf(0.05);
            }
            sale.setDiscount(discountValues.get(discountValue).add(discountBonus));
            this.saleRepository.saveAndFlush(sale);
        }
    }

    @Override
    public List<SaleExportFullInfoDto> getSalesWithAppliedDiscount() {
        return this.saleRepository.findAll()
                .stream()
                .map(sale -> {
                    SaleExportFullInfoDto dto = this.modelMapper.map(sale, SaleExportFullInfoDto.class);
                    dto.setCar(this.modelMapper.map(sale.getCar(), CarExportWithoutIdDto.class));
                    dto.setPrice(this.carService.getCarPriceById(sale.getCar().getId()));
                    dto.setPriceWithDiscount(dto.getPrice().multiply(BigDecimal.ONE.subtract(sale.getDiscount())));
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
