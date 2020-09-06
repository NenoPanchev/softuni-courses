package rabbits;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Initialize the repository (Cage)
        Cage cage = new Cage("Wildness", 20);
        //Initialize entity
        Rabbit rabbit = new Rabbit("Fluffy", "Blanc de Hotot");
        //Print Rabbit
        System.out.println(rabbit); // Rabbit (Blanc de Hotot): Fluffy

//Add Rabbit
        cage.add(rabbit);
        System.out.println(cage.count()); //1
//Remove Rabbit
        System.out.println(cage.removeRabbit("Rabbit Name"));

        Rabbit secondRabbit = new Rabbit("Bunny", "Brazilian");
        Rabbit thirdRabbit = new Rabbit("Jumpy", "Cashmere Lop");
        Rabbit fourthRabbit = new Rabbit("Puffy", "Cashmere Lop");
        Rabbit fifthRabbit = new Rabbit("Marlin", "Brazilian");
        Rabbit sixthRabbit = new Rabbit("Zaek", "Bulgarian");

//Add Rabbits
        cage.add(secondRabbit);
        cage.add(thirdRabbit);
        cage.add(fourthRabbit);
        cage.add(fifthRabbit);
        cage.add(sixthRabbit);

//Sell Rabbit by name
        System.out.println(cage.sellRabbit("Bunny")); //Rabbit (Brazilian): Bunny

        cage.removeSpecies("Cashmere Lop");
//Sell Rabbit by species
        List<Rabbit> soldSpecies = cage.sellRabbitBySpecies(("Brazilian"));

        soldSpecies.forEach(f-> {
            System.out.println(f.getName());

        });
        //Jumpy
        //Puffy

        System.out.println(cage.report());

        System.out.println(cage.count());
        System.out.println(cage.removeRabbit("Fluffy"));
        System.out.println(cage.count());
        System.out.println(cage.removeRabbit("Pesho"));
        System.out.println(cage.count());
        cage.sellRabbitBySpecies("Bulgarian");
        System.out.println(cage.report());
        System.out.println(cage.count());
//Rabbits available at Wildness:
//Rabbit (Blanc de Hotot): Fluffy
//Rabbit (Brazilian): Marlin

    }
}
