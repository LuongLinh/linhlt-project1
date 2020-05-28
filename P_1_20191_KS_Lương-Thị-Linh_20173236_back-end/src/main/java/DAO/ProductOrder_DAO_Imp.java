
package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import Model.ProductOrder;

@Repository
public class ProductOrder_DAO_Imp  implements ProductOrder_DAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean saveProductOrder(ProductOrder productorder) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().save(productorder);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<ProductOrder> getProductOrders() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<ProductOrder> query=currentSession.createQuery("from ProductOrder", ProductOrder.class);
		List<ProductOrder> list=query.getResultList();
		return list;
	}

	@Override
	public boolean deleteProductOrder(ProductOrder productorder) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().delete(productorder);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<ProductOrder> getProductOrderByID(ProductOrder productorder) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<ProductOrder> query=currentSession.createQuery("from ProductOrder where productorder_id=:productorder_id", ProductOrder.class);
		query.setParameter("productorder_id", productorder.getProductorder_id());
		List<ProductOrder> list=query.getResultList();
		return list;
	}

	@Override
	public boolean updateProductOrder(ProductOrder productorder) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().update(productorder);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	

}
