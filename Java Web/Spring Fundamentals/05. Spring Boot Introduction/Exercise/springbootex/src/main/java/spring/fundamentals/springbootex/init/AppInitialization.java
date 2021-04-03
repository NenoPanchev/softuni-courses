package spring.fundamentals.springbootex.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.fundamentals.springbootex.services.*;

import java.io.BufferedReader;

@Component
public class AppInitialization implements CommandLineRunner {
    private final BufferedReader reader;
    private final CategoryService categoryService;
    private final ProductService productService;
    private final SellerService sellerService;
    private final ShopService shopService;
    private final TownService townService;

    @Autowired
    public AppInitialization(BufferedReader reader, CategoryService categoryService, ProductService productService, SellerService sellerService, ShopService shopService, TownService townService) {
        this.reader = reader;
        this.categoryService = categoryService;
        this.productService = productService;
        this.sellerService = sellerService;
        this.shopService = shopService;
        this.townService = townService;
    }

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            System.out.println("Hi\n" +
                    "Choose option from:\r\n" +
                    "1 - for Add Category\r\n" +
                    "2 - for Add Town\r\n" +
                    "3 - for Add Shop\r\n" +
                    "4 - for Add Seller\r\n" +
                    "5 - for Add Product\r\n" +
                    "6 - for Set seller new manager\r\n" +
                    "7 - for Distributing product in shops\r\n" +
                    "8 - for Showing all sellers in Shop\r\n" +
                    "9 - for Showing all products in Shop\r\n");

            String command = reader.readLine();
            switch (command) {
                case "1":
                    System.out.println("Enter category name:");
                    String categoryName = reader.readLine();
                    this.categoryService.seedCategory(categoryName);
                    break;

                case "2":
                    System.out.println("Enter town name:");
                    String townName = reader.readLine();
                    this.townService.seedTown(townName);
                    break;

                case "3":
                    System.out.println("Enter shop details in format: name address town");
                    String[] input = reader.readLine().split("\\s+");
                    this.shopService.seedShop(input);
                    break;

                case "4":
                    System.out.println("Enter seller details in format: firstName lastName age salary shopName");
                    input = reader.readLine().split("\\s+");
                    this.sellerService.seedSeller(input);
                    break;

                case "5":
                    System.out.println("Enter product details in format: name price bestBefore(dd-MM-yyyy) category");
                    input = reader.readLine().split("\\s+");
                    this.productService.seedProduct(input);
                    break;

                case "6":
                    System.out.println("Enter seller first and last names");
                    input = reader.readLine().split("\\s+");
                    System.out.println("Enter manager first and last names");
                    String[] managerNames = reader.readLine().split("\\s+");
                    this.sellerService.setManagerToASeller(input, managerNames);
                    break;

                case "7":
                    System.out.println("Enter product name:");
                    String productName = reader.readLine();
                    System.out.println("Enter product distribution in Shops names in format [shopName1 shopName2 ...]:");
                    input = reader.readLine().split("\\s+");
                    this.shopService.distributeProductInShops(productName, input);
                    break;

                case "8":
                    System.out.println("Enter shop name:");
                    this.sellerService.getAllSellersByShopName(reader.readLine());
                    break;

                case "9":
                    System.out.println("Enter shop name:");
                    this.shopService.getAllProductsByShopName(reader.readLine());
                    break;
            }
        }
    }
}
