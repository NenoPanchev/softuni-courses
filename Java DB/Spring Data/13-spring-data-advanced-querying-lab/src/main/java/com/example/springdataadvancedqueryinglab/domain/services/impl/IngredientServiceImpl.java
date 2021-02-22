package com.example.springdataadvancedqueryinglab.domain.services.impl;

import com.example.springdataadvancedqueryinglab.domain.entities.Ingredient;
import com.example.springdataadvancedqueryinglab.domain.repositories.IngredientRepository;
import com.example.springdataadvancedqueryinglab.domain.services.IngredientService;
import com.example.springdataadvancedqueryinglab.domain.services.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;
    private final ShampooService shampooService;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository, ShampooService shampooService) {
        this.ingredientRepository = ingredientRepository;
        this.shampooService = shampooService;
    }

    @Override
    public List<Ingredient> selectIngredientsByNameEx4(String pattern) {
        return this.ingredientRepository.getAllByNameStartingWith(pattern);
    }

    @Override
    public List<Ingredient> selectIngredientsByNamesEx5(Collection<String> names) {
        return this.ingredientRepository.getAllByNameIn(names);
    }

    @Transactional
    @Override
    public int deleteIngredientsByNameEx9(String ingredientName) {
        Ingredient ingredientToDelete = this.ingredientRepository.getByName(ingredientName);
        this.shampooService.selectShampoosByIngredient(ingredientToDelete)
                .forEach(shampoo -> shampoo.getIngredients().remove(ingredientToDelete));

        return this.ingredientRepository.deleteAllByName(ingredientName);
    }

    @Override
    public void updateIngredientsByPriceEx10(String price) {
        this.ingredientRepository.updateAllIngredientsByPrice(new BigDecimal(price));
    }

    @Override
    public void updateIngredientsByNamesEx11(String price, Collection<String> names) {
        this.ingredientRepository.updateAllIngredientsByNames(new BigDecimal(price), names);
    }


}
