package computers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ComputerTest {
    private Computer computer;

    @Before
    public void setUp() {
        computer = new Computer("Nitro 5");
        computer.addPart(new Part("SSD", 120.50));
        computer.addPart(new Part("Video Card", 550.50));
        computer.addPart(new Part("CPU", 370.80));
        computer.addPart(new Part("Motherboard", 140.20));
    }

    @Test (expected = IllegalArgumentException.class)
    public void constructorShouldThrowIfGivenNullAsName() {
        Computer pc = new Computer(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void constructorShouldThrowIfGivenEmptySpaceAsName() {
        Computer pc = new Computer("");
    }

    @Test
    public void constructorShouldCreateEmptyList() {
        Computer pc = new Computer("  ");
        assertNotNull(pc.getParts());
    }

    @Test
    public void testGetName() {
        assertEquals("Nitro 5", computer.getName());
    }

    @Test (expected = UnsupportedOperationException.class)
    public void getPartsShouldReturnUnmodifiableList() {
        computer.getParts().add(new Part("RAM", 370.80));
    }

    @Test
    public void testGetTotalPrice() {
        assertEquals(1182.0, computer.getTotalPrice(), 0.001);
    }

    @Test (expected = IllegalArgumentException.class)
    public void addPartShouldThrowIfNull() {
        computer.addPart(null);
    }

    @Test
    public void testAddPart() {
        computer.addPart(new Part("RAM", 100));
        assertEquals("RAM", computer.getParts().get(4).getName());
    }

    @Test
    public void removePartShouldReturnTrueIfRemoved() {
        Part part = new Part("RAM", 100);
        computer.addPart(part);
        assertTrue(computer.removePart(part));
        assertEquals(140.20, computer.getParts().get(3).getPrice(), 0.01);
    }

    @Test
    public void removePartShouldReturnFalseIfNoSuchPartExists() {
        Part part = new Part("RAM", 100);
        assertFalse(computer.removePart(part));
    }

    @Test
    public void testGetPart() {
        Part part = computer.getPart("CPU");
        assertEquals(370.80, part.getPrice(), 0.001);
    }
}