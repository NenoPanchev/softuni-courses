package aquarium;

import java.util.LinkedHashMap;
import java.util.Map;

public class Aquarium {
    private String name;
    private int capacity;
    private int size;
    private Map<String, Fish> pool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.pool = new LinkedHashMap<>();
    }

    public int getFishInPool() {
        return this.pool.size();
    }

    public void add(Fish fish) {
        if (this.pool.size() < this.capacity) {
            this.pool.putIfAbsent(fish.getName(), fish);
        }
    }

    public boolean remove(String name) {
        for (String fish : this.pool.keySet()) {
            if (fish.equals(name)) {
                this.pool.remove(fish);
                return true;
            }
        }
        return false;
    }

    public Fish findFish(String name) {
        return this.pool.entrySet().stream()
                .filter(fish -> fish.getKey().equals(name))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);
    }

    public String report() {
        StringBuilder sb = new StringBuilder(String.format("Aquarium: %s * Size: %d%n",
                this.name,
                this.size));
        this.pool.values().forEach(fish -> sb.append(fish).append(System.lineSeparator()));
        return sb.toString().trim();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getSize() {
        return this.size;
    }
}
