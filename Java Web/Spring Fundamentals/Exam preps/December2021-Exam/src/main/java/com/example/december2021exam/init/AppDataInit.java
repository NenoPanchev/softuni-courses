package com.example.december2021exam.init;

import com.example.december2021exam.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppDataInit implements CommandLineRunner {
    private final CategoryService categoryService;

    public AppDataInit(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        categoryService.seedCategories();
    }
}
