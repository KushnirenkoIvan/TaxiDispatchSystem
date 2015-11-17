package taxi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import taxi.dao.ClientDao;
import taxi.dao.DriverDao;
import taxi.dao.OrderDao;
import taxi.domain.Client;
import taxi.domain.Driver;
import taxi.domain.Order;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private DriverDao driverDao;

    @Autowired
    private ClientDao clientDao;

    public List<Order> showOrders() {
        return orderDao.findAll();
    }

    public List<Driver> showDrivers() {
        return driverDao.findAll();
    }

    public List<Client> showClients() {
        return clientDao.findAll();
    }

    public Long createDriver(Driver driver) {
        return driverDao.create(driver);
    }
}
