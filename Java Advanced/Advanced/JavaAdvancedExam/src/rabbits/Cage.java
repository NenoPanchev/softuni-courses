package rabbits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void add(Rabbit rabbit) {
        if (this.data.size() < this.capacity) {
            this.data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name)) {
                this.data.remove(i);
                return true;
            }
        }
        return false;
    }

    public void removeSpecies(String species) {
        this.data = this.data.stream()
                .filter(r -> !r.getSpecies().equals(species))
                .collect(Collectors.toList());
    }

    public Rabbit sellRabbit(String name) {
        Rabbit rabbit = null;
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name)) {
                this.data.get(i).setAvailable(false);
                rabbit = this.data.get(i);
                break;
            }
        }

        return rabbit;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> list = new ArrayList<>();
        for (int i = 0; i < this.data.size(); i++) {
            Rabbit rabbit = this.data.get(i);
            if (rabbit.getSpecies().equals(species)) {
                rabbit.setAvailable(false);
                list.add(rabbit);
            }
        }
        return list;
    }

    public int count() {
        return this.data.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rabbits available at ").append(this.getName()).append(System.lineSeparator());
        this.data.stream()
                .filter(Rabbit::isAvailable)
                .forEach(x -> sb.append(x.toString()).append(System.lineSeparator()));
        return sb.toString().trim();
    }

    public String report() {
        return toString().trim();
    }
}
