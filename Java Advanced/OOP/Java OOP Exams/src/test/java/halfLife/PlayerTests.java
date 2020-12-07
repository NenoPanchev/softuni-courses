package halfLife;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTests {
    private Player player;

    @Before
    public void setUp() {
        player = new Player("Hunter", 100);

        Gun gun1 = new Gun("Makarov", 12);
        Gun gun2 = new Gun("Remington", 50);
        Gun gun3 = new Gun("Glock", 10);

        player.addGun(gun1);
        player.addGun(gun2);
        player.addGun(gun3);
    }

    @Test (expected = NullPointerException.class)
    public void constructorShouldThrowIfGivenNullAsName() {
        Player player2 = new Player(null, 100);
    }

    @Test (expected = NullPointerException.class)
    public void constructorShouldThrowIfGivenWhitespaceAsName() {
        Player player2 = new Player("", 100);
    }

    @Test (expected = IllegalArgumentException.class)
    public void constructorShouldThrowIfGivenNegativeHealth() {
        Player player2 = new Player("Gun", -1);
    }

    @Test
    public void constructorShouldCreateEmptyList() {
        Player player2 = new Player("Gun", 1);
        Assert.assertNotNull(player2.getGuns());
    }

    @Test
    public void testGetUsername() {
        assertEquals("Hunter", player.getUsername());
    }

    @Test
    public void testGetHealth() {
        assertEquals(100, player.getHealth());
    }

    @Test (expected = UnsupportedOperationException.class)
    public void getGunsShouldReturnUnmodifiableList() {
        player.getGuns().add(new Gun("asd", 10));
    }

    @Test (expected = IllegalStateException.class)
    public void takeDamageShouldThrowIfPlayerDead() {
        Player player2 = new Player("Gunner", 0);
        player2.takeDamage(2);
    }

    @Test
    public void takeDamageShouldSetHealthToZeroWhenDamageIsMoreThanHealth() {
        Player player2 = new Player("Gunner", 3);
        player2.takeDamage(8);
        assertEquals(0, player2.getHealth());
    }

    @Test
    public void testTakeDamage() {
        Player player2 = new Player("Gunner", 13);
        player2.takeDamage(8);
        assertEquals(5, player2.getHealth());
    }

    @Test (expected = NullPointerException.class)
    public void addGunShouldThrowIfGivenNull() {
        player.addGun(null);
    }

    @Test
    public void testAddGun() {
        player.addGun(new Gun("Pistol", 15));
        assertEquals("Pistol", this.player.getGuns().get(3).getName());
    }

    @Test
    public void removeGunShouldReturnTrueIfSuccessful() {
        Gun gun = new Gun("Pistol", 15);
        player.addGun(gun);
        assertTrue(player.removeGun(gun));
        assertEquals(3, player.getGuns().size());
        assertEquals(10, player.getGuns().get(player.getGuns().size() - 1).getBullets());
    }

    @Test
    public void removeGunShouldReturnFalseIfGunNotPresent() {
        Gun gun = new Gun("Pistol", 15);
        assertFalse(player.removeGun(gun));
    }

    @Test
    public void testGetGunByName() {
        assertEquals(12, player.getGun("Makarov").getBullets());
    }
}
