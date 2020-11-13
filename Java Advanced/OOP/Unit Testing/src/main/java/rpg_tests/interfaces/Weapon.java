package rpg_tests.interfaces;

public interface Weapon {
    public void attack(Target target);

    public int getAttackPoints();

    public int getDurabilityPoints();
}
