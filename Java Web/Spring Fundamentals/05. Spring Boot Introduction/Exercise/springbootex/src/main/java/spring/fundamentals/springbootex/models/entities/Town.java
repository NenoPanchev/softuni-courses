package spring.fundamentals.springbootex.models.entities;


import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "towns")

public class Town extends BaseEntity{
    private String name;
    @OneToMany(mappedBy = "town")
    private Set<Shop> shops;

    public Town() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Shop> getShops() {
        return shops;
    }

    public void setShops(Set<Shop> shops) {
        this.shops = shops;
    }
}
