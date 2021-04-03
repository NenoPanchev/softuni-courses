package spring.fundamentals.springbootex.services;

public interface SellerService {
    void seedSeller(String[] input);

    void setManagerToASeller(String[] input, String[] managerNames);

    void getAllSellersByShopName(String shopName);
}
