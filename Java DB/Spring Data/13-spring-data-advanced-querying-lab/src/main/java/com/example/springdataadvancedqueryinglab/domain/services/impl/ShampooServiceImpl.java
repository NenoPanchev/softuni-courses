package com.example.springdataadvancedqueryinglab.domain.services.impl;

import com.example.springdataadvancedqueryinglab.domain.entities.Ingredient;
import com.example.springdataadvancedqueryinglab.domain.entities.Label;
import com.example.springdataadvancedqueryinglab.domain.entities.Shampoo;
import com.example.springdataadvancedqueryinglab.domain.entities.Size;
import com.example.springdataadvancedqueryinglab.domain.repositories.ShampooRepository;
import com.example.springdataadvancedqueryinglab.domain.services.LabelService;
import com.example.springdataadvancedqueryinglab.domain.services.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShampooServiceImpl implements ShampooService {
    private final ShampooRepository shampooRepository;
    private final LabelService labelService;

    @Autowired
    public ShampooServiceImpl(ShampooRepository shampooRepository, LabelService labelService) {
        this.shampooRepository = shampooRepository;
        this.labelService = labelService;
    }

    @Override
    public List<Shampoo> selectShampoosBySizeEx1(String size) {
        return this.shampooRepository.findAllBySizeOrderById(Size.valueOf(size));
    }

    @Override
    public List<Shampoo> selectShampoosBySizeOrLabelEx2(String  size, int labelId) {
        Label label = this.labelService.getLabelById((long) labelId);
        return this.shampooRepository.findAllBySizeOrLabelOrderByPriceAsc(Size.valueOf(size), label);
    }

    @Override
    public List<Shampoo> selectShampoosByPriceEx3(String price) {
        return this.shampooRepository.findAllByPriceGreaterThanOrderByPriceDesc(new BigDecimal(price));
    }

    @Override
    public int countShampoosByPriceEx6(String price) {
        return this.shampooRepository.countByPriceLessThan(new BigDecimal(price));
    }

    @Override
    public List<Shampoo> selectShampoosByIngredientsEx7(List<String> ingredientNames) {
        return this.shampooRepository.selectShampoosByIngredients(ingredientNames);
    }

    @Override
    public List<Shampoo> selectShampoosByIngredientsCountEx8(int countOfIngredients) {
        return this.shampooRepository.selectShampoosByIngredientsCount(countOfIngredients);
    }

    @Override
    public List<Shampoo> selectShampoosByIngredient(Ingredient ingredient) {
        return this.shampooRepository.findAllByIngredient(ingredient);
    }


}
