package web.exams.coffeeshop.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import web.exams.coffeeshop.service.CategoryService;

@Component
public class AppInitialization implements CommandLineRunner {
    private final CategoryService categoryService;

    public AppInitialization(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        categoryService.seedCategories();
    }
}
