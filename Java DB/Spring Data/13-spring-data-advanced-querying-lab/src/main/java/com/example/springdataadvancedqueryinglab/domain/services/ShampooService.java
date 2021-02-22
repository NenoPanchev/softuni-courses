package com.example.springdataadvancedqueryinglab.domain.services;

import com.example.springdataadvancedqueryinglab.domain.entities.Ingredient;
import com.example.springdataadvancedqueryinglab.domain.entities.Shampoo;

import java.util.Collection;
import java.util.List;

public interface ShampooService {
    List<Shampoo> selectShampoosBySizeEx1(String  size);
    List<Shampoo> selectShampoosBySizeOrLabelEx2(String  size, int labelId);
    List<Shampoo> selectShampoosByPriceEx3(String price);
    int countShampoosByPriceEx6(String price);
    List<Shampoo> selectShampoosByIngredientsEx7(List<String> ingredientNames);
    List<Shampoo> selectShampoosByIngredientsCountEx8(int countOfIngredients);
    List<Shampoo> selectShampoosByIngredient(Ingredient ingredient);
}
