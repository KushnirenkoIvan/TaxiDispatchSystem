package taxi.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import taxi.domain.Operator;

import java.util.List;

@Repository
public class OperatorDaoImpl implements OperatorDao {

    @Autowired
    private SessionFactory sessionFactory;


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public OperatorDaoImpl() {
    }

    public OperatorDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Long create(Operator operator) {
        return (Long) sessionFactory.getCurrentSession().save(operator);
    }

    public Operator read(Long id) {
        return (Operator) sessionFactory.getCurrentSession().get(Operator.class, id);
    }

    public boolean update(Operator operator) {
        sessionFactory.getCurrentSession().update(operator);
        return true;
    }


    public boolean delete(Operator operator) {
        sessionFactory.getCurrentSession().delete(operator);
        return true;
    }

    public List<Operator> findAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("from taxi.domain.Operator");
        return query.list();
    }

    public Operator findByName(String login) {
        Query query = sessionFactory.getCurrentSession().createQuery("select o from taxi.domain.Operator o where o.login =:login");
        query.setParameter("login", login);
        List<Operator> operator = query.list();
        if (operator != null && operator.size() > 0) {
            return operator.get(0);
        } else {
            return null;
        }
    }

}