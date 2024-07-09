package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DishDao {
    private SessionFactory sessionFactory;

    public DishDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setUp(){
         sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();
    }
    public void create(Dish dish) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(dish);
        transaction.commit();
        session.close();
    }
    public Dish read(Long id) {
        Session session = sessionFactory.openSession();
        Dish dish= session.get(Dish.class, id);
        session.close();
        return dish;
    }
    public void update(Dish dish) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(dish);
        transaction.commit();
        session.close();
    }
    public void delete(Dish dish) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(dish);
        transaction.commit();
        session.close();
    }

    public List<Dish> list() {
        Session session = sessionFactory.openSession();
        List<Dish> users = session.createQuery("from Dish", Dish.class).list();
        session.close();
        return users;
    }


}
