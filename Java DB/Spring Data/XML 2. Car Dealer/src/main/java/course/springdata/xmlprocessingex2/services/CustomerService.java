package course.springdata.xmlprocessingex2.services;

import course.springdata.xmlprocessingex2.models.dtos.CustomerSeedDto;
import course.springdata.xmlprocessingex2.models.dtos.export.CustomerNameAndSalesViewRootDto;
import course.springdata.xmlprocessingex2.models.dtos.export.CustomerViewRootDto;
import course.springdata.xmlprocessingex2.models.entities.Customer;

import java.util.List;

public interface CustomerService {
    void seedCustomers(List<CustomerSeedDto> dtos);
    Customer getRandomCustomer();
    CustomerViewRootDto getAllCustomersOrderedByBirthDateAscIsYoungDriverAsc();

    CustomerNameAndSalesViewRootDto getCustomersCountOfSalesAndTotalMoneySpent();
}
