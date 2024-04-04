package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImp implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getUserByCarModelAndSeries(String model, int series) {
        Query<?> query = sessionFactory.getCurrentSession().createQuery("FROM User u WHERE u.car.model = :model" +
                " AND u.car.series = :series");
        query.setParameter("model", model);
        query.setParameter("series", series);
        return (User) query.uniqueResult();
    }
}
