package militaryElite.implementations;

import militaryElite.enums.StateOfMission;
import militaryElite.interfaces.Mission;

public class MissionImpl implements Mission {
    private String codeName;
    private StateOfMission state;

    public MissionImpl(String codeName, String state) {
        this.codeName = codeName;
        this.setState(state);
    }

    public void completeMission() {
        this.state = StateOfMission.FINISHED;
    }

    private void setState(String state) {
        if (state.equals("inProgress")) {
            this.state = StateOfMission.IN_PROGRESS;
        } else if (state.equals("Finished")) {
            this.state = StateOfMission.FINISHED;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s",
                this.codeName,
                this.state.getState());
    }
}
