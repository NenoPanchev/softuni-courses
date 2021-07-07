package entity.sales;

import entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
@Entity
@Table(name = "sales")
public class Sale extends BaseEntity {
    private Product product;
    private Customer customer;
    private StoreLocation storeLocation;
    private LocalDate date;

    public Sale() {
    }

    @ManyToOne
    public Product getProduct() {
        return product;
    }

    public Sale setProduct(Product product) {
        this.product = product;
        return this;
    }

    @ManyToOne
    public Customer getCustomer() {
        return customer;
    }

    public Sale setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    @ManyToOne(targetEntity = StoreLocation.class)
    @JoinColumn(name = "store_location_id", referencedColumnName = "id")
    public StoreLocation getStoreLocation() {
        return storeLocation;
    }

    public Sale setStoreLocation(StoreLocation storeLocation) {
        this.storeLocation = storeLocation;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public Sale setDate(LocalDate date) {
        this.date = date;
        return this;
    }
}
