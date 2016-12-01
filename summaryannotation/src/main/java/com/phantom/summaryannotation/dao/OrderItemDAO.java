package com.phantom.summaryannotation.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.phantom.summaryannotation.model.Coffee;
import com.phantom.summaryannotation.model.Order;
import com.phantom.summaryannotation.model.OrderItem;

public class OrderItemDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public int editOrderItem(OrderItem orderItem) {
		Session session = sessionFactory.getCurrentSession();

		try {
			session.saveOrUpdate(orderItem);

			return 1;
		} catch (Throwable e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int deleteOrderItem(OrderItem orderItem) {
		Session session = sessionFactory.getCurrentSession();

		try {
			session.delete(orderItem);

			return 1;
		} catch (Throwable e) {
			e.printStackTrace();
			return 0;
		}
	}

	public List<OrderItem> findOrderItemByOrder(Order order) {
		Session session = sessionFactory.getCurrentSession();

		try {
			String sql = "select orderItem from " + OrderItem.class.getName() + " orderItem"
					+ " where orderItem.orderId = :orderId";
			@SuppressWarnings("unchecked")
			Query<OrderItem> query = session.createQuery(sql);
			query.setParameter("orderId", order.getOrderId());

			List<OrderItem> orderItems = query.getResultList();

			return orderItems;
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<OrderItem> findOrderItemByCoffee(Coffee coffee) {
		Session session = sessionFactory.getCurrentSession();

		try {
			String sql = "select orderItem from " + OrderItem.class.getName() + " orderItem"
					+ " where orderItem.coffeeId = :coffeeId";
			@SuppressWarnings("unchecked")
			Query<OrderItem> query = session.createQuery(sql);
			query.setParameter("coffeeId", coffee.getCoffeeId());

			List<OrderItem> orderItems = query.getResultList();

			return orderItems;
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}
}
