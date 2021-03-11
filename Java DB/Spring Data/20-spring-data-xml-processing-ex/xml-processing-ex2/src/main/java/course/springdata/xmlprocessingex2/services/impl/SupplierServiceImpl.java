package course.springdata.xmlprocessingex2.services.impl;

import course.springdata.xmlprocessingex2.models.dtos.SupplierSeedDto;
import course.springdata.xmlprocessingex2.models.dtos.export.SupplierExportDto;
import course.springdata.xmlprocessingex2.models.dtos.export.SupplierViewRootDto;
import course.springdata.xmlprocessingex2.models.entities.Supplier;
import course.springdata.xmlprocessingex2.repositories.SupplierRepository;
import course.springdata.xmlprocessingex2.services.SupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;
    private final Random random;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper, Random random) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
        this.random = random;
    }

    @Override
    public void seedSuppliers(List<SupplierSeedDto> dtos) {
        if (this.supplierRepository.count() > 0) {
            return;
        }
        dtos
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
    public SupplierViewRootDto getSuppliersWhoAreNotImporters() {
        List<SupplierExportDto> dtos = this.supplierRepository.findAllByImporterFalse().stream()
                .map(entity -> {
                    SupplierExportDto dto = this.modelMapper.map(entity, SupplierExportDto.class);
                    dto.setPartsCount(entity.getParts().size());
                    return dto;
                })
                .collect(Collectors.toList());

        SupplierViewRootDto rootDto = new SupplierViewRootDto();
        rootDto.setSuppliers(dtos);
        return rootDto;
    }


}
