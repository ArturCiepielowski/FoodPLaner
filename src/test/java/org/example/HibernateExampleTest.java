package org.example;

import com.example.Dish;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HibernateExampleTest {
    private SessionFactory sessionFactory;

    @BeforeEach
    protected void setUp() throws Exception{
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try{
            sessionFactory=new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
        }
        catch(Exception e){
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
    @Test
    void save_my_first_object_to_the_db(){
        Dish dish = new Dish("'Classic pizza with tomato, mozzarella, and basil.","Margherita Pizza");

      try(Session session =sessionFactory.openSession()){
    session.beginTransaction();


    session.persist(dish);

    session.getTransaction().commit();
        }
    }
}
