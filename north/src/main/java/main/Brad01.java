package main;

import java.util.List;

import org.hibernate.Session;

import model.Employee;

// SQL
public class Brad01 {
	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			String sql = 
				"SELECT * FROM employees ORDER BY Title ASC, LastName DESC";
			
			List<Employee> employees =
				session.createNativeQuery(sql, Employee.class).getResultList();
			System.out.println("Brad01");
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
