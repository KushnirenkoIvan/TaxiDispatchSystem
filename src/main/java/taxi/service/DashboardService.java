package taxi.service;

import taxi.domain.Client;
import taxi.domain.Driver;
import taxi.domain.Order;

import java.util.List;

public interface DashboardService {

    List<Order> showOrders();

    List<Driver> showDrivers();

    List<Client> showClients();

    Long createDriver(Driver driver);
}
