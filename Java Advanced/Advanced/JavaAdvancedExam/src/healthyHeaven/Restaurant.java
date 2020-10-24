package healthyHeaven;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Restaurant {
    private String name;
    private List<Salad> data;

    public Restaurant(String name) {
        this.name = name;
        this.data = new ArrayList<>();
    }

    public void add(Salad salad) {
        this.data.add(salad);
    }

    public boolean buy(String name) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name)) {
                this.data.remove(i);
                return true;
            }
        }
        return false;
    }

    public Salad getHealthiestSalad() {
        return this.data.stream().min(Comparator.comparingInt(Salad::getTotalCalories))
                .orElse(null);
    }

    public String generateMenu() {
        StringBuilder sb = new StringBuilder(String.format("%s have %d salads:%n", this.name, this.data.size()));
        this.data
                .forEach(s -> sb.append(s.toString().trim()).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
