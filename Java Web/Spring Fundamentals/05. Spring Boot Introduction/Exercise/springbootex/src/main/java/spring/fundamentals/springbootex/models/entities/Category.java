package spring.fundamentals.springbootex.models.entities;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categories")

public class Category extends BaseEntity{
    @Column(unique = true, nullable = false)
    private String name;
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private Set<Product> products;

    public Category() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
