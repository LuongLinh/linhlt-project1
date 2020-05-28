package Model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class ProductOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productorder_id;
	private Integer category_type;
	private Integer product_count;
	private String product_description;
	private String product_image;
	private String product_name;
	private BigDecimal product_price;
	
	@ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;
	
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private OrderMain orderMain;
	

	public Integer getProductorder_id() {
		return productorder_id;
	}

	public void setProductorder_id(Integer productorder_id) {
		this.productorder_id = productorder_id;
	}

	public Integer getCategory_type() {
		return category_type;
	}

	public void setCategory_type(Integer category_type) {
		this.category_type = category_type;
	}

	public Integer getProduct_count() {
		return product_count;
	}

	public void setProduct_count(Integer product_count) {
		this.product_count = product_count;
	}

	public String getProduct_description() {
		return product_description;
	}

	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public BigDecimal getProduct_price() {
		return product_price;
	}

	public void setProduct_price(BigDecimal product_price) {
		this.product_price = product_price;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public OrderMain getOrderMain() {
		return orderMain;
	}

	public void setOrderMain(OrderMain orderMain) {
		this.orderMain = orderMain;
	}

}