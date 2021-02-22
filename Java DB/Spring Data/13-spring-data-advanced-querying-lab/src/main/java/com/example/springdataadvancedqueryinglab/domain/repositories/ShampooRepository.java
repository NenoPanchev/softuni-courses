package com.example.springdataadvancedqueryinglab.domain.repositories;

import com.example.springdataadvancedqueryinglab.domain.entities.Ingredient;
import com.example.springdataadvancedqueryinglab.domain.entities.Label;
import com.example.springdataadvancedqueryinglab.domain.entities.Shampoo;
import com.example.springdataadvancedqueryinglab.domain.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
    List<Shampoo> findAllBySizeOrderById(Size size);
    List<Shampoo> findAllBySizeOrLabelOrderByPriceAsc(Size size, Label label);
    List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price);
    int countByPriceLessThan(BigDecimal price);

    @Query("SELECT s FROM shampoos AS s " +
            "JOIN s.ingredients AS i " +
            "WHERE i.name IN :ingredientNames")
    List<Shampoo> selectShampoosByIngredients(@Param("ingredientNames") List<String> ingredientNames);

    @Query("SELECT DISTINCT s FROM shampoos AS s " +
            "JOIN s.ingredients AS i " +
            "WHERE s.ingredients.size < :count")
    List<Shampoo> selectShampoosByIngredientsCount(@Param("count") int countOfIngredients);

    @Query("SELECT s FROM shampoos AS s " +
            "JOIN s.ingredients AS i " +
            "WHERE i = :ingredient")
    List<Shampoo> findAllByIngredient(Ingredient ingredient);
}
