package spring.fundamentals.springbootex.services;


import spring.fundamentals.springbootex.models.entities.Product;

public interface ProductService {
    void seedProduct(String[] input);
    Product getByName(String name);

}
