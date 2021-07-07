package entity.gringotts;

import entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "wizard_deposits")
public class WizardDeposits extends BaseEntity {
    private String firstName;
    private String lastName;
    private String notes;
    private Integer age;
    private String magicWandCreator;
    private Short magic_wand_size;
    private String depositGroup;
    private LocalDateTime depositStartDate;
    private BigDecimal depositAmount;
    private Float depositInterest;
    private Float depositCharge;
    private LocalDateTime depositExpirationDate;
    private boolean isDepositExpired;

    public WizardDeposits() {
    }

    @Column(length = 50, name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public WizardDeposits setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Column(length = 60, nullable = false, name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public WizardDeposits setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Column(columnDefinition = "TEXT", length = 1000)
    public String getNotes() {
        return notes;
    }

    public WizardDeposits setNotes(String notes) {
        this.notes = notes;
        return this;
    }

    @Column(nullable = false)
    public Integer getAge() {
        return age;
    }

    public WizardDeposits setAge(Integer age) {
        this.age = age;
        return this;
    }

    @Column(length = 100, name = "magic_wand_creator")
    public String getMagicWandCreator() {
        return magicWandCreator;
    }

    public WizardDeposits setMagicWandCreator(String magicWandCreator) {
        this.magicWandCreator = magicWandCreator;
        return this;
    }

    @Column(name = "magic_wand_size")
    public Short getMagic_wand_size() {
        return magic_wand_size;
    }

    public WizardDeposits setMagic_wand_size(Short magic_wand_size) {
        this.magic_wand_size = magic_wand_size;
        return this;
    }

    @Column(length = 20, name = "deposit_group")
    public String getDepositGroup() {
        return depositGroup;
    }

    public WizardDeposits setDepositGroup(String depositGroup) {
        this.depositGroup = depositGroup;
        return this;
    }

    @Column(name = "deposit_start_date")
    public LocalDateTime getDepositStartDate() {
        return depositStartDate;
    }

    public WizardDeposits setDepositStartDate(LocalDateTime depositStartDate) {
        this.depositStartDate = depositStartDate;
        return this;
    }

    @Column(precision = 10, scale = 3, name = "deposit_amount")
    public BigDecimal getDepositAmount() {
        return depositAmount;
    }

    public WizardDeposits setDepositAmount(BigDecimal depositAmount) {
        this.depositAmount = depositAmount;
        return this;
    }

    @Column(name = "deposit_interest")
    public Float getDepositInterest() {
        return depositInterest;
    }

    public WizardDeposits setDepositInterest(Float depositInterest) {
        this.depositInterest = depositInterest;
        return this;
    }

    @Column(name = "deposit_charge")
    public Float getDepositCharge() {
        return depositCharge;
    }

    public WizardDeposits setDepositCharge(Float depositCharge) {
        this.depositCharge = depositCharge;
        return this;
    }

    @Column(name = "deposit_expiration_date")
    public LocalDateTime getDepositExpirationDate() {
        return depositExpirationDate;
    }

    public WizardDeposits setDepositExpirationDate(LocalDateTime depositExpirationDate) {
        this.depositExpirationDate = depositExpirationDate;
        return this;
    }

    @Column(name = "is_deposit_expired")
    public boolean isDepositExpired() {
        return isDepositExpired;
    }

    public WizardDeposits setDepositExpired(boolean depositExpired) {
        isDepositExpired = depositExpired;
        return this;
    }
}
