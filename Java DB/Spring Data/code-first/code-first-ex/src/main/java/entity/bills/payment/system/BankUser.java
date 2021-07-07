package entity.bills.payment.system;

import entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "bank_users")
public class BankUser extends BaseEntity {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Set<BillingDetail> billingDetails;

    public BankUser() {
    }

    @Column(name = "first_name", nullable = false, length = 50)
    public String getFirstName() {
        return firstName;
    }

    public BankUser setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Column(name = "last_name", nullable = false, length = 60)
    public String getLastName() {
        return lastName;
    }

    public BankUser setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Column(unique = true)
    public String getEmail() {
        return email;
    }

    public BankUser setEmail(String email) {
        this.email = email;
        return this;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public BankUser setPassword(String password) {
        this.password = password;
        return this;
    }

    @OneToMany(mappedBy = "owner")
    public Set<BillingDetail> getBillingDetails() {
        return billingDetails;
    }

    public BankUser setBillingDetails(Set<BillingDetail> billingDetails) {
        this.billingDetails = billingDetails;
        return this;
    }
}
