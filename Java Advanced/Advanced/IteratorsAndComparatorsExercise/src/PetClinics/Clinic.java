package PetClinics;

import java.util.Iterator;
import java.util.List;

public class Clinic {
    private String name;
    private Pet[] list;
    private int size;
    private int addingIndex;
    private int counter = 1;


    public Clinic(String name, int size) {
        this.name = name;
        this.size = size;
        this.addingIndex = size / 2;
        if (size % 2 != 0) {
            this.list = new Pet[size];
        } else {
            throw new UnsupportedOperationException("Invalid Operation!");
        }
    }

    public String getName() {
        return name;
    }

    public Pet[] getList() {
        return list;
    }

    public boolean add(String petName, List<Pet> pets) {
        if (hasSpace()) {
            if (pets.stream().anyMatch(pet -> pet.getName().equals(petName))) {
               this.getList()[addingIndex] = (pets.stream().filter(pet -> pet.getName().equals(petName))
                        .findFirst().get());
                if (counter % 2 != 0) {
                    addingIndex -= counter;
                } else {
                    addingIndex += counter;
                }
                counter++;
                return true;
            } else {
                throw new UnsupportedOperationException("Invalid Operation!");
            }
        } else
            return false;
    }

    public boolean hasSpace() {
        for (Pet pet : this.getList()) {
            if (pet == null)
                return true;
        }
        return false;
    }

    public boolean release() {
        for (int i = this.size / 2; i < this.size; i++) {
            if (this.getList()[i] != null) {
                this.getList()[i] = null;
                return true;
            }
        }
        for (int i = 0; i < this.size / 2; i++) {
            if (this.getList()[i] != null) {
                this.getList()[i] = null;
                return true;
            }
        }
        return false;
    }
}
