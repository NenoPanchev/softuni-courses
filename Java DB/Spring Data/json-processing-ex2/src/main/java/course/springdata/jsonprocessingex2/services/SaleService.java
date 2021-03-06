package course.springdata.jsonprocessingex2.services;

import course.springdata.jsonprocessingex2.models.dtos.export.SaleExportFullInfoDto;

import java.util.List;

public interface SaleService {
    void seedSales();

    List<SaleExportFullInfoDto> getSalesWithAppliedDiscount();
}
