package com.example.springdataadvancedqueryinglab.domain.repositories;

import com.example.springdataadvancedqueryinglab.domain.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> getAllByNameStartingWith(String pattern);
    List<Ingredient> getAllByNameIn(Collection<String> names);
    Ingredient getByName(String name);


    @Transactional
    int deleteAllByName(String ingredientName);

    @Transactional
    @Modifying
    @Query("UPDATE ingredients AS i SET i.price = i.price + (i.price * :percentage / 100)")
    void updateAllIngredientsByPrice(@Param("percentage") BigDecimal percent);

    @Transactional
    @Modifying
    @Query("UPDATE ingredients AS i SET i.price = i.price + (i.price * :percentage / 100) " +
            "WHERE i.name IN :names")
    void updateAllIngredientsByNames(@Param("percentage") BigDecimal percent, @Param("names") Collection<String> names);
}
