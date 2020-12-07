package oldComputers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class ComputerManagerTests {
private ComputerManager computerManager;

    @Before
    public void setUp() {
        computerManager = new ComputerManager();
        Computer first = new Computer("Intel", "i9", 333.30);
        Computer second = new Computer("AMD", "Ryzen", 110.50);
        Computer third = new Computer("Apple", "Mac", 250.60);
        computerManager.addComputer(first);
        computerManager.addComputer(second);
        computerManager.addComputer(third);
    }

    @Test
    public void constructorShouldInstantiateClassWithEmptyArrayList() {
        ComputerManager computerManager = new ComputerManager();
        Assert.assertTrue(computerManager.getComputers().isEmpty());
    }

    @Test
    public void getComputersShouldReturnCorrectList() {
        String[] expected = {"Intel", "AMD", "Apple"};
        for (int i = 0; i < 3; i++) {
            assertEquals(expected[i], computerManager.getComputers().get(i).getManufacturer());
        }
    }

    @Test
    public void getCountShouldReturnCorrectSize() {
        assertEquals(3, computerManager.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void addComputerShouldThrowIfGivenNull() {
        computerManager.addComputer(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void addComputerShouldThrowIfGivenSameManufacturerAndModel() {
        Computer third = new Computer("Apple", "Mac", 500);
        computerManager.addComputer(third);
    }

    @Test
    public void testAddComputer() {
        Computer fourth = new Computer("Apple", "Ryzen", 500);
        computerManager.addComputer(fourth);
        assertEquals("Apple", computerManager.getComputers().get(3).getManufacturer());
    }

    @Test
    public void testRemoveComputer() {
        Computer first = new Computer("Intel", "i9", 333.30);
        assertEquals(333.30, computerManager.removeComputer("Intel", "i9").getPrice(), .01);
    }

    @Test (expected = IllegalArgumentException.class)
    public void getComputerShouldThrowIfGivenNullAsManufacturer() {
        computerManager.getComputer(null, "i9");
    }

    @Test (expected = IllegalArgumentException.class)
    public void getComputerShouldThrowIfGivenNullAsModel() {
        computerManager.getComputer("Intel", null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void getComputerShouldThrowIfNoSuchComputerExists() {
        computerManager.getComputer("Pesho", "Pesho");
    }

    @Test (expected = IllegalArgumentException.class)
    public void getComputersByManufacturerShouldThrowIfGivenNull() {
        computerManager.getComputersByManufacturer(null);
    }

    @Test
    public void testGetComputersByManufacturer() {
        String actualModel = computerManager.getComputersByManufacturer("Apple").get(0).getModel();
        assertEquals("Mac", actualModel);
    }
}