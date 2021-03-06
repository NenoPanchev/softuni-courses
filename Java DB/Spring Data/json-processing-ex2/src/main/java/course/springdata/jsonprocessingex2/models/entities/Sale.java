package course.springdata.jsonprocessingex2.models.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "sales")
public class Sale extends BaseEntity{
    private Car car;
    private Customer customer;
    private BigDecimal discount;

    public Sale() {
    }

    @OneToOne(fetch = FetchType.EAGER)
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @ManyToOne
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
}
