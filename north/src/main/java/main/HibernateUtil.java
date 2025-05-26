package main;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Employee;
import model.Product;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration config = new Configuration();
				config.configure("hibernate.cfg.xml");
				
				config.addAnnotatedClass(Employee.class);
				config.addAnnotatedClass(Product.class);
				
				sessionFactory = config.buildSessionFactory();
				
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		return sessionFactory;
	}
}
