package PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    String name;
    List<Pokemon> list;
    int badges;

    Trainer(String name) {
        this.name = name;
        this.list = new ArrayList<>();
        this.badges = 0;
    }

    public String getName() {
        return name;
    }

    public int getBadges() {
        return badges;
    }

    public List<Pokemon> getList() {
        return list;
    }

    public void addPokemon(Pokemon pokemon) {
        this.list.add(pokemon);
    }

    public void addBadge() {
        this.badges++;
    }

    public void remove10HPFromEveryPokemon() {

        for (int i = 0; i < this.list.size(); i++) {
            this.list.get(i).health -= 10;
            if (this.list.get(i).health <= 0) {
                this.list.remove(i);
                i--;
            }
        }
    }

    public void checkForElement(String element) {
        boolean hasPokemonElement = false;
        for (Pokemon pokemon : this.list) {
            if (pokemon.element.equals(element)) {
                hasPokemonElement = true;
                break;
            }
        }
        if (hasPokemonElement) {
            addBadge();
        } else {
            remove10HPFromEveryPokemon();
        }

    }
}
