package entity.football;

import entity.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "teams")
public class Team extends BaseEntity {
    private String name;
    private Byte[] Logo;
    private String initials;
    private Color primaryKitColor;
    private Color SecondaryKitColor;
    private Town town;
    private BigDecimal budget;
    private Set<Player> players;

    public Team() {
    }

    @Column(unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public Team setName(String name) {
        this.name = name;
        return this;
    }

    @Column(columnDefinition = "BLOB")
    public Byte[] getLogo() {
        return Logo;
    }

    public Team setLogo(Byte[] logo) {
        Logo = logo;
        return this;
    }

    @Column(nullable = false, unique = true, columnDefinition = "CHAR(3)")
    public String getInitials() {
        return initials;
    }

    public Team setInitials(String initials) {
        this.initials = initials;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "primary_kit_color_id", referencedColumnName = "id")
    public Color getPrimaryKitColor() {
        return primaryKitColor;
    }

    public Team setPrimaryKitColor(Color primaryKitColor) {
        this.primaryKitColor = primaryKitColor;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "secondary_kit_color_id", referencedColumnName = "id")
    public Color getSecondaryKitColor() {
        return SecondaryKitColor;
    }

    public Team setSecondaryKitColor(Color secondaryKitColor) {
        SecondaryKitColor = secondaryKitColor;
        return this;
    }

    @ManyToOne
    public Town getTown() {
        return town;
    }

    public Team setTown(Town town) {
        this.town = town;
        return this;
    }

    @Column
    public BigDecimal getBudget() {
        return budget;
    }

    public Team setBudget(BigDecimal budget) {
        this.budget = budget;
        return this;
    }

    @OneToMany(mappedBy = "team")
    public Set<Player> getPlayers() {
        return players;
    }

    public Team setPlayers(Set<Player> players) {
        this.players = players;
        return this;
    }
}
