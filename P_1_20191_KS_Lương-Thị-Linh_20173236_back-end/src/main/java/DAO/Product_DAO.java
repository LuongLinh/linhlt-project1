package DAO;

import java.util.List;

import Model.Product;

public interface Product_DAO {
	
	public boolean saveProduct(Product product);
	public List<Product> getProducts();
	public boolean deleteProduct(Product product);
	public List<Product> getProductByID(Product product);
	public boolean updateProduct(Product product);

}
