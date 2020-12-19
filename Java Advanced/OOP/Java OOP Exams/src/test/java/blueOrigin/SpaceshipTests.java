package blueOrigin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpaceshipTests {
        private Spaceship spaceship;

        @Before
    public void setUp() {
            spaceship = new Spaceship("Apollo", 4);
            Astronaut first = new Astronaut("Alice", 80.5);
            Astronaut second = new Astronaut("Bob", 68.0);
            Astronaut third = new Astronaut("Charlie", 70);
            spaceship.add(first);
            spaceship.add(second);
            spaceship.add(third);
        }

        @Test
    public void constructorShouldCreateEmptyList() {
            Spaceship spaceship2 = new Spaceship("Voyager", 5);
            assertEquals(0, spaceship2.getCount());
        }

        @Test (expected = IllegalArgumentException.class)
    public void constructorShouldThrowIfGivenNegativeCapacity() {
            Spaceship spaceship2 = new Spaceship("Voyager", -5);
        }

    @Test (expected = NullPointerException.class)
    public void constructorShouldThrowIfGivenNullName() {
        Spaceship spaceship2 = new Spaceship(null, 5);
    }

    @Test (expected = NullPointerException.class)
    public void constructorShouldThrowIfGivenEmptyName() {
        Spaceship spaceship2 = new Spaceship("", 5);
    }

    @Test
    public void testGetCount() {
            assertEquals(3, spaceship.getCount());
    }

    @Test
    public void testGetCapacity() {
        assertEquals(4, spaceship.getCapacity());
    }

    @Test
    public void testGetName() {
            assertEquals("Apollo", spaceship.getName());
    }

    @Test (expected = IllegalArgumentException.class)
    public void addShouldThrowIfFull() {
        Astronaut fourth = new Astronaut("Dean", 70);
        Astronaut fifth = new Astronaut("Karen", 70);
        spaceship.add(fourth);
        spaceship.add(fifth);
    }

    @Test (expected = IllegalArgumentException.class)
    public void addShouldThrowIfGivenSameAustronaut() {
        Astronaut fourth = new Astronaut("Bob", 68.0);
        spaceship.add(fourth);
    }

    @Test
    public void removeShouldReturnTrueIfRemoved() {
            assertTrue(spaceship.remove("Bob"));
    }

    @Test
    public void removeShouldReturnFalseIfNotRemoved() {
        assertFalse(spaceship.remove("Zai"));
    }
}
