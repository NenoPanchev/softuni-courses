package CounterStriker.models.guns;

import CounterStriker.common.ExceptionMessages;

public abstract class GunImpl implements Gun {
    private String name;
    private int bulletsCount;
    private int BULLETS_TO_FIRE_AT_ONCE = 0;

    protected GunImpl(String name, int bulletsCount) {
        this.setName(name);
        this.setBulletsCount(bulletsCount);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getBulletsCount() {
        return this.bulletsCount;
    }

    @Override
    public int fire() {
        if (this.bulletsCount >= BULLETS_TO_FIRE_AT_ONCE) {
            setBulletsCount(this.bulletsCount - BULLETS_TO_FIRE_AT_ONCE);
            return BULLETS_TO_FIRE_AT_ONCE;
        } else
        return 0;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.INVALID_GUN_NAME);
        }
        this.name = name;
    }

    private void setBulletsCount(int bulletsCount) {
        if (bulletsCount < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_GUN_BULLETS_COUNT);
        }
        this.bulletsCount = bulletsCount;
    }

    protected void setBULLETS_TO_FIRE_AT_ONCE(int number) {
        this.BULLETS_TO_FIRE_AT_ONCE = number;
    }
}
