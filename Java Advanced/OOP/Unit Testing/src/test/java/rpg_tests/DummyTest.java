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

    @Test (expected = IllegalStateException.class)
    public void shouldThrowExceptionWhenAttackingDeadDummy() {
        Dummy dummy = new Dummy(-10, 10);
        dummy.takeAttack(10);
    }

    @Test
    public void shouldNotGiveExpWhenAlive() {
        Dummy dummy = new Dummy(-10, 10);

        int actual = dummy.giveExperience();
        Assert.assertTrue(actual == 10);
    }

    @Test (expected = IllegalStateException.class)
    public void shouldThrowExceptionExpWhenAlive() {
        Dummy dummy = new Dummy(10, 10);
        dummy.giveExperience();
    }
}
