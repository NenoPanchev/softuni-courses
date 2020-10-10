package militaryElite.enums;

public enum StateOfMission {
    IN_PROGRESS("inProgress"),
    FINISHED("Finished");

    private final String state;

    StateOfMission(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }
}
