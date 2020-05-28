package Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class OrderMain {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer order_id;

    @Column
    private String buyer_email;

    @Column
    private String buyer_name;

    @Column
    private String buyer_phone;

    @Column
    private String buyer_address;

    @Column
    private Float order_amount;
    
    @OneToMany(mappedBy = "orderMain")
	private List<ProductOrder> products = new ArrayList<>();

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public String getBuyer_email() {
		return buyer_email;
	}

	public void setBuyer_email(String buyer_email) {
		this.buyer_email = buyer_email;
	}

	public String getBuyer_name() {
		return buyer_name;
	}

	public void setBuyer_name(String buyer_name) {
		this.buyer_name = buyer_name;
	}

	public String getBuyer_phone() {
		return buyer_phone;
	}

	public void setBuyer_phone(String buyer_phone) {
		this.buyer_phone = buyer_phone;
	}

	public String getBuyer_address() {
		return buyer_address;
	}

	public void setBuyer_address(String buyer_address) {
		this.buyer_address = buyer_address;
	}

	public Float getOrder_amount() {
		return order_amount;
	}

	public void setOrder_amount(Float order_amount) {
		this.order_amount = order_amount;
	}

	public List<ProductOrder> getProducts() {
		return products;
	}

	public void setProducts(List<ProductOrder> products) {
		this.products = products;
	}

}
