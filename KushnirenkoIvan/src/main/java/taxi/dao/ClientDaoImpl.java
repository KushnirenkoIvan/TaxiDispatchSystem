package taxi.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import taxi.domain.Client;

import java.util.List;

@Repository
public class ClientDaoImpl implements ClientDao {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public ClientDaoImpl() {
    }

    public ClientDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Long create(Client client) {
        return (Long) sessionFactory.getCurrentSession().save(client);
    }

    public Client read(Long id) {
        return (Client) sessionFactory.getCurrentSession().get(Client.class, id);
    }

    public boolean update(Client client) {
        sessionFactory.getCurrentSession().update(client);
        return true;
    }

    public boolean delete(Client client) {
        sessionFactory.getCurrentSession().delete(client);
        return true;
    }

    public List<Client> findAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("from taxi.domain.Client");
        return query.list();
    }

}
