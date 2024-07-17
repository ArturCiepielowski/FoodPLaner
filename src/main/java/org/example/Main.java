package org.example;

import org.example.Dish.Dish;
import org.example.Dish.DishDao;
import org.example.chat.MainChat;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        MainChat.displayMainChat();
    }


//    private static void setUpMain(){
//        // Configure Hibernate and build the SessionFactory
//        SessionFactory sessionFactory = new Configuration()
//                .configure()
//                .buildSessionFactory();
//
//        // Create an instance of UserDAO
//        DishDao dishDao = new DishDao(sessionFactory);
//
//        // Create a new User object
//        Dish newDish = new Dish();
//        newDish.setName("test2");
//        newDish.setDescription("Test description22222");
//
//        // Call the create method to save the User to the database
//        dishDao.insert(newDish);
//
//        // Close the SessionFactory
//        sessionFactory.close();
////        Chat chat = new Chat();
//    }
//    private static void setUpMainRead(){
//        // Configure Hibernate and build the SessionFactory
//        SessionFactory sessionFactory = new Configuration()
//                .configure()
//                .buildSessionFactory();
//
//        // Create an instance of UserDAO
//        DishDao dishDao = new DishDao(sessionFactory);
//
//        // Create a new User object
//
//
//        // Call the create method to save the User to the database
//     Dish dish=   dishDao.getDishByName(8L);
//        System.out.println(dish.getName());
//        System.out.println(dish.getDescription());
//        // Close the SessionFactory
//        sessionFactory.close();
////        Chat chat = new Chat();
//    }
}
