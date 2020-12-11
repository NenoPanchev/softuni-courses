package oldCounterStriker.models.players;

import oldCounterStriker.models.guns.Gun;

public class CounterTerrorist extends PlayerImpl{
    public CounterTerrorist(String username, int health, int armor, Gun gun) {
        super(username, health, armor, gun);
    }
}
