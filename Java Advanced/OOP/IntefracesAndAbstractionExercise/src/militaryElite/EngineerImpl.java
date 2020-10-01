package militaryElite;

import java.util.LinkedHashSet;
import java.util.Set;

public class EngineerImpl extends SpecialisedSoldierImpl implements  Engineer{
    private Set<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new LinkedHashSet<>();
    }

    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public Set<Repair> getRepairs() {
        return this.repairs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append("Corps: ").append(this.getCorps()).append(System.lineSeparator());
        sb.append("Repairs:").append(System.lineSeparator());
        this.repairs.forEach(r -> sb.append("  ").append(r).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
