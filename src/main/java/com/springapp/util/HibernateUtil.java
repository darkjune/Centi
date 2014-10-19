package com.springapp.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by kunrong on 14/10/13.
 */
public class HibernateUtil {
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private static SessionFactory sessionFactory = buildSessionFactory();
    private Session session;
    private static SessionFactory buildSessionFactory(){
        return new Configuration().configure().buildSessionFactory(new StandardServiceRegistryBuilder().build());
    }
}
