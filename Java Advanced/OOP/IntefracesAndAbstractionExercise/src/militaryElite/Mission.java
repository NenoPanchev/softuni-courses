package militaryElite;

public class Mission {
    private String codeName;
    private StateOfMission state;

    public Mission(String codeName, String state) {
        this.codeName = codeName;
        this.state = StateOfMission.valueOf(state);
    }

    public void completeMission() {
        this.state = StateOfMission.finished;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s",
                this.codeName,
                this.state);
    }
}
