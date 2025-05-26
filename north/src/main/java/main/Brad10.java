package main;
/*
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
 */

public class Brad10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
