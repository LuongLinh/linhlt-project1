package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import Model.User;

@Repository
public class User_DAO_Imp  implements User_DAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean saveUser(User user) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().save(user);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<User> getUsers() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<User> query=currentSession.createQuery("from User", User.class);
		List<User> list=query.getResultList();
		return list;
	}

	@Override
	public boolean deleteUser(User user) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().delete(user);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<User> getUserByID(User user) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<User> query=currentSession.createQuery("from User where user_id=:user_id", User.class);
		query.setParameter("user_id", user.getUser_id());
		List<User> list=query.getResultList();
		return list;
	}

	@Override
	public boolean updateUser(User user) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().update(user);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	

}
