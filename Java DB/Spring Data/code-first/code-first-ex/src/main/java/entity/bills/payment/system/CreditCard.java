package entity.bills.payment.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "credit_card")
public class CreditCard extends BillingDetail{
    private String cardType;
    private String expirationMonth;
    private String expirationYear;

    public CreditCard() {
    }

    @Column(name = "card_type", nullable = false)
    public String getCardType() {
        return cardType;
    }

    public CreditCard setCardType(String cardType) {
        this.cardType = cardType;
        return this;
    }

    @Column(name = "expiration_month", length = 2)
    public String getExpirationMonth() {
        return expirationMonth;
    }

    public CreditCard setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
        return this;
    }

    @Column(name = "expiration_year", length = 4)
    public String getExpirationYear() {
        return expirationYear;
    }

    public CreditCard setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
        return this;
    }
}
