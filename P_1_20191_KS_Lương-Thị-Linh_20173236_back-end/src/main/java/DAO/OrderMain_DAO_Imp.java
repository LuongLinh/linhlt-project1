package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import Model.OrderMain;

@Repository
public class OrderMain_DAO_Imp  implements OrderMain_DAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean saveOrderMain(OrderMain ordermain) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().save(ordermain);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<OrderMain> getOrderMains() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<OrderMain> query=currentSession.createQuery("from OrderMain", OrderMain.class);
		List<OrderMain> list=query.getResultList();
		return list;
	}

	@Override
	public boolean deleteOrderMain(OrderMain ordermain) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().delete(ordermain);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<OrderMain> getOrderMainByID(OrderMain ordermain) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<OrderMain> query=currentSession.createQuery("from OrderMain where order_id=:order_id", OrderMain.class);
		query.setParameter("order_id", ordermain.getOrder_id());
		List<OrderMain> list=query.getResultList();
		return list;
	}

	@Override
	public boolean updateOrderMain(OrderMain ordermain) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().update(ordermain);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	

}
