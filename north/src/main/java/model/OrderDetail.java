package model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orderdetails")
@IdClass(OrderDetailPK.class)
public class OrderDetail {
	@Id
	@Column(name = "OrderID")
	private Integer orderId;
	
	@Id
	@Column(name = "ProductID")
	private Integer productId;
	
	@Column(name = "UnitPrice")
	private BigDecimal unitPrice;
	
	@Column(name = "Quantity")
	private Integer quantity;
	
	//------------------------------
	@ManyToOne
	@JoinColumn(name = "OrderID")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "ProductID")
	private Product product;
	//------------------

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
	
	
}
