package Service;

import java.util.List;

import Model.OrderMain;

public interface OrderMain_Service {


	
	public boolean saveOrderMain(OrderMain ordermain);
	public List<OrderMain> getOrderMains();
	public boolean deleteOrderMain(OrderMain ordermain);
	public List<OrderMain> getOrderMainByID(OrderMain ordermain);
	public boolean updateOrderMain(OrderMain ordermain);
}
