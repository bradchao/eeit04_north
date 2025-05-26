package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.fasterxml.jackson.databind.ObjectMapper;

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
			System.out.println("--- JSON 1 ---");
			ObjectMapper mapper = new ObjectMapper();
			String json =
				mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
			System.out.println(json);
			
			toObjectJSON(result);
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	static void toObjectJSON(List<Object[]> result) throws Exception{
		Map<String,Object> output = new HashMap<>();
		output.put("customer", result.get(0)[1]);
		output.put("employee", result.get(0)[0]);
		
		List<Map<String,Object>> details = new ArrayList<>();
		for (Object[] row : result) {
			Map<String,Object> detail = new HashMap<>();
			detail.put("pname", row[2]);
			detail.put("price", row[3]);
			detail.put("qty", row[4]);
			details.add(detail);
		}
		output.put("details", details);
		
		System.out.println("--- JSON 2 ---");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(output);
		System.out.println(json);
		
	}
	
	

}
