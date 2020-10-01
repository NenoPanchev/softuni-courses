package militaryElite;

import java.util.LinkedHashSet;
import java.util.Set;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private Set<PrivateImpl> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new LinkedHashSet<>();
    }

    @Override
    public Set<PrivateImpl> getPrivates() {
        return this.privates;
    }

    public void addPrivate(Private priv) {
        this.privates.add((PrivateImpl)(priv));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append("Privates:").append(System.lineSeparator());
        this.privates.stream()
                .sorted((a, b) -> Integer.compare(b.getId(), a.getId()))
                .forEach(pr -> sb.append("  ").append(pr).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
