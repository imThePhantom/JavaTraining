package com.phantom.summaryannotation.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.phantom.summaryannotation.model.Order;
import com.phantom.summaryannotation.model.User;

@Repository
@Transactional
public class OrderDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public int createOrder(Order order) {
		Session session = sessionFactory.getCurrentSession();

		try {
			session.save(Order.class.getName(), order);

			return 1;
		} catch (Throwable e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int editOrder(Order order) {
		Session session = sessionFactory.getCurrentSession();

		try {
			session.update(Order.class.getName(), order);

			return 1;
		} catch (Throwable e) {
			e.printStackTrace();
			return 0;
		}
	}

	public List<Order> findOrderByUser(User user) {
		Session session = sessionFactory.getCurrentSession();

		try {
			String sql = "select order from " + Order.class.getName() + " order"
					+ " where order.user = :user";
			@SuppressWarnings("unchecked")
			Query<Order> query = session.createQuery(sql);
			query.setParameter("user", user);

			List<Order> orders = query.getResultList();

			return orders;
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Order> findOrderByPurchaseDate(Timestamp purchaseDate) {
		Session session = sessionFactory.getCurrentSession();

		try {
			String sql = "select order from " + Order.class.getName() + " order"
					+ " where order.purchaseDat = :purchaseDate";
			@SuppressWarnings("unchecked")
			Query<Order> query = session.createQuery(sql);
			query.setParameter("purchaseDate", purchaseDate);

			List<Order> orders = query.getResultList();

			return orders;
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}

	public int deleteOrder(Order order) {
		Session session = sessionFactory.getCurrentSession();

		try {
			session.delete(Order.class.getName(), order);

			return 1;
		} catch (Throwable e) {
			e.printStackTrace();
			return 0;
		}
	}
}
