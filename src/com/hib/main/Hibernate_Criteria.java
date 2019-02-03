package com.hib.main;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hib.entities.Student;
import com.hib.init.HibernateUtil;

public class Hibernate_Criteria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Criteria cr=session.createCriteria(Student.class);
		
		cr.setFetchSize(1);
		
		List<Student>list=cr.list();
		System.out.println(list.toString());
		session.close();
	}

}
