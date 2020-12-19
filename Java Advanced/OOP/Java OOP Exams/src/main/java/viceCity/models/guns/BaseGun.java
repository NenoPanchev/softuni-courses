package viceCity.models.guns;

import viceCity.common.ExceptionMessages;

public abstract class BaseGun implements Gun{
    private int BULLETS_PER_SHOOT = 0;
    private int INITIAL_BULLETS_PER_BARREL;
    private String name;
    private int bulletsPerBarrel;
    private int totalBullets;
    private boolean canFire;

    protected BaseGun(String name, int bulletsPerBarrel, int totalBullets) {
        this.setName(name);
        this.setBulletsPerBarrel(bulletsPerBarrel);
        this.setTotalBullets(totalBullets);
        this.INITIAL_BULLETS_PER_BARREL = bulletsPerBarrel;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getBulletsPerBarrel() {
        return this.bulletsPerBarrel;
    }

    @Override
    public boolean canFire() {
        return this.bulletsPerBarrel >= this.BULLETS_PER_SHOOT;
    }

    @Override
    public int getTotalBullets() {
        return this.totalBullets;
    }

    @Override
    public int fire() {
        if (this.bulletsPerBarrel >= this.BULLETS_PER_SHOOT) {
            this.bulletsPerBarrel -= this.BULLETS_PER_SHOOT;
            if (this.bulletsPerBarrel == 0 && this.totalBullets >= this.BULLETS_PER_SHOOT) {
                if (this.totalBullets >= this.INITIAL_BULLETS_PER_BARREL) {
                    this.bulletsPerBarrel += this.INITIAL_BULLETS_PER_BARREL;
                    this.totalBullets -= this.INITIAL_BULLETS_PER_BARREL;
                } else {
                    this.bulletsPerBarrel += this.totalBullets;
                    this.totalBullets = 0;
                }
            }
            return this.BULLETS_PER_SHOOT;
        }
        return 0;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.NAME_NULL);
        }
        this.name = name;
    }

    private void setBulletsPerBarrel(int bulletsPerBarrel) {
        if (bulletsPerBarrel < 0) {
            throw new IllegalArgumentException(ExceptionMessages.BULLETS_LESS_THAN_ZERO);
        }
        this.bulletsPerBarrel = bulletsPerBarrel;
    }

    private void setTotalBullets(int totalBullets) {
        if (totalBullets < 0) {
            throw new IllegalArgumentException(ExceptionMessages.TOTAL_BULLETS_LESS_THAN_ZERO);
        }
        this.totalBullets = totalBullets;
    }

    protected void setBULLETS_PER_SHOOT(int bullets) {
        this.BULLETS_PER_SHOOT = bullets;
    }
}
