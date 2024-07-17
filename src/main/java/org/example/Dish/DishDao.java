package org.example.Dish;

import org.example.chat.UtilChat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Random;

public class DishDao {
    private static final String QUERY_DISH_BY_NAME = "FROM Dish D WHERE D.name = '";
    private static SessionFactory sessionFactory;
    public static boolean transactionSuccess;

    public static void setUp() {
        transactionSuccess = true;
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static void insertDish(Dish dish) {
        setUp();
        insert(dish);
        sessionFactory.close();
    }

    public static void insert(Dish dish) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(dish);
        transaction.commit();
        session.close();
    }

    public static boolean selectDish(String name) {
        setUp();
        Dish dish = getDishByName(name);
        if (transactionSuccess) {
            UtilChat.printPurple("Dish name: " + dish.getName());
            UtilChat.printPurple("Dish description: " + dish.getDescription());
        }
        sessionFactory.close();
        return transactionSuccess;
    }

    public static Dish getDishByName(String name) {
        Session session = sessionFactory.openSession();
        Dish dish = null;
        try {
            dish = session.createSelectionQuery(QUERY_DISH_BY_NAME + name + "'", Dish.class).getSingleResult();
        } catch (Exception NoResultException) {
            transactionSuccess = false;
        }
        session.close();
        return dish;
    }

    public static boolean updateDish(String dishName, String newName, String newDescription) {
        setUp();
        Dish existingDish = getDishByName(dishName);
        if (transactionSuccess) {
            if (newName != null && !newName.isEmpty()) existingDish.setName(newName);
            if (newDescription != null && !newDescription.isEmpty()) existingDish.setDescription(newDescription);
            update(existingDish);
        }
        sessionFactory.close();
        return transactionSuccess;
    }

    public static void update(Dish dish) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(dish);
        transaction.commit();
        session.close();
    }

    public static boolean deleteDish(String dishName) {
        setUp();
        Dish existingDish = getDishByName(dishName);
        if (transactionSuccess) delete(existingDish);
        sessionFactory.close();
        return transactionSuccess;
    }

    public static void delete(Dish dish) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(dish);
        transaction.commit();
        session.close();
    }

    public static void printAllDishes() {
        setUp();
        List<Dish> dishList = listAllDishes();
        for (Dish nextDish : dishList) {
            System.out.println(nextDish.toString());
        }
        sessionFactory.close();
    }

    public static List<Dish> listAllDishes() {
        Session session = sessionFactory.openSession();
        List<Dish> dishList = session.createQuery("from Dish", Dish.class).list();
        session.close();
        return dishList;
    }

    public static Dish getRandomFood() {
        setUp();
        List<Dish> dishList = listAllDishes();
        Random randomFood = new Random();
        int randomIndex = randomFood.nextInt(dishList.size());
        sessionFactory.close();
        return dishList.get(randomIndex);
    }
}
