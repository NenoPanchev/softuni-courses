package course.springdata.xmlprocessingex2.services;

import course.springdata.xmlprocessingex2.models.dtos.export.SaleViewRootDto;

public interface SaleService {
    void seedSales();

    SaleViewRootDto getSalesWithAppliedDiscount();
}
