package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.Product_DAO;
import Model.Product;

@Service
@Transactional
public class Product_Service_Imp implements Product_Service {

	@Autowired
	private Product_DAO productdao;

	@Override
	public boolean saveProduct(Product product) {
		return productdao.saveProduct(product);
	}

	@Override
	public List<Product> getProducts() {
		return productdao.getProducts();
	}

	@Override
	public boolean deleteProduct(Product product) {
		return productdao.deleteProduct(product);
	}

	@Override
	public List<Product> getProductByID(Product product) {
		return productdao.getProductByID(product);
	}

	@Override
	public boolean updateProduct(Product product) {
		return productdao.updateProduct(product);
	}

}
