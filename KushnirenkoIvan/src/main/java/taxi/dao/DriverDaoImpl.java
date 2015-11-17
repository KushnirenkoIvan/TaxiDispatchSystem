package taxi.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import taxi.domain.Driver;

import java.util.List;

@Repository
public class DriverDaoImpl implements DriverDao {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public DriverDaoImpl() {
    }

    public DriverDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Long create(Driver driver) {
        return (Long) sessionFactory.getCurrentSession().save(driver);
    }

    public Driver read(Long id) {
        return (Driver) sessionFactory.getCurrentSession().get(Driver.class, id);
    }

    public boolean update(Driver driver) {
        sessionFactory.getCurrentSession().update(driver);
        return true;
    }

    public boolean delete(Driver driver) {
        sessionFactory.getCurrentSession().delete(driver);
        return true;
    }

    public List<Driver> findAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("from taxi.domain.Driver");
        return query.list();
    }
}
