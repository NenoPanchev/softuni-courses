package course.springdata.xmlprocessingex1.controllers;

import course.springdata.xmlprocessingex1.constants.GlobalConstants;
import course.springdata.xmlprocessingex1.models.dtos.CategorySeedRootDto;
import course.springdata.xmlprocessingex1.models.dtos.ProductSeedRootDto;
import course.springdata.xmlprocessingex1.models.dtos.UserSeedRootDto;
import course.springdata.xmlprocessingex1.services.CategoryProductService;
import course.springdata.xmlprocessingex1.services.CategoryService;
import course.springdata.xmlprocessingex1.services.ProductService;
import course.springdata.xmlprocessingex1.services.UserService;
import course.springdata.xmlprocessingex1.utils.XmlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

import static course.springdata.xmlprocessingex1.constants.GlobalConstants.*;

@Component
public class AppController implements CommandLineRunner {
    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    private final CategoryProductService categoryProductService;
    private final XmlParser xmlParser;

    @Autowired
    public AppController(CategoryService categoryService, UserService userService, ProductService productService, CategoryProductService categoryProductService, XmlParser xmlParser) {
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        this.categoryProductService = categoryProductService;
        this.xmlParser = xmlParser;
    }

    @Override
    public void run(String... args) throws Exception {

        // Seed the Database
        this.seedUsers();
        this.seedCategories();
        this.seedProducts();

        // First Query - Products in price range 500 to 1000 with no Buyer Ordered by Price Asc
        this.writeFirstQuery();

        // Second Query - Users with Sold products with buyer
        this.writeSecondQuery();

        // Third Query - Categories by products count
        this.writeThirdQuery();

        // Fourth Query - Users and sold products info
        this.writeFourthQuery();
    }

    private void writeFourthQuery() throws JAXBException {
        this.xmlParser
                .marshalToFile(QUERY_04_PATH, this.userService.findAllWhereProductsSoldIsGreaterThanZeroOrderByCountOfProductsSoldDescLastNameAsc());
    }

    private void writeThirdQuery() throws JAXBException {
        this.xmlParser
                .marshalToFile(QUERY_03_PATH, this.categoryProductService.getAllCategoriesByProductCount());
    }

    private void writeSecondQuery() throws JAXBException {
        this.xmlParser
                .marshalToFile(QUERY_02_PATH, this.userService.getUsersWithSoldProductsToBuyers());
    }

    private void writeFirstQuery() throws JAXBException {
        this.xmlParser.marshalToFile(QUERY_01_PATH, this.productService.getProductsIn500To1000RangeWithBuyerNullOrderedByPrice());
    }

    private void seedProducts() throws JAXBException, FileNotFoundException {
        ProductSeedRootDto productSeedRootDto = this.xmlParser
                .unmarshalFromFile(PRODUCTS_FILE_PATH, ProductSeedRootDto.class);

        this.productService.seedProducts(productSeedRootDto.getProducts());
    }

    private void seedUsers() throws FileNotFoundException, JAXBException {
        UserSeedRootDto userSeedRootDto = this.xmlParser.unmarshalFromFile(USERS_FILE_PATH, UserSeedRootDto.class);

        this.userService.seedUsers(userSeedRootDto.getUsers());
    }

    private void seedCategories() throws FileNotFoundException, JAXBException {
        CategorySeedRootDto categorySeedRootDto = this.xmlParser
                .unmarshalFromFile(CATEGORIES_FILE_PATH, CategorySeedRootDto.class);

        this.categoryService.seedCategories(categorySeedRootDto.getCategories());
    }
}
