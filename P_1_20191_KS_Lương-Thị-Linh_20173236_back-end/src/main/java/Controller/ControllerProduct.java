package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.Product;
import Service.Product_Service;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api")
public class ControllerProduct {

	@Autowired
	private Product_Service productservice;

	@PostMapping("save-product")
	public boolean saveProduct(@RequestBody Product product) {
		return productservice.saveProduct(product);

	}

	@GetMapping("products-list")
	public List<Product> allproducts() {
		return productservice.getProducts();
	}

	@DeleteMapping("delete-product/{product_id}")
	public boolean deleteProduct(@PathVariable("product_id") int product_id, Product product) {
		product.setProduct_id(product_id);
		return productservice.deleteProduct(product);
	}

	@GetMapping("product/{product_id}")
	public List<Product> allproductByID(@PathVariable("product_id") int product_id, Product product) {
		product.setProduct_id(product_id);
		return productservice.getProductByID(product);

	}

	@PostMapping("update-product/{product_id}")
	public boolean updateProduct(@RequestBody Product product, @PathVariable("product_id") int product_id) {
		product.setProduct_id(product_id);
		return productservice.updateProduct(product);
	}

}
