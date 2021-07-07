package entity.bills.payment.system;

import entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "billing_details")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BillingDetail extends BaseEntity {
    private String number;
    private BankUser owner;

    public BillingDetail() {
    }

    @Column(nullable = false, unique = true)
    public String getNumber() {
        return number;
    }

    public BillingDetail setNumber(String number) {
        this.number = number;
        return this;
    }

    @ManyToOne
    public BankUser getOwner() {
        return owner;
    }

    public BillingDetail setOwner(BankUser owner) {
        this.owner = owner;
        return this;
    }
}
