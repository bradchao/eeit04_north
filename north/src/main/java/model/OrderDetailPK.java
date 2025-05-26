package model;

import java.io.Serializable;
import java.util.Objects;

public class OrderDetailPK implements Serializable{
	private Integer orderId;
	private Integer productId;
	
	@Override
	public int hashCode() {
		return Objects.hash(orderId, productId);
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof OrderDetailPK)) return false;
		OrderDetailPK other = (OrderDetailPK)o;
		return orderId == other.orderId && productId == other.productId;
	}
	
	

}
