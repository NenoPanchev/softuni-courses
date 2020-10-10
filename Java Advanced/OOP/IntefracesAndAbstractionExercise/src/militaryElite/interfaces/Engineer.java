package militaryElite.interfaces;

import militaryElite.implementations.RepairImpl;

import java.util.Collection;

public interface Engineer extends SpecializedSoldier {
    Collection<Repair> getRepairs();
}
