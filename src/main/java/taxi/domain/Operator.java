package taxi.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@Component
@Entity
@Table(name = "OPERATOR")
public class Operator {

    public enum operatorStatus {USER, ADMIN}

    @Id
    @Column(name = "OPERATOR_ID")
    private Long id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "STATUS")
    private String status;

    @Temporal(TemporalType.DATE)
    @Column(name = "CHANGE_REQUISITES")
    private Date changeRequisites;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(operatorStatus status) {
        this.status = status.toString();
    }

    public Date getChangeRequisites() {
        return changeRequisites;
    }

    private void setChangeRequisites() {
        Properties properties = new Properties();
        changeRequisites = new Date();
        try {
            properties.load(new FileInputStream("/home/ivan/IdeaProjects/taxi/src/main/resources/config.properties"));
            changeRequisites.setTime(changeRequisites.getTime() + Long.parseLong(properties.getProperty("term_of_requisites")) * 2592000000l);
        } catch (FileNotFoundException exp) {
            System.out.println("ERROR: Some problems with reading properties file. Parametr set up for one month.");
            changeRequisites.setTime(changeRequisites.getTime() + 2592000000l);
        } catch (IOException exp) {
            System.out.println("ERROR: Cannot set up term for login and password.");
            exp.printStackTrace();
        }
    }

    public Operator() {
        this.setId(999l);
        this.setLogin("login");
        this.setPassword("password");
        this.setStatus(operatorStatus.USER);
        setChangeRequisites();
    }

    public Operator(Long id, String login, String password, String status, Date changeRequisites) {
        this.setId(id);
        this.setLogin(login);
        this.setPassword(password);
        this.setStatus(operatorStatus.valueOf(status));
        setChangeRequisites();
    }

    public Operator(Operator operator) {
        this.setId(operator.getId());
        this.setLogin(operator.getLogin());
        this.setPassword(operator.getPassword());
        this.setStatus(operatorStatus.valueOf(operator.getStatus()));
        setChangeRequisites();
    }

    @Override
    public String toString() {
        return new String("Operator id: " + id + ", login: " + login + ", password: " + password +
                ", status: " + status + ", is term of requisites out: " + checkRequisites() + ".");
    }

    /**
     * @return true
     * if you must change the requisites.
     */
    public boolean checkRequisites() {
        return changeRequisites.before(new Date());
    }

    public void changeRequisites(String login, String password) {
        this.setLogin(login);
        this.setPassword(password);
    }

    public static void main(String[] args) {
        Operator operator = new Operator();
    }
}
