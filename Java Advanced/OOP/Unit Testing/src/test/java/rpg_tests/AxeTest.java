package rpg_tests;

import org.junit.Assert;
import org.junit.Test;

public class AxeTest {
    @Test
    public void shouldLoseDurabilityAfterAttack() {
        Axe axe = new Axe(50, 5);
        Dummy dummy = new Dummy(10, 10);
        axe.attack(dummy);
        Assert.assertTrue(axe.getDurabilityPoints() == 4);
    }

    @Test (expected = IllegalStateException.class)
    public void shouldThrowExceptionWithNegativeDurability() {
        Axe axe = new Axe(10, 0);
        Dummy dummy = new Dummy(10, 10);

        axe.attack(dummy);

    }
}
