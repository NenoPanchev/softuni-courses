package com.example.springdataadvancedqueryinglab.domain.init;

import com.example.springdataadvancedqueryinglab.domain.services.IngredientService;
import com.example.springdataadvancedqueryinglab.domain.services.LabelService;
import com.example.springdataadvancedqueryinglab.domain.services.ShampooService;
import com.example.springdataadvancedqueryinglab.domain.utils.ConsoleReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AppInitializer implements CommandLineRunner {
    private final ConsoleReader consoleReader;
    private final ShampooService shampooService;
    private final IngredientService ingredientService;
    private final LabelService labelService;

    @Autowired
    public AppInitializer(ConsoleReader consoleReader, ShampooService shampooService, IngredientService ingredientService, LabelService labelService) {
        this.consoleReader = consoleReader;
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
        this.labelService = labelService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello, fellow student :)");

        while (true) {
            System.out.println("Enter the number of problem you wish to check or 0 to exit:");
            int problem = Integer.parseInt(consoleReader.readLine());

            try {
                switch (problem) {
                    case 0:
                        System.out.println("Goodbye! :)");
                        System.exit(0);

                    case 1:
                        System.out.println("Enter size to get shampoos by:");
                        String size = consoleReader.readLine().toUpperCase();

                        this.shampooService.selectShampoosBySizeEx1(size)
                        .forEach(System.out::println);
                        break;

                    case 2:
                        System.out.println("Enter shampoo size:");
                        String shampooSize = consoleReader.readLine().toUpperCase();
                        System.out.println("Enter label ID:");
                        int labelId = Integer.parseInt(consoleReader.readLine());

                        this.shampooService.selectShampoosBySizeOrLabelEx2(shampooSize, labelId)
                        .forEach(System.out::println);
                        break;

                    case 3:
                        System.out.println("Enter price to select more expensive shampoos:");
                        String price = consoleReader.readLine();

                        this.shampooService.selectShampoosByPriceEx3(price)
                        .forEach(System.out::println);
                        break;
                    case 4:
                        System.out.println("Enter pattern to select ingredients which names start with it:");
                        String pattern = consoleReader.readLine();

                        this.ingredientService.selectIngredientsByNameEx4(pattern)
                                .forEach(ingredient -> System.out.println(ingredient.getName()));
                        break;
                    case 5:
                        System.out.println("Enter an ingredient to look for:");
                        List<String> names = new ArrayList<>();
                        String ingredientName = consoleReader.readLine();
                        names.add(ingredientName);

                        while (!"find".equals(ingredientName)) {
                            System.out.println("Enter another ingredient to add for looking or enter 'find' to get result:");
                            ingredientName = consoleReader.readLine();
                            names.add(ingredientName);
                        }

                        this.ingredientService.selectIngredientsByNamesEx5(names)
                        .forEach(ingredient -> System.out.println(ingredient.getName()));
                        break;
                    case 6:
                        System.out.println("Enter a price, to get the count of all cheaper shampoos:");
                        String shampooPrice = consoleReader.readLine();

                        System.out.println(this.shampooService.countShampoosByPriceEx6(shampooPrice));
                        break;
                    case 7:
                        System.out.println("Enter an ingredient to look for:");
                        String ingredient = consoleReader.readLine();
                        List<String > ingredientNames = new ArrayList<>();
                        ingredientNames.add(ingredient);

                        while (!"find".equals(ingredient)) {
                            System.out.println("Enter another ingredient to add for looking or enter 'find' to get result:");
                            ingredient = consoleReader.readLine();
                            ingredientNames.add(ingredient);
                        }

                        this.shampooService.selectShampoosByIngredientsEx7(ingredientNames)
                        .forEach(shampoo -> System.out.println(shampoo.getBrand()));
                        break;
                    case 8:
                        System.out.println("Enter a number of ingredients to get all shampoos with less ingredients:");
                        int numberOfIngredients = Integer.parseInt(consoleReader.readLine());

                        this.shampooService.selectShampoosByIngredientsCountEx8(numberOfIngredients)
                        .forEach(shampoo -> System.out.println(shampoo.getBrand()));
                        break;

                    case 9:
                        System.out.println("Enter the name of ingredient you wish to delete from database:");
                        String ingredientToDelete = consoleReader.readLine();

                        this.ingredientService.deleteIngredientsByNameEx9(ingredientToDelete);
                        break;

                    case 10:
                        System.out.println("Enter percentage to increase ingredients price with: Ex (10)");
                        String percent = consoleReader.readLine();
                        this.ingredientService.updateIngredientsByPriceEx10(percent);
                        break;

                    case 11:
                        System.out.println("Enter percentage to increase ingredients price with: Ex (10)");
                        String percentage = consoleReader.readLine();
                    System.out.println("Enter an ingredient to update its price:");
                    String name = consoleReader.readLine();
                    List<String > ingredients = new ArrayList<>();
                    ingredients.add(name);

                    while (!"update".equals(name)) {
                        System.out.println("Enter another ingredient to add in updating query or enter 'update' to update the price of the added so far:");
                        name = consoleReader.readLine();
                        ingredients.add(name);
                    }
                    this.ingredientService.updateIngredientsByNamesEx11(percentage, ingredients);
                        break;
                    default:
                        System.out.println("Incorrect exercise. Try again.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }
}
