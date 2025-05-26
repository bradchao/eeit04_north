package main;

import java.util.List;

import org.hibernate.Session;


// HQL
public class Brad06 {
	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			String hql = 
				"SELECT e.firstName, e.lastName" + 
				" FROM Employee e ORDER BY e.title ASC, e.lastName DESC";
			
			List<Object[]> employees =
				session.createQuery(hql, Object[].class).getResultList();
			
			System.out.println("Brad06");
			System.out.println("------");
			for (Object[] employee : employees) {
				System.out.printf("%s %s\n",
						employee[1],
						employee[0]
						);
			}
			
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
