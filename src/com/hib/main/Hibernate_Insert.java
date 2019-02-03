package com.hib.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
 
import com.hib.entities.Student;
import com.hib.init.HibernateUtil;
 
public class Hibernate_Insert {
 
    public static void main(String[] args) {
 
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
         
        Student student = new Student();
        student.setFirstName("MS Dhoni");
        student.setAge(36);
         
        session.save(student);
        session.getTransaction().commit();
         
        session.close();
 
    }
}
