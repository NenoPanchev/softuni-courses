package militaryElite;

import java.util.LinkedHashSet;
import java.util.Set;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private Set<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new LinkedHashSet<>();
    }

    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public Set<Mission> getMissions() {
        return this.missions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append("Corps: ").append(this.getCorps()).append(System.lineSeparator());
        sb.append("Missions:").append(System.lineSeparator());
        this.missions.forEach(m -> sb.append("  ").append(m).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
