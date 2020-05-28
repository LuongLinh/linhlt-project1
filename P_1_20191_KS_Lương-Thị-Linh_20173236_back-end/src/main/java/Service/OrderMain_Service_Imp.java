package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.OrderMain_DAO;
import Model.OrderMain;

@Service
@Transactional
public class OrderMain_Service_Imp implements OrderMain_Service {
 
	@Autowired
	private OrderMain_DAO ordermaindao;
	
	@Override
	public boolean saveOrderMain(OrderMain ordermain) {
		return ordermaindao.saveOrderMain(ordermain);
	}

	@Override
	public List<OrderMain> getOrderMains() {
		return ordermaindao.getOrderMains();
	}

	@Override
	public boolean deleteOrderMain(OrderMain ordermain) {
		return ordermaindao.deleteOrderMain(ordermain);
	}

	@Override
	public List<OrderMain> getOrderMainByID(OrderMain ordermain) {
		return ordermaindao.getOrderMainByID(ordermain);
	}

	@Override
	public boolean updateOrderMain(OrderMain ordermain) {
		return ordermaindao.updateOrderMain(ordermain);
	}

}
