package militaryElite;

public class SpyImpl extends SoldierImpl implements Spy {
    private int codeNumber;

    public SpyImpl(int id, String firstName, String lastName, int codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public int getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %d%n" +
                        "Code Number: 00%d",
                this.getFirstName(),
                this.getLastName(),
                this.getId(),
                this.codeNumber);
    }
}
