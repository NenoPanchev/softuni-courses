package exam.shoppinglist.service;

import exam.shoppinglist.model.service.ProductServiceModel;
import exam.shoppinglist.model.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;


public interface ProductService {
    void addProduct(ProductServiceModel productServiceModel);
    List<ProductViewModel> findAllFoodProducts();
    List<ProductViewModel> findAllDrinkProducts();
    List<ProductViewModel> findAllHouseholdProducts();
    List<ProductViewModel> findAllOtherProducts();
    BigDecimal sumOfAllPrices();
    void delete(String id);
    void deleteAll();
}
