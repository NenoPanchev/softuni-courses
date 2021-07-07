package entity.sales;

import entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {
    private String name;
    private String email;
    private String credit_card_number;
    private Set<Sale> sales;

    public Customer() {
    }

    @Column
    public String getName() {
        return name;
    }

    public Customer setName(String name) {
        this.name = name;
        return this;
    }

    @Column(nullable = false, unique = true)
    public String getEmail() {
        return email;
    }

    public Customer setEmail(String email) {
        this.email = email;
        return this;
    }

    @Column(name = "credit_card_number")
    public String getCredit_card_number() {
        return credit_card_number;
    }

    public Customer setCredit_card_number(String credit_card_number) {
        this.credit_card_number = credit_card_number;
        return this;
    }

    @OneToMany(mappedBy = "customer")
    public Set<Sale> getSales() {
        return sales;
    }

    public Customer setSales(Set<Sale> sales) {
        this.sales = sales;
        return this;
    }
}
