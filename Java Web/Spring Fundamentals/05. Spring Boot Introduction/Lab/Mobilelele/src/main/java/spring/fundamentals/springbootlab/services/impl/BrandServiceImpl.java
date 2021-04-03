package spring.fundamentals.springbootlab.services.impl;

import org.springframework.stereotype.Service;
import spring.fundamentals.springbootlab.repositories.BrandRepository;
import spring.fundamentals.springbootlab.services.BrandService;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }
}
