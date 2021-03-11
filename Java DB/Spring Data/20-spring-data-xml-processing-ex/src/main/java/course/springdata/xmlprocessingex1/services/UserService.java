package course.springdata.xmlprocessingex1.services;

import course.springdata.xmlprocessingex1.models.dtos.view.UserListCountDto;
import course.springdata.xmlprocessingex1.models.dtos.UserSeedDto;
import course.springdata.xmlprocessingex1.models.dtos.view.UserViewSoldProductsRootDto;
import course.springdata.xmlprocessingex1.models.entities.User;

import java.util.List;

public interface UserService {
    void seedUsers(List<UserSeedDto> userSeedDtos);
    User getRandomUser();
    UserViewSoldProductsRootDto getUsersWithSoldProductsToBuyers();
    UserListCountDto findAllWhereProductsSoldIsGreaterThanZeroOrderByCountOfProductsSoldDescLastNameAsc();
}
