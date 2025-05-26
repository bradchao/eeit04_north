package main;

import java.util.List;

import org.hibernate.Session;

import model.Employee;

// HQL
public class Brad04 {
	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			String hql = 
				"FROM Employee e ORDER BY e.title ASC, e.lastName DESC";
			
			List<Employee> employees =
				session.createQuery(hql, Employee.class).getResultList();
			
			System.out.println("Brad04");
			System.out.println("------");
			for (Employee employee : employees) {
				System.out.printf("%d. %s : %s %s\n",
						employee.getEmployeeId(),
						employee.getTitle(),
						employee.getLastName(),
						employee.getFirstName()
						);
			}
			
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
