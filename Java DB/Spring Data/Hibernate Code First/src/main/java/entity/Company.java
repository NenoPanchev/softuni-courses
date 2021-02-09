package entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Company {
    private BigInteger id;
    private String name;
    private Set<Plane> planes = new HashSet<>();

    public Company() {
    }

    public Company(BigInteger id, String name) {
        this.id = id;
        this.name = name;
    }

    public Company(BigInteger id, String name, Set<Plane> planes) {
        this.id = id;
        this.name = name;
        this.planes = planes;
    }

    @Id
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<Plane> getPlanes() {
        return planes;
    }

    public void setPlanes(Set<Plane> planes) {
        this.planes = planes;
    }
}
