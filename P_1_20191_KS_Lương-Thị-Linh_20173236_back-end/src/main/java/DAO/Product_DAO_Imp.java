package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.Product;

@Repository
public class Product_DAO_Imp implements Product_DAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveProduct(Product product) {
		boolean status = false;
		try {
			sessionFactory.getCurrentSession().save(product);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Product> getProducts() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Product> query = currentSession.createQuery("from Product", Product.class);
		List<Product> list = query.getResultList();
		return list;
	}

	@Override
	public boolean deleteProduct(Product product) {
		boolean status = false;
		try {
			sessionFactory.getCurrentSession().delete(product);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Product> getProductByID(Product product) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Product> query = currentSession.createQuery("from Product where product_id=:product_id", Product.class);
		query.setParameter("product_id", product.getProduct_id());
		List<Product> list = query.getResultList();
		return list;
	}

	@Override
	public boolean updateProduct(Product product) {
		boolean status = false;
		try {
			sessionFactory.getCurrentSession().update(product);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
