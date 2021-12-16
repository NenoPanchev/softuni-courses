package com.example.december2021exam.service;

import com.example.december2021exam.model.service.ProductServiceModel;
import com.example.december2021exam.model.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void addProduct(ProductServiceModel productServiceModel);
    List<ProductViewModel> findAllFoodProducts();
    List<ProductViewModel> findAllDrinkProducts();
    List<ProductViewModel> findAllHouseholdProducts();
    List<ProductViewModel> findAllOtherProducts();
    BigDecimal sumOfAllPrices();
    void delete(Long id);
    void deleteAll();
}
