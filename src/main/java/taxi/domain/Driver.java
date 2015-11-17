package taxi.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Component
@Entity
@Table(name = "DRIVERS")
public class Driver {

    @Id
    @Column(name = "DRIVER_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "CAR_MODEL")
    private String carModel;

    @Column(name = "CAR_NUMBER")
    private Long carNumber;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Order> orderes;

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Long getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(Long carNumber) {
        this.carNumber = carNumber;
    }

    public List<Order> getOrderes() {
        return orderes;
    }

    public void setOrderes(List<Order> orderes) {
        this.orderes = orderes;
    }

    public Driver() {
        this.setId(999l);
        this.setName("Name");
        this.setPhone("00-00-00");
        this.setCarModel("Model");
        this.setCarNumber(0l);
    }

    public Driver(Long id, String name, String phone, String carModel, Long carNumber) {
        this.setId(id);
        this.setName(name);
        this.setPhone(phone);
        this.setCarModel(carModel);
        this.setCarNumber(carNumber);
    }

    public Driver(Driver driver) {
        this.setId(driver.getId());
        this.setName(driver.getName());
        this.setPhone(driver.getPhone());
        this.setCarModel(driver.getCarModel());
        this.setCarNumber(driver.getCarNumber());
    }

    @Override
    public String toString() {
        return new String("Driver id: " + id + ", name: +" + name + ", phone: " + phone + ", car model: " + carModel + ", car number: " + carNumber + ".");
    }

    public void showOrders() {
        System.out.println(orderes);
    }

    public void addOrder(Order order) {
        orderes.add(order);
    }
}
