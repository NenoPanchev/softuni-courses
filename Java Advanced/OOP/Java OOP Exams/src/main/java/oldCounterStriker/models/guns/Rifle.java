package oldCounterStriker.models.guns;

public class Rifle extends GunImpl{
    public Rifle(String name, int bulletsCount) {
        super(name, bulletsCount);
        this.setBULLETS_TO_FIRE_AT_ONCE(10);
    }
}
