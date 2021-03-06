package course.springdata.jsonprocessingex2.services;

import course.springdata.jsonprocessingex2.models.dtos.CustomerSeedDto;
import course.springdata.jsonprocessingex2.models.dtos.export.CustomerExportDto;
import course.springdata.jsonprocessingex2.models.dtos.export.CustomerExportNameAndSalesDto;
import course.springdata.jsonprocessingex2.models.entities.Customer;

import java.util.List;

public interface CustomerService {
    void seedCustomers(CustomerSeedDto[] dtos);
    Customer getRandomCustomer();
    List<CustomerExportDto> getAllCustomersOrderedByBirthDateAscIsYoungDriverAsc();

    List<CustomerExportNameAndSalesDto> getCustomersCountOfSalesAndTotalMoneySpent();
}
