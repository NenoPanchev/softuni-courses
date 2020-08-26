package PetClinics;

public class Pet {
    String name;
    int age;
    String kind;

    public Pet(String name, int age, String kind) {
        this.name = name;
        this.age = age;
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getKind() {
        return kind;
    }

    @Override
    public String toString() {
        return this.getName() + " " + this.getAge() + " " + this.getKind();
    }
}
