import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Instock implements ProductStock {
    private List<Product> list;

    public Instock() {
        this.list = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean contains(Product product) {
        for (Product product1 : this.list) {
            if (product.getLabel().equals(product1.getLabel())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(Product product) {
       if (!contains(product))
        this.list.add(product);
    }

    @Override
    public void changeQuantity(String product, int quantity) {
        for (Product product1 : this.list) {
            if (product1.getLabel().equals(product)) {
                product1.setQuantity(quantity);
                return;
            }
        }
        throw new IllegalArgumentException("Product not found");
    }

    @Override
    public Product find(int index) {
        if (index <= 0 || index > this.list.size()) {
            throw new IndexOutOfBoundsException();
        }
        return this.list.get(index - 1);
    }

    @Override
    public Product findByLabel(String label) {
        for (Product product1 : this.list) {
            if (product1.getLabel().equals(label)) {
                return product1;
            }
        }
        throw new IllegalArgumentException("Product not found");
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        if (count > this.list.size()) {
            return new ArrayList<>();
        } else {
            return this.list.stream()
                    .sorted(Comparator.comparing(Product::getLabel))
                    .limit(count)
                    .collect(Collectors.toList());
        }
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        return this.list.stream()
                .filter(p -> p.getPrice() > lo && p.getPrice() <= hi)
                .sorted(Comparator.comparing(Product::getPrice))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        return this.list.stream()
                .filter(p -> p.getPrice() == price)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        if (count > this.list.size()) {
            throw new IllegalArgumentException("Not enough products");
        }

        return this.list.stream()
                .sorted((a, b) -> Double.compare(b.getPrice(), a.getPrice()))
                .limit(count)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return this.list.stream()
                .filter(p -> p.getQuantity() == quantity)
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<Product> iterator() {
        return this.list.iterator();
    }

    public List<Product> getIterable() {
        return this.list;
    }
}
