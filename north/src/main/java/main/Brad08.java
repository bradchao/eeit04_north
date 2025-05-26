package main;

import java.util.List;

import org.hibernate.Session;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import model.Employee;
import model.Product;

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
			CriteriaQuery<Product> cq = builder.createQuery(Product.class);
			Root<Product> root = cq.from(Product.class);
			
			Predicate stockLow = builder.lessThanOrEqualTo(
					root.get("unitsInStock"), root.get("reorderLevel"));
			
			cq.multiselect(root.get("productName"),
					root.get("unitsInStock"),
					root.get("unitsOnOrder"),
					root.get("reorderLevel")).where(stockLow);
			
			List<Product> results = session.createQuery(cq).getResultList();
			for (Product product: results) {
				System.out.printf("%s:%d:%d:%d\n",
						product.getProductName(),
						product.getUnitsInStock(),
						product.getReorderLevel(),
						product.getUnitsOnOrder());
			}
			System.out.println("--- JSON ---");
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(results);
			System.out.println(json);
			
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
