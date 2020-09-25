package animalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name.length() < 1 || name.equals(" ") || name.equals(null) || name.equals("")) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public double productPerDay() {
        return calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        double eggsPerDay = 0;
        if (this.getAge() >= 0 && this.getAge() <= 5) {
            eggsPerDay = 2;
        } else if (this.getAge() > 5 && this.getAge() <= 11) {
            eggsPerDay = 1;
        } else {
            eggsPerDay = 0.75;
        }
        return eggsPerDay;
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.",
                this.name
                , this.age
                , productPerDay());
    }
}
