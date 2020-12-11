package CounterStriker.models.guns;

public class Pistol extends GunImpl{
    public Pistol(String name, int bulletsCount) {
        super(name, bulletsCount);
        setNUMBER_OF_BULLETS_PER_FIRING(1);
    }
}
