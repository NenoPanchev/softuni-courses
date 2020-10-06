package militaryElite.implementations;

import militaryElite.interfaces.Engineer;
import militaryElite.interfaces.Repair;

import java.util.*;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private List<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
    }

    public void addRepair(RepairImpl repair) {
        this.repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs() {
        return this.repairs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append("Corps: ").append(this.getCorps().getName()).append(System.lineSeparator());
        sb.append("Repairs:").append(System.lineSeparator());
        this.repairs.forEach(r -> sb.append("  ").append(r).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
