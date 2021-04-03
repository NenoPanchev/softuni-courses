package spring.fundamentals.springbootlab.services.impl;

import org.springframework.stereotype.Service;
import spring.fundamentals.springbootlab.repositories.ModelRepository;
import spring.fundamentals.springbootlab.services.ModelService;

@Service
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;


    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }
}
