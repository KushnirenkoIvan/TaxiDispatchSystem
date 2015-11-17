package taxi.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import taxi.domain.Order;

import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public OrderDaoImpl() {

    }

    public OrderDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Long create(Order order) {
        return (Long) sessionFactory.getCurrentSession().save(order);
    }

    public Order read(Long id) {
        return (Order) sessionFactory.getCurrentSession().get(Order.class, id);
    }

    public boolean update(Order order) {
        sessionFactory.getCurrentSession().update(order);
        return true;
    }

    public boolean delete(Order order) {
        sessionFactory.getCurrentSession().delete(order);
        return true;
    }

    public List<Order> findAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("from taxi.domain.Order");
        return query.list();
    }
}
