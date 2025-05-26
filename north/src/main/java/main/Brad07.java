package main;

import java.util.List;

import org.hibernate.Session;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import model.Employee;

public class Brad07 {
	public static void main(String[] args) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			// Criteria 標準查詢
			/*
			 * CriteriaBuilder => Criteria => session 取得
			 * CriteriaQuery => 查詢物件
			 * Root => 指定查詢結果的物件型別
			 */
			
			// Builder
			CriteriaBuilder builder = session.getCriteriaBuilder();
			// 建立 Criteria
			CriteriaQuery<Employee> cq = builder.createQuery(Employee.class);
			Root<Employee> root = cq.from(Employee.class);
			
			cq.multiselect(
				root.get("title"),
				root.get("firstName"),
				root.get("lastName")
			);
			
			cq.orderBy(
				builder.asc(root.get("title")),
				builder.desc(root.get("lastName"))
			);
			
			List<Employee> employees = session.createQuery(cq).getResultList();
			
			System.out.println("Brad07");
			System.out.println("------");
			for (Employee employee : employees) {
				System.out.printf("%s : %s %s\n",
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
