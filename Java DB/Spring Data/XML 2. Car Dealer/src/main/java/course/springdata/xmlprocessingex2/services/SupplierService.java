package course.springdata.xmlprocessingex2.services;

import course.springdata.xmlprocessingex2.models.dtos.SupplierSeedDto;
import course.springdata.xmlprocessingex2.models.dtos.export.SupplierExportDto;
import course.springdata.xmlprocessingex2.models.dtos.export.SupplierViewRootDto;
import course.springdata.xmlprocessingex2.models.entities.Supplier;

import java.util.List;

public interface SupplierService {
    void seedSuppliers(List<SupplierSeedDto> dtos);
    Supplier getRandomSupplier();
    SupplierViewRootDto getSuppliersWhoAreNotImporters();
}
