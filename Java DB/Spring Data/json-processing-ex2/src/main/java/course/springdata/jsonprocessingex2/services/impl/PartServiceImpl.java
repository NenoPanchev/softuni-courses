package course.springdata.jsonprocessingex2.services.impl;

import course.springdata.jsonprocessingex2.models.dtos.PartSeedDto;
import course.springdata.jsonprocessingex2.models.entities.Part;
import course.springdata.jsonprocessingex2.repositories.PartRepository;
import course.springdata.jsonprocessingex2.services.PartService;
import course.springdata.jsonprocessingex2.services.SupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

@Service
public class PartServiceImpl implements PartService {
    private final PartRepository partRepository;
    private final SupplierService supplierService;
    private final ModelMapper modelMapper;
    private final Random random;

    public PartServiceImpl(PartRepository partRepository, SupplierService supplierService, ModelMapper modelMapper, Random random) {
        this.partRepository = partRepository;
        this.supplierService = supplierService;
        this.modelMapper = modelMapper;
        this.random = random;
    }


    @Override
    public void seedParts(PartSeedDto[] dtos) {
        if (partRepository.count() > 0) {
            return;
        }
        Arrays.stream(dtos)
                .forEach(dto -> {
                    Part part = modelMapper.map(dto, Part.class);
                    part.setSupplier(supplierService.getRandomSupplier());
                    partRepository.saveAndFlush(part);
                });
    }

    @Override
    public Set<Part> getSetOfThreeToFiveRandomParts() {
        int numberOfParts = this.random.nextInt(3) + 3;
        Set<Part> parts = new LinkedHashSet<>();
        while (parts.size() < numberOfParts) {
            int randomPartId = this.random.nextInt((int) this.partRepository.count()) + 1;
            parts.add(partRepository.getById((long) randomPartId));
        }
        return parts;
    }
}
