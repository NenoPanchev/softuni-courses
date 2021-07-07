package entity.bills.payment.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bank_accounts")
public class BankAccount extends BillingDetail{
    private String bankName;
    private String swiftCode;

    public BankAccount() {
    }

    @Column(nullable = false, name = "bank_name", unique = true)
    public String getBankName() {
        return bankName;
    }

    public BankAccount setBankName(String name) {
        this.bankName = name;
        return this;
    }

    @Column(name = "swift_code", nullable = false, unique = true)
    public String getSwiftCode() {
        return swiftCode;
    }

    public BankAccount setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
        return this;
    }
}
