package entity;

import javax.persistence.*;

    @Entity(name = "plate")
    @Table(name = "plates")
public class PlateNumber {
        private long id;
        private String number;
        private Car car;

    public PlateNumber() {
    }

    public PlateNumber(String number, Car car) {
        this.number = number;
        this.car = car;
        }

    public PlateNumber(int id, String number, Car car) {
        this.id = id;
        this.number = number;
        this.car = car;
    }

    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "plate_number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @OneToOne
    @JoinColumn(name = "id")
    @MapsId
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
