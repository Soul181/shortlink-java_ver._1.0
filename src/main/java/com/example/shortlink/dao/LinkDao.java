package com.example.shortlink.dao;

import com.example.shortlink.model.Link;
import com.example.shortlink.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.sql.SQLException;

public class LinkDao{

    public Link save(Link link) throws SQLException{
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(link);
        tx1.commit();
        session.close();
        return link;
    }

    public Link getOne(String shortLink) throws  SQLException{
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Link.class, shortLink);
    }
}
