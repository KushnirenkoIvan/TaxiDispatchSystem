package taxi.dao;

import taxi.domain.Order;

import java.util.List;

public interface OrderDao {

    Long create(Order order);

    Order read(Long id);

    boolean update(Order order);

    boolean delete(Order order);

    List<Order> findAll();

}
