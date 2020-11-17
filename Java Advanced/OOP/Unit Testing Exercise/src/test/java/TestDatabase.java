import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class TestDatabase {
    private Database database;

    @Before
    public void setDatabase() throws OperationNotSupportedException {
        database = new Database(1, 2, 3);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldThrowWhenCalledWithMoreThanSixteenElements() throws OperationNotSupportedException {
            Integer[] nums = new Integer[17];
            new Database(nums);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldThrowWhenCalledWithZeroElements() throws OperationNotSupportedException {
        Integer[] nums = new Integer[0];
        new Database(nums);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowExcIfAddedNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void addShouldAddElementAtTheNextFreeSpot() throws OperationNotSupportedException {
        database.add(4);
        Assert.assertEquals(Integer.valueOf(4), database.getElements()[3]);
    }

    @Test
    public void removeShouldRemoveLastPosition() throws OperationNotSupportedException {
        database.remove();
        Integer[] actual = database.getElements();
        Integer[] expected = {1, 2};
        assertEquals(2, database.getElements().length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }

    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowIfYouTryToRemoveFromEmptyDatabase() throws OperationNotSupportedException {
        for (int i = 0; i < 3; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void getterShouldFetchElementsAsArray() {
        assertTrue(database.getElements().length == 3);
        assertEquals(new Integer[]{1, 2, 3}, database.getElements());
    }

    @Test
    public void testDatabaseConstructorShouldCreateObjectWithValidState() {
        Integer[] elements = database.getElements();
        assertEquals(3, elements.length);
    }
}
