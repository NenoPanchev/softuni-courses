package militaryElite;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecializedSoldier {

    private Corps corps;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.setCorps(corps);
    }

    @Override
    public Corps getCorps() {
        return this.corps;
    }

    private void setCorps(String corps) {
        if (corps.equals("Airforces") || corps.equals("Marines")) {
            this.corps = Corps.valueOf(corps);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
