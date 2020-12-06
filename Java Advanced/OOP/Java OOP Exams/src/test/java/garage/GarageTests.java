package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GarageTests {
    private Garage garage;

    @Before
    public void setUp() {
        garage = new Garage();
        Car first = new Car("Nissan", 180, 2880.50);
        Car second = new Car("Porsche", 320, 59990.99);
        Car third = new Car("Audi", 280, 28000.00);
        garage.addCar(first);
        garage.addCar(second);
        garage.addCar(third);
    }

    @Test
    public void testConstructor() {
        Garage garage = new Garage();
        Assert.assertNotNull(garage.getCars());
    }

    @Test (expected = UnsupportedOperationException.class)
    public void getCarsShouldBeUnmodifiable() {
        garage.getCars().remove(1);
    }

    @Test
    public void testFindAllCarsWithMaxSpeedAbove() {
        List<Car> actual = garage.findAllCarsWithMaxSpeedAbove(180);
        assertEquals(2, actual.size());
        assertEquals("Porsche", actual.get(0).getBrand());
        assertEquals("Audi", actual.get(1).getBrand());
    }

    @Test (expected = IllegalArgumentException.class)
    public void addCarShouldThrowIfGivenNull() {
        garage.addCar(null);
    }

    @Test
    public void testAddCar() {
        Car fourth = new Car("Mercedes", 280, 35000.00);
        garage.addCar(fourth);
        assertEquals(4, garage.getCars().size());
    }

    @Test
    public void testGetCount() {
        assertEquals(3, garage.getCount());
    }

    @Test
    public void testGetMostExpensiveCar() {
        Car expected = garage.getCars().get(1);
        assertNotNull(garage.getTheMostExpensiveCar());
        assertEquals(expected.getPrice(), garage.getTheMostExpensiveCar().getPrice(), 0.001);
    }

    @Test
    public void testFindAllCarsByBrand() {
        Car fourth = new Car("Audi", 260, 15000.00);
        garage.addCar(fourth);
        List<Car> expected = garage.findAllCarsByBrand("Audi");
        assertEquals(2, expected.size());
        assertEquals(280, expected.get(0).getMaxSpeed());
        assertEquals(260, expected.get(1).getMaxSpeed());
    }
}