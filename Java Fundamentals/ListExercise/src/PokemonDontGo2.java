import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> pokemon = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int index = Integer.parseInt(scan.nextLine());
        int sum = 0;

       while (pokemon.size() > 0) {

           if (index >= 0 && index < pokemon.size()) {
               int value = pokemon.get(index);
               sum += value;
               pokemon.remove(index);
               resizePokemon(pokemon, value);
           } else if (index < 0) {
               int value = pokemon.get(0);
               sum += value;
               pokemon.remove(0);
               pokemon.add(0, pokemon.get(pokemon.size() - 1));
               resizePokemon(pokemon, value);
           } else if (index >= pokemon.size()) {
               int value = pokemon.get(pokemon.size() - 1);
               sum += value;
               pokemon.remove(pokemon.size() - 1);
               pokemon.add(pokemon.get(0));
               resizePokemon(pokemon, value);
           }
           if (pokemon.size() == 0) break;
           index = Integer.parseInt(scan.nextLine());
       }
        System.out.println(sum);
    }
    static void resizePokemon(List<Integer> list, int value) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) <= value)
            list.set(i, list.get(i) + value);
            else list.set(i, list.get(i) - value);
        }
    }
}
