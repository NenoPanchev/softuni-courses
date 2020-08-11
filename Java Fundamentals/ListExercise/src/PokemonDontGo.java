import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> pokemon = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int index = Integer.parseInt(scan.nextLine());
        int sum = 0;

        while (pokemon.size() > 0) {

            if (index >= 0 && index < pokemon.size()) {
                int value = pokemon.get(index);
                for (int i = 0; i < pokemon.size(); i++) {
                    int currentPokemon = pokemon.get(i);
                    if (i != index && pokemon.get(i) <= pokemon.get(index)) {
                        pokemon.remove(i);
                        pokemon.add(i, currentPokemon + value);
                    } else if (i != index && pokemon.get(i) > pokemon.get(index)) {
                        pokemon.remove(i);
                        pokemon.add(i, currentPokemon - value);
                    }
                }
                sum += pokemon.get(index);
                pokemon.remove(index);
            } else if (index < 0) {
                sum += pokemon.get(0);
                pokemon.remove(0);
                pokemon.add(0, pokemon.get(pokemon.size() - 1));
                int value = pokemon.get(0);
                for (int i = 0; i < pokemon.size(); i++) {
                    int currentPokemon = pokemon.get(i);
                    if (pokemon.get(i) <= value) {
                        pokemon.remove(i);
                        pokemon.add(i, currentPokemon + value);
                    } else if (pokemon.get(i) > value) {
                        pokemon.remove(i);
                        pokemon.add(i, currentPokemon - value);
                    }
                }
            } else if (index >= pokemon.size()) {
                sum += pokemon.get(pokemon.size() - 1);
                pokemon.remove(pokemon.size() - 1);
                pokemon.add(pokemon.get(0));
                int value = pokemon.get(0);
                for (int i = 0; i < pokemon.size(); i++) {
                    int currentPokemon = pokemon.get(i);
                    if (pokemon.get(i) <= value) {
                        pokemon.remove(i);
                        pokemon.add(i, currentPokemon + value);
                    } else if (pokemon.get(i) > value) {
                        pokemon.remove(i);
                        pokemon.add(i, currentPokemon - value);
                    }
                }
            }
            if (pokemon.size() == 0) break;
            index = Integer.parseInt(scan.nextLine());
        }
        System.out.println(sum);
    }
}
