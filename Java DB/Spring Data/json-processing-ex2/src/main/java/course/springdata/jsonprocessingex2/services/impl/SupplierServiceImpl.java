package course.springdata.jsonprocessingex2.services.impl;

import course.springdata.jsonprocessingex2.models.dtos.SupplierSeedDto;
import course.springdata.jsonprocessingex2.models.dtos.export.SupplierExportDto;
import course.springdata.jsonprocessingex2.models.entities.Supplier;
import course.springdata.jsonprocessingex2.repositories.SupplierRepository;
import course.springdata.jsonprocessingex2.services.SupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;
    private final Random random;

    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper, Random random) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
        this.random = random;
    }

    @Override
    public void seedSuppliers(SupplierSeedDto[] dtos) {
        if (this.supplierRepository.count() > 0) {
            return;
        }
        Arrays.stream(dtos)
                .forEach(dto -> {
                    if (this.supplierRepository.getByNameAndImporter(dto.getName(), dto.isImporter()) != null) {
                        System.out.printf("%s is already in the database", dto.getName());
                    } else {
                        this.supplierRepository.saveAndFlush(this.modelMapper.map(dto, Supplier.class));
                    }
                });

    }

    @Override
    public Supplier getRandomSupplier() {
        int randomSuppId = this.random.nextInt((int) this.supplierRepository.count()) + 1;
        return supplierRepository.getById((long) randomSuppId);
    }

    @Override
    public List<SupplierExportDto> getSuppliersWhoAreNotImporters() {
        return this.supplierRepository.findAllByImporterFalse().stream()
                .map(entity -> {
                    SupplierExportDto dto = this.modelMapper.map(entity, SupplierExportDto.class);
                    dto.setPartsCount(entity.getParts().size());
                    return dto;
                })
                .collect(Collectors.toList());
    }


}
