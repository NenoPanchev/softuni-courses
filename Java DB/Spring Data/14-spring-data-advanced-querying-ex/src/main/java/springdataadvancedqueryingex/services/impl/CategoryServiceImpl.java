package springdataadvancedqueryingex.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdataadvancedqueryingex.entities.Category;
import springdataadvancedqueryingex.repositories.CategoryRepository;
import springdataadvancedqueryingex.services.CategoryService;
import springdataadvancedqueryingex.utils.FileUtil;

import java.io.IOException;
import java.util.Arrays;

import static springdataadvancedqueryingex.constants.GlobalConstants.*;
import static springdataadvancedqueryingex.constants.GlobalConstants.CATEGORY_FILE_PATH;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final FileUtil fileUtil;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, FileUtil fileUtil) {
        this.categoryRepository = categoryRepository;
        this.fileUtil = fileUtil;
    }


    @Override
    public void seedCategories() throws IOException {
        if (this.categoryRepository.count() != 0) {
            return;
        }

        String[] fileContent = this.fileUtil.readFileContent(CATEGORY_FILE_PATH);

        Arrays.stream(fileContent)
                .forEach(r -> {
                    Category category = new Category(r);
                    this.categoryRepository.saveAndFlush(category);
                });
    }

    @Override
    public Category getCategoryById(Long id) {
        return this.categoryRepository.getOne(id);
    }

    @Override
    public int getAllCategoryCount() {
        return (int) this.categoryRepository.count();
    }
}
