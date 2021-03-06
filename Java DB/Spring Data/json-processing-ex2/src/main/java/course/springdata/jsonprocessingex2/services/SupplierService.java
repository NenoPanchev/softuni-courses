package course.springdata.jsonprocessingex2.services;

import course.springdata.jsonprocessingex2.models.dtos.SupplierSeedDto;
import course.springdata.jsonprocessingex2.models.dtos.export.SupplierExportDto;
import course.springdata.jsonprocessingex2.models.entities.Supplier;

import java.util.List;

public interface SupplierService {
    void seedSuppliers(SupplierSeedDto[] dtos);
    Supplier getRandomSupplier();
    List<SupplierExportDto> getSuppliersWhoAreNotImporters();
}
