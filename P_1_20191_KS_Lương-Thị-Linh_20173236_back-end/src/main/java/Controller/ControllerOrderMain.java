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

import Model.OrderMain;
import Service.OrderMain_Service;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")
public class ControllerOrderMain {
	
	@Autowired
	private OrderMain_Service ordermainservice;
	
	
	@GetMapping("welcome")
	public String Welcome() {
		return "hello Linh";
	}
	
	
	@PostMapping("save-ordermain")
	public boolean saveOrderMain(@RequestBody OrderMain ordermain) {
		 return ordermainservice.saveOrderMain(ordermain);
		
	}
	
	@GetMapping("ordermains-list/{productorder_id}")
	public List<OrderMain> allordermains() {
		 return ordermainservice.getOrderMains();
	}
	
	
	@DeleteMapping("delete-ordermain/{order_id}")
	public boolean deleteOrderMain(@PathVariable("order_id") int order_id,OrderMain ordermain) {
		ordermain.setOrder_id(order_id);
		return ordermainservice.deleteOrderMain(ordermain);
	}

	@GetMapping("ordermain/{order_id}")
	public List<OrderMain> allordermainByID(@PathVariable("order_id") int order_id,OrderMain ordermain) {
		 ordermain.setOrder_id(order_id);
		 return ordermainservice.getOrderMainByID(ordermain);
		
	}
	
	
	@PostMapping("update-ordermain/{order_id}")
	public boolean updateOrderMain(@RequestBody OrderMain ordermain,@PathVariable("order_id") int order_id) {
		ordermain.setOrder_id(order_id);
		return ordermainservice.updateOrderMain(ordermain);
	}

}
