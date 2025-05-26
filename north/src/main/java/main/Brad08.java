package main;

import java.util.List;

import org.hibernate.Session;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import model.Employee;

/*
	SELECT ProductName, UnitsInStock, ReorderLevel, UnitsOnOrder 
	FROM `products` 
	WHERE UnitsInStock <= ReorderLevel
 */
public class Brad08 {

	public static void main(String[] args) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			// Criteria 標準查詢
			// Builder
			CriteriaBuilder builder = session.getCriteriaBuilder();
			// 建立 Criteria
			CriteriaQuery<Employee> cq = builder.createQuery(Employee.class);
			Root<Employee> root = cq.from(Employee.class);
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
