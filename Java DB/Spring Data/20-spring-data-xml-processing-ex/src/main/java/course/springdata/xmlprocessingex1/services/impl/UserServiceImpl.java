package course.springdata.xmlprocessingex1.services.impl;

import course.springdata.xmlprocessingex1.models.dtos.*;
import course.springdata.xmlprocessingex1.models.dtos.view.*;
import course.springdata.xmlprocessingex1.models.entities.User;
import course.springdata.xmlprocessingex1.repositories.UserRepository;
import course.springdata.xmlprocessingex1.services.UserService;
import course.springdata.xmlprocessingex1.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Random random;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Random random) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.random = random;
    }


    @Override
    public void seedUsers(List<UserSeedDto> userSeedDtos) {
        if (this.userRepository.count() > 0) {
            return;
        }

        userSeedDtos
                .forEach(dto -> {
                    if (this.validationUtil.isValid(dto)) {
                        if (this.userRepository.getByFirstNameAndLastNameAndAge(dto.getFirstName(), dto.getLastName(), dto.getAge()) != null) {
                            System.out.println("This user is already seeded.");
                        } else {
                            this.userRepository.saveAndFlush(this.modelMapper.map(dto, User.class));
                        }
                    } else {
                        this.validationUtil.getViolations(dto)
                                .stream()
                                .map(ConstraintViolation::getMessage)
                                .forEach(System.out::println);
                    }
                });
    }

    @Override
    public User getRandomUser() {
        long randomId = this.random.nextInt((int) this.userRepository.count()) + 1;
        return this.userRepository.getById(randomId);
    }

    @Transactional
    @Override
    public UserViewSoldProductsRootDto getUsersWithSoldProductsToBuyers() {
        List<User> usersWhoSold = userRepository.findAllByProductsSoldIsNotNullOrderByLastNameAscFirstNameAsc();
        List<UserSoldProductsDto> userSoldProductsDtos = usersWhoSold.stream()
                .map(user -> {
                    List<ProductSoldDto> productSoldDtos = user.getProductsSold()
                            .stream()
                            .filter(product -> product.getBuyer() != null)
                            .map(product -> {
                                return this.modelMapper.map(product, ProductSoldDto.class);
                            })
                            .collect(Collectors.toList());
                    UserSoldProductsDto userSoldDto = this.modelMapper.map(user, UserSoldProductsDto.class);
                    ProductViewSoldRootDto rootList = new ProductViewSoldRootDto();
                    rootList.setProducts(productSoldDtos);
                    userSoldDto.setSoldProductsDtos(rootList);
                    return userSoldDto;
                }).collect(Collectors.toList());

        UserViewSoldProductsRootDto rootDto = new UserViewSoldProductsRootDto();
        rootDto.setUsers(userSoldProductsDtos.stream()
                .filter(dto -> !dto.getSoldProducts().getProducts().isEmpty())
                .collect(Collectors.toList()));

        return rootDto;
    }

    @Transactional
    @Override
    public UserListCountDto findAllWhereProductsSoldIsGreaterThanZeroOrderByCountOfProductsSoldDescLastNameAsc() {
        List<User> entities = this.userRepository.findAllWhereProductsSoldIsGreaterThanZeroOrderByCountOfProductsSoldDescLastNameAsc();

        List<UserFnLnAgeSoldPrDto> userFnLnAgeSPrDtos = entities.stream()
                .map(entity -> {
                    UserFnLnAgeSoldPrDto userFullDto = this.modelMapper.map(entity, UserFnLnAgeSoldPrDto.class);
                    ProductCountAndListDto prCountListDto = new ProductCountAndListDto();
                    prCountListDto.setProducts(new ArrayList<>());
                    entity.getProductsSold()
                            .forEach(product -> {
                                prCountListDto.getProducts().add(this.modelMapper.map(product, ProductNameAndPriceDto.class));
                            });
                    prCountListDto.setCount(prCountListDto.getProducts().size());
                    userFullDto.setSoldProducts(prCountListDto);
                    return userFullDto;
                })
                .collect(Collectors.toList());

        UserListCountDto userListCountDto = new UserListCountDto();
        userListCountDto.setUsers(userFnLnAgeSPrDtos);
        userListCountDto.setUsersCount(userListCountDto.getUsers().size());

        return userListCountDto;
    }
}
