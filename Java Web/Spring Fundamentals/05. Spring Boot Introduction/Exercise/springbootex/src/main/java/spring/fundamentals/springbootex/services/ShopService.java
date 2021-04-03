package spring.fundamentals.springbootex.services;

import spring.fundamentals.springbootex.models.entities.Shop;

public interface ShopService {
    void seedShop(String[] input);
    Shop getByName(String name);

    void distributeProductInShops(String productName, String[] arrayOfShops);

    void getAllProductsByShopName(String shopName);
}
