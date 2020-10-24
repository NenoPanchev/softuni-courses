package aquarium;

public class Main {
    public static void main(String[] args) {
        Aquarium aquarium = new Aquarium("Kofa", 5, 10);
        Fish first = new Fish("Pesho", "blue", 2);
        System.out.println(aquarium.getFishInPool());
        aquarium.add(first);
        System.out.println(aquarium.getFishInPool());
        System.out.println(aquarium.findFish("Mira"));
        System.out.println(aquarium.findFish("Pesho"));

        Fish second = new Fish("Mira", "pink", 4);
        Fish third = new Fish("Stamat", "red", 3);
        aquarium.add(second);
        aquarium.add(third);

        System.out.println(aquarium.remove("Stamat"));
        System.out.println(aquarium.remove("Mimi"));
        System.out.println(aquarium.getFishInPool());
        System.out.println(aquarium.report());
    }
}
