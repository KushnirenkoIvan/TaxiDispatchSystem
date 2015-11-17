package taxi.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;


@Component
@Entity
@Table(name = "CLIENT")
public class Client {

    public enum clientStatus {
        ORDINARY, SILVER, GOLD
    }

    @Id
    @Column(name = "CLIENT_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "ORDERS_COUNT")
    private Long ordersCount;

    @Column(name = "CLIENT_STATUS")
    private String status;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Order> orders;

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

    public Long getOrdersCount() {
        return ordersCount;
    }

    @Deprecated
    public void setOrdersCount(Long ordersCount) {
        if ((ordersCount == 0 && orders == null) || ordersCount == orders.size()) {
            this.ordersCount = ordersCount;
        } else {
            System.out.println("ERROR: Cannot set up orders count, because list of orders contains " +
                    orders.size() + " orders.");
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(clientStatus status) {
        if (status.equals(clientStatus.SILVER) && ordersCount < 10) {
            System.out.println("ERROR: Cannot set up client status, because orders count less then 10.");
        } else if (status.equals(clientStatus.GOLD) && ordersCount < 20) {
            System.out.println("ERROR: Cannot set up client status, because orders count less then 20.");
        } else {
            this.status = status.toString();
        }
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Client() {
        this.setId(id);
        this.setName("Name");
        this.setPhone("00-00-00");
        this.setOrdersCount(0l);
        this.setStatus(clientStatus.ORDINARY);
    }

    public Client(Long id, String name, String phone, Long ordersCount, String status) {
        this.setId(id);
        this.setName(name);
        this.setPhone(phone);
        this.setOrdersCount(ordersCount);
        this.setStatus(clientStatus.valueOf(status));
    }

    public Client(Client client) {
        this.setId(client.getId());
        this.setName(client.getName());
        this.setPhone(client.getPhone());
        this.setOrdersCount(client.getOrdersCount());
        this.setStatus(clientStatus.valueOf(client.getStatus()));
    }

    @Override
    public String toString() {
        return new String("Client id: " + id + ", name: " + name + ", phone: " + phone + ", number of orders " + ordersCount +
                ", status: " + status + ".");
    }

    public void showOrders() {
        System.out.println(orders);
    }

    public void addOrder(Order order) {
        orders.add(order);
        ordersCount++;
        if (ordersCount == 10) {
            setStatus(clientStatus.SILVER);
        }
        if (ordersCount == 20) {
            setStatus(clientStatus.GOLD);
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
    }
}

