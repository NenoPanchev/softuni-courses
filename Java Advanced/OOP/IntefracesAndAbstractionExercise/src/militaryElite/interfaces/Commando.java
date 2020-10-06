package militaryElite.interfaces;

import militaryElite.implementations.MissionImpl;

import java.util.Collection;

public interface Commando extends SpecializedSoldier {
    Collection<Mission> getMissions();
}
