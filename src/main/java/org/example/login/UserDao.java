package org.example.login;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserDao {
    private static final String QUERY_USER_BY_NAME = "FROM User U WHERE U.username = '";
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

    public static User verifyUser(String name, String password) {
        setUp();
        User user = getUserByName(name);
        if (transactionSuccess) {
            if (user.getUsername().equals(name) && user.getPassword().equals(password)) return user;
        }
        sessionFactory.close();
        return null;
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

    public static boolean updateUsername(String oldUsername, String newUsername) {
        setUp();
        User existingUser = getUserByName(oldUsername);
        if (transactionSuccess) {
            if (newUsername != null && !newUsername.isEmpty()) existingUser.setUsername(newUsername);
            updateUserDetails(existingUser);
        }
        sessionFactory.close();
        return transactionSuccess;
    }
    public static boolean updatePassword(String newPassword,String userName) {
        setUp();
        User existingUser = getUserByName(userName);
        if (transactionSuccess) {
            if (newPassword != null && !newPassword.isEmpty()) existingUser.setPassword(newPassword);
            updateUserDetails(existingUser);
        }
        sessionFactory.close();
        return transactionSuccess;
    }

    public static void updateUserDetails(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(user);
        transaction.commit();
        session.close();
    }
}
