package domain;

import javax.persistence.*;

@Entity
@Table(name = "order_line")
public class OrderLine {

	@Id
	@GeneratedValue

	private long id;
	private int quantity;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private Product product;

	public OrderLine() {
	}

	public OrderLine(int quantity, Product product) {
		this.quantity = quantity;
		this.product = product;
	}


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
