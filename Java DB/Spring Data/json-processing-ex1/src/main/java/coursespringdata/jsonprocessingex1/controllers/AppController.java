package coursespringdata.jsonprocessingex1.controllers;

import com.google.gson.Gson;
import coursespringdata.jsonprocessingex1.models.dtos.CategorySeedDto;
import coursespringdata.jsonprocessingex1.models.dtos.ProductSeedDto;
import coursespringdata.jsonprocessingex1.models.dtos.UserSeedDto;
import coursespringdata.jsonprocessingex1.services.CategoryProductService;
import coursespringdata.jsonprocessingex1.services.CategoryService;
import coursespringdata.jsonprocessingex1.services.ProductService;
import coursespringdata.jsonprocessingex1.services.UserService;
import coursespringdata.jsonprocessingex1.utils.FileIOUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static coursespringdata.jsonprocessingex1.constants.GlobalConstants.*;

@Component
public class AppController implements CommandLineRunner {
    private final Gson gson;
    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    private final FileIOUtil fileIOUtil;
    private final CategoryProductService categoryProductService;

    @Autowired
    public AppController(Gson gson, CategoryService categoryService, UserService userService, ProductService productService, FileIOUtil fileIOUtil, CategoryProductService categoryProductService) {
        this.gson = gson;
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        this.fileIOUtil = fileIOUtil;
        this.categoryProductService = categoryProductService;
    }

    @Override
    public void run(String... args) throws Exception {

        // Seed the Database
        this.seedCategories();
        this.seedUsers();
        this.seedProducts();

        // First Query - Products in price range 500 to 1000 with no Buyer Ordered by Price Asc
        this.fileIOUtil.write(this.gson.toJson(productService.getProductsIn500To1000RangeWithBuyerNullOrderedByPrice()), QUERY_01_PATH);

        // Second Query - Users with Sold products with buyer
        this.fileIOUtil.write(this.gson.toJson(userService.getUsersWithSoldProductsToBuyers()), QUERY_02_PATH);

        // Third Query - Categories by products count
        this.fileIOUtil.write(this.gson.toJson(categoryProductService.getAllCategoriesByProductCount()), QUERY_03_PATH);

        // Fourth Query - Users and sold products info
        this.fileIOUtil.write(this.gson.toJson(userService
                .findAllWhereProductsSoldIsGreaterThanZeroOrderByCountOfProductsSoldDescLastNameAsc()), QUERY_04_PATH);
    }

    private void seedProducts() throws FileNotFoundException {
        ProductSeedDto[] dtos = this.gson
                .fromJson(new FileReader(PRODUCTS_FILE_PATH), ProductSeedDto[].class);

        this.productService.seedProducts(dtos);
    }

    private void seedUsers() throws FileNotFoundException {
        UserSeedDto[] dtos = this.gson
                .fromJson(new FileReader(USERS_FILE_PATH), UserSeedDto[].class);

        this.userService.seedUsers(dtos);
    }

    private void seedCategories() throws FileNotFoundException {
        CategorySeedDto[] dtos = this.gson
                .fromJson(new FileReader(CATEGORIES_FILE_PATH),
                        CategorySeedDto[].class);

        this.categoryService.seedCategories(dtos);
    }
}
