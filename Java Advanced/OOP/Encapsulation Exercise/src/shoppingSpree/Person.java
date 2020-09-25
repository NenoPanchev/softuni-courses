package shoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) throws IllegalArgumentException {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name.trim();
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (this.money < product.getCost()) {
            throw new IllegalStateException(String.format("%s can't afford %s", this.name, product.getName()));
        }
        setMoney(this.money - product.getCost());
        this.products.add(product);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.name + " - ");
        if (this.products.isEmpty()) {
            sb.append("Nothing bought");
        } else {
            for (Product product : this.products) {
                sb.append(product.getName()).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length() - 1);
        }
        return sb.toString();
    }
}

