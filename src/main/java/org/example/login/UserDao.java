package org.example.login;

import org.example.chat.UtilChat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserDao {
    private static final String QUERY_USER_BY_NAME = "FROM User U WHERE U.name = '";
    private static SessionFactory sessionFactory;
    public static boolean transactionSuccess;
    public static void setUp() {
        transactionSuccess = true;
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static void insertUser(User user) {
        setUp();
        insert(user);
        sessionFactory.close();
    }

    public static void insert(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(user);
        transaction.commit();
        session.close();
    }

    public static boolean selectUser(String name) {
        setUp();
        User user = getUserByName(name);
        if (transactionSuccess) {
            UtilChat.printPurple("User name: " + user.getUsername());
            UtilChat.printPurple("User password: " + user.getPassword());
        }
        sessionFactory.close();
        return transactionSuccess;
    }

    public static User getUserByName(String name) {
        Session session = sessionFactory.openSession();
        User user = null;
        try {
            user = session.createSelectionQuery(QUERY_USER_BY_NAME + name + "'", User.class).getSingleResult();
        } catch (Exception NoResultException) {
            transactionSuccess = false;
        }
        session.close();
        return user;
    }
}
