package p3_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {
    ListIterator iterator;

    @Before
    public void setIterator() throws OperationNotSupportedException {
        iterator = new ListIterator("One", "Two", "Three");
    }

    @Test (expected = OperationNotSupportedException.class)
    public void constructorShouldThrowIfNullPassed() throws OperationNotSupportedException {
        ListIterator iterator2 = new ListIterator(null);
    }

    @Test
    public void shouldReturnTrueIfAbleToMove() {
        Assert.assertTrue(iterator.move());
    }

    @Test
    public void shouldReturnFalseIfNotAbleToMove() {
        iterator.move();
        iterator.move();
        assertFalse(iterator.move());
    }

    @Test
    public void shouldReturnTrueIfHasNext() {
        assertTrue(iterator.hasNext());
    }

    @Test
    public void shouldReturnFalseIfDoesNotHaveNext() {
        iterator.move();
        iterator.move();
        assertFalse(iterator.hasNext());
    }

    @Test
    public void shouldReturnStringAtCurrentIndex() {
        iterator.move();
        assertEquals("Two", iterator.print());
    }

    @Test (expected = IllegalStateException.class)
    public void shouldThrowIfPrintEmpty() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator();
        assertEquals("Invalid Operation!", listIterator.print());
    }


}
