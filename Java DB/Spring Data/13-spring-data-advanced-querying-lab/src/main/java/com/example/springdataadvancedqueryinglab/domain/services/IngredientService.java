package com.example.springdataadvancedqueryinglab.domain.services;

import com.example.springdataadvancedqueryinglab.domain.entities.Ingredient;

import java.util.Collection;
import java.util.List;

public interface IngredientService {
    List<Ingredient> selectIngredientsByNameEx4(String pattern);
    List<Ingredient> selectIngredientsByNamesEx5(Collection<String> names);
    int deleteIngredientsByNameEx9(String ingredientName);
    void updateIngredientsByPriceEx10(String price);
    void updateIngredientsByNamesEx11(String price, Collection<String> names);
}
