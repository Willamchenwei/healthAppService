package com.health.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

import com.health.dao.IHistoryDao;
import com.health.model.History;
import com.health.model.User;
@Repository
public class HistoryDao implements IHistoryDao {
	@Resource
	private SessionFactory sessionFactory;
	@Override
	public boolean addorUpdataHistory(History history) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(history);
		transaction.commit();
		session.close();
		return true;
	}

	@Override
	public List<History> getHistory(int userId) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from History where userId = '"
				+ userId +"' " );
		List<History> list = query.list();
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
