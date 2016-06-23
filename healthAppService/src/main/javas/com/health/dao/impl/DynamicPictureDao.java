package com.health.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

import com.health.dao.IDynamicPictureDao;
import com.health.model.DynamicPicture;
import com.health.model.History;
@Repository
public class DynamicPictureDao implements IDynamicPictureDao {
	@Resource
	private SessionFactory sessionFactory;
	@Override
	public boolean save(DynamicPicture dynamicPicture) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println(dynamicPicture);
		session.save(dynamicPicture);
		transaction.commit();
		session.close();
		return true;
	}

	@Override
	public List<DynamicPicture> get(int userDynamicId) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from DynamicPicture where userId = '"
				+ userDynamicId +"' " );
		List<DynamicPicture> list = query.list();
		if (list.size() != 0) {
			transaction.commit();
			session.close();
			return list;
		}
		transaction.commit();
		session.close();
		return null;
	}

}
