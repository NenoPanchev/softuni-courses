package rpg_tests;

import org.junit.Assert;
import org.junit.Test;

public class DummyTest {
    @Test
    public void dummyShouldLoseHealthWhenAttacked () {
        Dummy dummy = new Dummy(10, 10);

        dummy.takeAttack(5);
        Assert.assertTrue(dummy.getHealth() == 5);
    }


}
