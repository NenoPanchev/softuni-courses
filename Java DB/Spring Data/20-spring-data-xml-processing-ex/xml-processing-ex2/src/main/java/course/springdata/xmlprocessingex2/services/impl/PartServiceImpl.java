package course.springdata.xmlprocessingex2.services.impl;

import course.springdata.xmlprocessingex2.models.dtos.PartSeedDto;
import course.springdata.xmlprocessingex2.models.entities.Part;
import course.springdata.xmlprocessingex2.repositories.PartRepository;
import course.springdata.xmlprocessingex2.services.PartService;
import course.springdata.xmlprocessingex2.services.SupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PartServiceImpl implements PartService {
    private final PartRepository partRepository;
    private final SupplierService supplierService;
    private final ModelMapper modelMapper;
    private final Random random;

    @Autowired
    public PartServiceImpl(PartRepository partRepository, SupplierService supplierService, ModelMapper modelMapper, Random random) {
        this.partRepository = partRepository;
        this.supplierService = supplierService;
        this.modelMapper = modelMapper;
        this.random = random;
    }


    @Override
    public void seedParts(List<PartSeedDto> dtos) {
        if (partRepository.count() > 0) {
            return;
        }
        dtos
                .forEach(dto -> {
                    Part part = modelMapper.map(dto, Part.class);
                    part.setSupplier(supplierService.getRandomSupplier());
                    partRepository.saveAndFlush(part);
                });
    }

    @Override
    public Set<Part> getSetOfTenToTwentyRandomParts() {
        int numberOfParts = this.random.nextInt(11) + 10;
        Set<Part> parts = new LinkedHashSet<>();
        while (parts.size() < numberOfParts) {
            int randomPartId = this.random.nextInt((int) this.partRepository.count()) + 1;
            parts.add(partRepository.getById((long) randomPartId));
        }
        return parts;
    }
}
