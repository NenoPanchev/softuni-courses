package p5_CustomLinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomListTest {
    CustomLinkedList<String> list;

    @Before
    public void setUpList() {
        list = new CustomLinkedList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
    }

    @Test
    public void testConstructor() {
        String[] arr = new String[]{"One", "Two", "Three", "Four"};
        for (int i = 0; i < arr.length; i++) {
            assertEquals(arr[i], list.get(i));
        }
    }

    @Test
    public void getShouldReturnElementAtCorrectIndex() {
        assertEquals("Two", list.get(1));
    }

    @Test (expected = IllegalArgumentException.class)
    public void getShouldThrowIfGivenBiggerIndex() {
        list.get(4);
    }

    @Test (expected = IllegalArgumentException.class)
    public void getShouldThrowIfGivenNegativeIndex() {
        list.get(-1);
    }

    @Test
    public void setShouldChangeElementAtGivenIndex() {
        list.set(2, "Pesho");
        assertEquals("Wrong element", "Pesho", "Pesho");
    }

    @Test (expected = IllegalArgumentException.class)
    public void setShouldThrowIfGivenBiggerIndex() {
        list.set(5, "Pesho");
    }

    @Test (expected = IllegalArgumentException.class)
    public void setShouldThrowIfGivenNegativeIndex() {
        list.set(-1, "Pesho");
    }

    @Test
    public void addShouldAddAtTheEnd() {
        list.add("Five");
        assertEquals("Added Wrong", "Five", list.get(4));
    }

    @Test
    public void testAddingOnEmptyList() {
        CustomLinkedList<Integer> nums = new CustomLinkedList<>();
        nums.add(1);
        assertEquals("Added Wrong", Integer.valueOf(1), nums.get(0));
    }

    @Test
    public void removeAtShouldRemoveElementAtGivenIndex() {
        list.removeAt(1);
        assertEquals("Removed wrong element", "Three", list.get(1));
    }

    @Test (expected = IllegalArgumentException.class)
    public void removeAtShouldThrowIfGivenNegativeIndex() {
        list.removeAt(-1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void removeAtShouldThrowIfGivenBiggerIndex() {
        list.removeAt(4);
    }

    @Test
    public void removeShouldReturnIndexOfRemovedElement() {
        int index = list.remove("Two");
        assertEquals("Returned wrong index", 1, index);
    }

    @Test
    public void removeShouldReturnMinusOneIfGivenElementNotFound() {
        int index = list.remove("Alice");
        assertEquals("Returned wrong index", -1, index);
    }

    @Test
    public void indexOfShouldReturnIndexOfGivenElement() {
        int index = list.indexOf("Three");
        assertEquals("Returned wrong index", 2, index);
    }

    @Test
    public void indexOfShouldReturnMinusOneIfGivenElementNotFound() {
        int index = list.indexOf("Alice");
        assertEquals("Returned wrong index", -1, index);
    }

    @Test
    public void containsShouldReturnTrueIfElementIsContained() {
        assertTrue("Doesn't show element is contained", list.contains("Four"));
    }

    @Test
    public void containsShouldReturnFalseIfElementIsNotContained() {
        assertFalse("Shows element is contained", list.contains("Alice"));
    }
}
