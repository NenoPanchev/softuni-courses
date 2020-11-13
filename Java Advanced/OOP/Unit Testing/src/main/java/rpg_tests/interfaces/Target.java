package rpg_tests.interfaces;

public interface Target {
    public int getHealth();

    public void takeAttack(int attackPoints);

    public int giveExperience();

    public boolean isDead();

    public Weapon getLoot();
}
