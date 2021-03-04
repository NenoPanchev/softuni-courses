package coursespringdata.jsonprocessingex1.services;

import coursespringdata.jsonprocessingex1.models.dtos.UserListCountDto;
import coursespringdata.jsonprocessingex1.models.dtos.UserSeedDto;
import coursespringdata.jsonprocessingex1.models.dtos.UserSoldProductsDto;
import coursespringdata.jsonprocessingex1.models.entities.User;

import java.util.List;

public interface UserService {
    void seedUsers(UserSeedDto[] userSeedDtos);
    User getRandomUser();
    List<UserSoldProductsDto> getUsersWithSoldProductsToBuyers();
    UserListCountDto findAllWhereProductsSoldIsGreaterThanZeroOrderByCountOfProductsSoldDescLastNameAsc();
}
