package rpg_tests;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import rpg_tests.interfaces.Target;
import rpg_tests.interfaces.Weapon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HeroTest {

    private static final int BASE_EXPERIENCE = 10;

    @Test
    public void shouldReceiveExpIfDummyDiesDuringAttack() {
        Target fakeTarget = new Target() {
            @Override
            public int getHealth() {
                return 0;
            }

            @Override
            public void takeAttack(int attackPoints) {

            }

            @Override
            public int giveExperience() {
                return BASE_EXPERIENCE;
            }

            @Override
            public boolean isDead() {
                return true;
            }

            @Override
            public Weapon getLoot() {
                return null;
            }
        };
        Weapon fakeWeapon = new Weapon() {
            @Override
            public void attack(Target target) {

            }

            @Override
            public int getAttackPoints() {
                return 10;
            }

            @Override
            public int getDurabilityPoints() {
                return 0;
            }
        };
        Hero hero = new Hero("Pesho", fakeWeapon);
        hero.attack(fakeTarget);

        assertEquals("Wrong experience", BASE_EXPERIENCE, hero.getExperience());
    }

    @Test
    public void attackGainsExperienceIfTargetIsDead() {
        Weapon mockWeapon = mock(Axe.class);
        when(mockWeapon.getAttackPoints()).thenReturn(10);
        when(mockWeapon.getDurabilityPoints()).thenReturn(2);
        Target mockTarget = mock(Dummy.class);
        when(mockTarget.giveExperience()).thenReturn(10);
        Hero hero = new Hero("Pesho", mockWeapon);
        hero.attack(mockTarget);
        assertEquals("Wrong experience", BASE_EXPERIENCE, hero.getExperience());
    }

    @Test
    public void shouldReceiveLootAfterKillingTarget() {
        Axe mockAxe = mock(Axe.class);
        when(mockAxe.getAttackPoints()).thenReturn(10);
        Target mockTarget = mock(Dummy.class);
        when(mockTarget.getLoot()).thenReturn(mockAxe);
        Hero hero = new Hero("Pesho", mockAxe);
        hero.attack(mockTarget);

        assertEquals(hero.getInventory().size(), 1);
    }
}
