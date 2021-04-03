package spring.fundamentals.springbootex.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.fundamentals.springbootex.models.dtos.TownDto;
import spring.fundamentals.springbootex.models.entities.Town;
import spring.fundamentals.springbootex.repositories.TownRepository;
import spring.fundamentals.springbootex.services.TownService;
import spring.fundamentals.springbootex.utils.ValidationUtil;

@Service
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.townRepository = townRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedTown(String townName) {
        TownDto dto = new TownDto(townName);
        this.townRepository.saveAndFlush(this.modelMapper.map(dto, Town.class));
        System.out.println("Successfully added town!");
    }

    @Override
    public Town getByName(String name) {
        return this.townRepository.getByName(name);
    }
}
