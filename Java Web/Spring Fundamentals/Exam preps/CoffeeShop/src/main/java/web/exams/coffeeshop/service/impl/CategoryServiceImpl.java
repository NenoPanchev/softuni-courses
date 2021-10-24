package web.exams.coffeeshop.service.impl;

import org.springframework.stereotype.Service;
import web.exams.coffeeshop.model.entity.Category;
import web.exams.coffeeshop.model.entity.CategoryNameEnum;
import web.exams.coffeeshop.repository.CategoryRepository;
import web.exams.coffeeshop.service.CategoryService;

import java.util.Arrays;

import static web.exams.coffeeshop.model.entity.CategoryNameEnum.CAKE;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategories() {
        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryNameEnum.values())
                    .forEach(categoryNameEnum -> {
                        Category category = new Category()
                                .setName(categoryNameEnum);

                        switch (categoryNameEnum){
                            case DRINK -> category.setNeededTime(1);
                            case COFFEE -> category.setNeededTime(2);
                            case OTHER -> category.setNeededTime(5);
                            case CAKE -> category.setNeededTime(10);
                        }
                        categoryRepository.save(category);
                    });
        }

    }

    @Override
    public Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum) {
        return categoryRepository.findByName(categoryNameEnum).orElse(null);
    }
}
