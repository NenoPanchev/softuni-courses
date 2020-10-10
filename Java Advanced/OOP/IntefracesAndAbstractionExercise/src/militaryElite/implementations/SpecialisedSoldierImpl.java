package militaryElite.implementations;

import militaryElite.enums.Corps;
import militaryElite.interfaces.SpecializedSoldier;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecializedSoldier {

    private Corps corps;

    protected SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.setCorps(corps);
    }

    @Override
    public Corps getCorps() {
        return this.corps;
    }

    private void setCorps(String corps) {
        if (corps.equals("Airforces")) {
            this.corps = Corps.AIRFORCE;
        } else if (corps.equals("Marines")) {
            this.corps = Corps.MARINE;
        }
        else {
            throw new IllegalArgumentException();
        }
    }
}
