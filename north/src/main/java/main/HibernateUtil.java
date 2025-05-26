package main;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Customer;
import model.Employee;
import model.Order;
import model.OrderDetail;
import model.Product;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration config = new Configuration();
				config.configure("hibernate.cfg.xml");
				
				config.addAnnotatedClass(Customer.class);
				config.addAnnotatedClass(Employee.class);
				config.addAnnotatedClass(Order.class);
				config.addAnnotatedClass(OrderDetail.class);
				config.addAnnotatedClass(Product.class);
				
				sessionFactory = config.buildSessionFactory();
				
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		return sessionFactory;
	}
}
