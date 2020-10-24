package christmas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return this.color;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int count() {
        return this.data.size();
    }

    public void add(Present present) {
        if (this.data.size() < this.capacity) {
            this.data.add(present);
        }
    }

    public boolean remove(String name) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name)) {
                this.data.remove(i);
                return true;
            }
        }
        return false;
    }

    public Present heaviestPresent() {
        return this.data.stream()
                .sorted((a, b) -> Double.compare(b.getWeight(), a.getWeight()))
                .findFirst()
                .orElse(null);
    }

    public Present getPresent(String name) {
        return this.data.stream()
                .filter(pre -> pre.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public String report() {
        StringBuilder sb = new StringBuilder(String.format("%s bag contains:%n", this.color));
        this.data
                .forEach(p -> sb.append(p.toString()).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
