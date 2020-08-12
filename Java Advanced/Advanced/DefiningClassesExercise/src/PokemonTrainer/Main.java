package PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Set<Trainer> trainers = new LinkedHashSet<>();

        while (!"Tournament".equals(input)) {
            String[] tokens = input.split("\\s+");
            String trainer = tokens[0];
            String pokemon = tokens[1];
            String element = tokens[2];
            int healthOfPokemon = Integer.parseInt(tokens[3]);
            Pokemon currentPokemon = new Pokemon(pokemon, element, healthOfPokemon);
            if (!containsTrainer(trainers, trainer)) {
                Trainer currentTrainer = new Trainer(trainer);
                currentTrainer.addPokemon(currentPokemon);
                trainers.add(currentTrainer);
            } else {
                trainers.stream().filter(tr -> tr.getName().equals(trainer)).findFirst().get().addPokemon(currentPokemon);
            }


            input = scan.nextLine();
        }

        input = scan.nextLine();

        while (!"End".equals(input)) {
            String element = input;
            for (Trainer trainer : trainers) {
                trainer.checkForElement(element);
            }

            input = scan.nextLine();
        }

        trainers.stream()
                .sorted((a, b) -> Integer.compare(b.badges, a.badges))
                .forEach(trainer -> System.out.printf("%s %d %d%n", trainer.getName(), trainer.getBadges(), trainer.getList().size()));
    }
    static boolean containsTrainer(Set<Trainer> list, String trainer) {
        for (Trainer trainer1 : list) {
            if (trainer1.getName().equals(trainer))
                return true;
        }

        return false;
    }
}
