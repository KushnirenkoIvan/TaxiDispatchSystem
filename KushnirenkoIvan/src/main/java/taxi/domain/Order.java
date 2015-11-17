package taxi.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Component
@Entity
@Table(name = "ORDERS")
public class Order {

    enum OrderStatus {
        FREE, PROGRESS, PERFORMED
    }

    @Id
    @Column(name = "ID")
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATED_DATE")
    private Date creationDate;

    @Column(name = "MOVE_TO")
    private String moveTo;

    @Column(name = "MOVE_FROM")
    private String moveFrom;

    @Column(name = "PRICE")
    private Float price;

    @OneToOne
    @Column(name = "OPERATOR_ID")
    private Operator operator;

    @OneToOne
    @Column(name = "CLIENT")
    private Client client;

    @Column(name = "STATUS")
    private String status;

    @OneToOne
    @Column(name = "DRIVER")
    private Driver driver;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getMoveTo() {
        return moveTo;
    }

    public void setMoveTo(String moveTo) {
        this.moveTo = moveTo;
    }

    public String getMoveFrom() {
        return moveFrom;
    }

    public void setMoveFrom(String moveFrom) {
        this.moveFrom = moveFrom;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status.toString();
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Order() {
        this.setId(id);
        this.setCreationDate(new Date());
        this.setMoveFrom("Street 1, 1");
        this.setMoveTo("Street 2, 2");
        this.setClient(new Client());
        this.setPrice(100f);
        this.setOperator(new Operator());
        this.status = OrderStatus.FREE.toString();
    }

    public Order(Long id, String moveFrom, String moveTo, Float price, Operator operator, Client client, Driver driver) {
        this.setId(id);
        this.setCreationDate(new Date());
        this.setMoveFrom(moveFrom);
        this.setMoveTo(moveTo);
        this.setClient(client);
        this.setDriver(driver);
        if (client.getStatus().equals(Client.clientStatus.SILVER)) {
            this.setPrice(price * 0.9f);
        }
        if (client.getStatus().equals(Client.clientStatus.GOLD)) {
            this.setPrice(price * 0.8f);
        }
        this.setOperator(operator);
        status = OrderStatus.FREE.toString();
    }

    public Order(Order order) {
        this.setId(order.getId());
        this.setCreationDate(new Date());
        this.setMoveFrom(order.getMoveFrom());
        this.setMoveTo(order.getMoveTo());
        this.setPrice(order.getPrice());
        this.setOperator(order.getOperator());
        this.setClient(order.getClient());
        this.setStatus(OrderStatus.valueOf(order.getStatus().toString()));
        this.setDriver(order.getDriver());
    }

    @Override
    public String toString() {
        return new String("Order id: " + this.getId() +
                "; creation date: " + this.getCreationDate() +
                "; move to: " + this.getMoveTo() +
                "; move from: " + this.getMoveFrom() +
                "; price: " + this.getPrice() +
                "; Operator: " + this.getOperator() +
                "; Client: " + this.getClient() +
                "; Driver: " + this.getDriver() +
                "; status: " + this.getStatus() +
                ".");
    }

}
