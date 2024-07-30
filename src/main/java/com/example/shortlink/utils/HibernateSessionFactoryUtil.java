package com.example.shortlink.utils;

import com.example.shortlink.model.Link;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;
    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() throws HibernateException, NullPointerException{
        if(sessionFactory == null) {
            try{
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Link.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                System.out.println("SessionFactory Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}
