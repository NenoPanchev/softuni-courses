package spring.web.exams.andreys.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.web.exams.andreys.model.entity.Category;
import spring.web.exams.andreys.model.entity.CategoryName;
import spring.web.exams.andreys.model.service.CategoryServiceModel;
import spring.web.exams.andreys.repositories.CategoryRepository;
import spring.web.exams.andreys.services.CategoryService;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initCategories() {
        if (this.categoryRepository.count() == 0) {
            Arrays.stream(CategoryName.values())
                    .forEach(categoryName -> {
                        this.categoryRepository
                                .save(new Category(categoryName,
                                        String.format("Description for %s",
                                                categoryName.name())));
                    });
        }
    }

    @Override
    public CategoryServiceModel findByCategoryName(CategoryName categoryName) {
        Category category = this.categoryRepository.findByName(categoryName).orElse(null);
        CategoryServiceModel csm = this.modelMapper.map(category, CategoryServiceModel.class);

        return csm;
    }
}
