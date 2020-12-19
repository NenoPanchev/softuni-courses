package viceCity.models.guns;

public class Pistol extends BaseGun{
    public Pistol(String name) {
        super(name, 10, 100);
        this.setBULLETS_PER_SHOOT(1);
    }
}
