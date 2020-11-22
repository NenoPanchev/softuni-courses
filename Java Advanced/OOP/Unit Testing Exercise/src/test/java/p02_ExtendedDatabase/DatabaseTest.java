package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {
    private Database database;

    @Before
    public void setDatabase() throws OperationNotSupportedException {
        Person first = new Person(1, "First");
        Person second = new Person(2, "Second");
        Person third = new Person(3, "Third");
        Person fourth = new Person(4, "Fourth");
        database = new Database(first, second, third, fourth);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldThrowWhenCalledWithMoreThanSixteenElements() throws OperationNotSupportedException {
        Person[] people = new Person[17];
        new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldThrowWhenCalledWithZeroElements() throws OperationNotSupportedException {
        Person[] people = new Person[0];
        new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowExcIfAddedNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void addShouldAddElementAtTheNextFreeSpot() throws OperationNotSupportedException {
        Person fifth = new Person(5, "Fifth");
        database.add(fifth);
        Assert.assertEquals(5, database.getElements()[4].getId());
        Assert.assertEquals("Fifth", database.getElements()[4].getUsername());
    }

    @Test
    public void removeShouldRemoveLastPosition() throws OperationNotSupportedException {
        database.remove();
        Person[] actual = database.getElements();
        assertEquals(3, database.getElements().length);
        assertEquals(3, database.getElements()[2].getId());
        assertEquals("Third", database.getElements()[2].getUsername());

    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowIfYouTryToRemoveFromEmptyDatabase() throws OperationNotSupportedException {
        for (int i = 0; i < 4; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void getterShouldFetchElementsAsArray() throws OperationNotSupportedException {
        assertTrue(database.getElements().length == 4);
        Person[] database2 = {
                new Person(1, "First"),
                new Person(2, "Second"),
                new Person(3, "Third"),
                new Person(4, "Fourth")
        };
        for (int i = 0; i < database.getElements().length; i++) {
            assertEquals(database.getElements()[i].getId(), database2[i].getId());
            assertEquals(database.getElements()[i].getUsername(), database2[i].getUsername());
        }
    }

    @Test
    public void testDatabaseConstructorShouldCreateObjectWithValidState() {
        Person[] elements = database.getElements();
        assertEquals(4, elements.length);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void addingDuplicateIdShouldThrow() throws OperationNotSupportedException {
        database.add(new Person(1, "Pesho"));
    }

    @Test (expected = OperationNotSupportedException.class)
    public void addingNegativeIdShouldThrow() throws OperationNotSupportedException {
        database.add(new Person(-1, "Pesho"));
    }


    @Test (expected = OperationNotSupportedException.class)
    public void shouldThrowIfUserNotFound() throws OperationNotSupportedException {
        database.findByUsername("Pesho");
    }

    @Test (expected = OperationNotSupportedException.class)
    public void shouldThrowIfUserIsNull() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void shouldThrowIfIdNotFound() throws OperationNotSupportedException {
        database.findById(7);
    }
}
