package entities.bills_payment_system;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BillingDetail {
    private String number;
    private BillUser owner;
    protected BillingDetail() {
    }

    @Id
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public BillUser getOwner() {
        return owner;
    }

    public void setOwner(BillUser owner) {
        this.owner = owner;
    }
}
