package com.health.dao.impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.aspectj.lang.annotation.Before;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Test;
import org.springframework.stereotype.Repository;

import com.health.dao.IUserDao;
import com.health.model.DynamicPicture;
import com.health.model.PhysicalCondition;
import com.health.model.User;
import com.health.model.UserDetails;
import com.health.model.UserDynamic;
@Repository
public class UserDao implements IUserDao {
	@Resource
	private SessionFactory sessionFactory;
	public User checkUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from User where userName='"
		+user.getUserName()+"' and userPassword='"+user.getUserPassword()+"'" );
		List<User> list = query.list();
		if (list.size() != 0) {
			User user1 = new User();
			user1 = list.get(0);
			transaction.commit();
			session.close();
			return user1;
		}
		transaction.commit();
		session.close();
		return null;
	}
	
	public boolean addorUpdataUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(user);
		UserDetails userDetails = user.getUserDetails();
		List<UserDynamic> list = user.getUserDynamic();
		if (userDetails != null) {
			userDetails.setUser(user);
			session.saveOrUpdate(userDetails);
		}
		if (list.size() != 0) {
			Iterator<UserDynamic> it = list.iterator();
			while (it.hasNext()) {
				UserDynamic dynamic = it.next();
				dynamic.setUser(user);
				System.out.println(dynamic);
				session.saveOrUpdate(dynamic);
				List<DynamicPicture> l = dynamic.getPictureList();
				if (l.size() != 0) {
					Iterator<DynamicPicture> i = l.iterator();
					while (i.hasNext()) {
						DynamicPicture p = i.next();
						p.setUserDynamic(dynamic);
						session.saveOrUpdate(p);
					}
				}
			}
		}
		transaction.commit();
		session.close();
		return true;
	}

	public User getUser(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from User where id = '"
				+ id +"' " );
		
		List<User> list = query.list();
		System.out.println(list);
		if (list.size() != 0) {
			transaction.commit();
			session.close();
			System.out.println(list.get(0));
			return list.get(0);
		}
		transaction.commit();
		session.close();
		return null;
	}
	public UserDetails getUserDetails (int id) {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from UserDetails where id = '"
				+ id +"' " );
		List<UserDetails> list = query.list();
		if (list.size() != 0) {
			transaction.commit();
			session.close();
			return list.get(0);
		}
		transaction.commit();
		session.close();
		return null;
	}

	@Override
	public User getUser(String userName) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from User where userName = '"
				+ userName +"' " );
		List<User> list = query.list();
		if (list.size() != 0) {
			transaction.commit();
			session.close();
			return list.get(0);
		}
		transaction.commit();
		session.close();
		return null;
	} 

}
