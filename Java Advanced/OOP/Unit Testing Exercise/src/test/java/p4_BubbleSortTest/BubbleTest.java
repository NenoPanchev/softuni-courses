package p4_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

public class BubbleTest {

    @Test
    public void testSimpleSort() {
        int[] numbers = {1, 2, 3, 5, 7, 2, 1, 4, 6, 13};
        Bubble.sort(numbers);
        int[] sorted = {1, 1, 2, 2, 3, 4, 5, 6, 7, 13};
        for (int i = 0; i < numbers.length; i++) {
            Assert.assertEquals(sorted[i], numbers[i]);
        }
    }
}
