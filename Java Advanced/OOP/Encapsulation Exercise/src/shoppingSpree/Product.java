package shoppingSpree;

public class Product {
    private String name;
    private double cost;

    public Product(String name, double cost) throws IllegalArgumentException {
        this.setName(name);
        this.setCost(cost);
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

    public double getCost() {
        return this.cost;
    }

    private void setCost(double cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.cost = cost;
    }
}
