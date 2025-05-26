package main;

import java.util.List;

import org.hibernate.Session;

/*
 * SQL:
 * SELECT 
		e.LastName,
	    c.CompanyName,
	    p.ProductName,
	    od.UnitPrice,
	    od.Quantity
	FROM orders o
	JOIN employees e ON o.EmployeeID = e.EmployeeID
	JOIN customers c ON o.CustomerID = c.CustomerID
	JOIN orderdetails od ON o.OrderID = od.OrderID
	JOIN products p ON od.ProductID = p.ProductID
	WHERE o.OrderID = 10248

  * HQL:
  	SELECT 
		o.employee.lastName,
	    o.customer.companyName,
	    p.productName,
	    d.unitPrice,
	    d.quantity
	FROM Order o
	JOIN o.orderDetails d
	JOIN d.product p
	WHERE o.orderId = 10248
 */

public class Brad10 {

	public static void main(String[] args) {
		String hql = "SELECT "
				+ "		o.employee.lastName,"
				+ "	    o.customer.companyName,"
				+ "	    p.productName,"
				+ "	    d.unitPrice,"
				+ "	    d.quantity"
				+ "	FROM Order o"
				+ "	JOIN o.orderDetails d"
				+ "	JOIN d.product p"
				+ "	WHERE o.orderId = :orderId";
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			
			List<Object[]> result = session.createQuery(hql, Object[].class)
									.setParameter("orderId", 10250)
									.getResultList();
			for (Object[] row : result) {
				System.out.println("Employee:" + row[0]);
				System.out.println("Customer:" + row[1]);
				System.out.println("Product:" + row[2] + ":" + row[3] + ":" +row[4]);
				System.out.println("-----");
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		
		
		
	}

}
