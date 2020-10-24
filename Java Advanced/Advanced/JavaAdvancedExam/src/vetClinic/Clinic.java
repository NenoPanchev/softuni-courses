package vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.data.size() < this.capacity) {
            this.data.add(pet);
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

    public Pet getPet(String name, String owner) {
        return this.data.stream()
                .filter(pet -> pet.getName().equals(name) &&
                        pet.getOwner().equals(owner))
                .findFirst().orElse(null);
//        for (int i = 0; i < this.data.size(); i++) {
//            if (this.data.get(i).getName().equals(name) &&
//                    this.data.get(i).getOwner().equals(owner)) {
//                return this.data.get(i);
//            }
//        }
//        return null;
    }

    public Pet getOldestPet() {
        return this.data.stream()
                .sorted((a, b) -> Integer.compare(b.getAge(), a.getAge()))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }


    public String getStatistics() {
        StringBuilder sb = new StringBuilder(String.format("The clinic has the following patients:%n"));
        this.data
                .forEach(pet -> sb.append(String.format("%s %s%n", pet.getName(), pet.getOwner())));
        return sb.toString().trim();
    }
}
