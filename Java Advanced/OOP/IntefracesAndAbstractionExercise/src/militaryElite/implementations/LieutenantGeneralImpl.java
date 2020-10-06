package militaryElite.implementations;

import militaryElite.interfaces.LieutenantGeneral;
import militaryElite.interfaces.Private;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private List<Private> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    @Override
    public Collection<Private> getPrivates() {
        return this.privates;
    }

    public void addPrivate(Private priv) {
        this.privates.add(priv);

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
