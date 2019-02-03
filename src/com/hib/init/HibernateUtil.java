package com.hib.init;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
 
public class HibernateUtil {
     
    private static final SessionFactory sessionFactory;
    private static final ServiceRegistry serviceRegistry;
    private static final File hibernatePropsFile =new File("src/hibernate.cfg.xml");
    static {
        Configuration conf = new Configuration();
        conf.configure(hibernatePropsFile);
        serviceRegistry = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
        try {
            sessionFactory = conf.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }       
    }
     
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}