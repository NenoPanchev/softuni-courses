package CatLady;

public class Cat {
    String type;
    String name;
    double number;

    Cat(String type, String name, double number) {
        this.type = type;
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public double getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f%n", this.type, this.name, this.number);
    }
}
