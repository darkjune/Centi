package com.springapp.service;

import com.springapp.domain.Entries;
import com.springapp.util.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by kunrong on 14/10/12.
 */
public class DBTests {
    private static SessionFactory sessionFactory = buildSessionFactory();
    private Session session;
    Logger logger = LogManager.getLogger(this.getClass().getName());

    private static SessionFactory buildSessionFactory(){
            return new Configuration().configure().buildSessionFactory(new StandardServiceRegistryBuilder().build());
    }
    @Before
    public void before(){
        AnnotationConfiguration configuration = new AnnotationConfiguration();
        logger.debug("test");

    }

    @Test
    public void testDB(){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Entries entries = new Entries();
        entries.setOwner("test");
        session.save(entries);
        session.getTransaction().commit();
    }

}
