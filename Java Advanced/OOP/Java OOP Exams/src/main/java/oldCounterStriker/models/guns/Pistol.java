package oldCounterStriker.models.guns;

public class Pistol extends GunImpl {
    public Pistol(String name, int bulletsCount) {
        super(name, bulletsCount);
        this.setBULLETS_TO_FIRE_AT_ONCE(1);
    }
}
