package Service;

import java.util.List;

import Model.ProductOrder;


public interface ProductOrder_Service {
	
	public boolean saveProductOrder(ProductOrder productorder);
	public List<ProductOrder> getProductOrders();
	public boolean deleteProductOrder(ProductOrder productorder);
	public List<ProductOrder> getProductOrderByID(ProductOrder productorder);
	public boolean updateProductOrder(ProductOrder productorder);
}
