package com.phantom.summaryannotation.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.phantom.summaryannotation.model.Coffee;

public class CoffeeDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public int addCoffee(Coffee coffee) {
		Session session = sessionFactory.getCurrentSession();

		try {
			session.save(Coffee.class.getName(), coffee);

			return 1;
		} catch (Throwable e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int updateCoffee(Coffee coffee) {
		Session session = sessionFactory.getCurrentSession();

		try {
			session.update(Coffee.class.getName(), coffee);

			return 1;
		} catch (Throwable e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return 0;
		}
	}

	public Coffee findCoffeeByCode(String code) {
		Session session = sessionFactory.getCurrentSession();

		try {
			String sql = "select coffee from " + Coffee.class.getName() + " coffee"
					+ " where coffee.coffeecCode = :code";
			@SuppressWarnings("unchecked")
			Query<Coffee> query = session.createQuery(sql);
			query.setParameter("code", code);

			Coffee coffee = query.getSingleResult();

			return coffee;
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Coffee> listCoffee() {
		Session session = sessionFactory.getCurrentSession();

		try {
			String sql = "select coffee from " + Coffee.class.getName() + " coffee"
					+ " order by coffee.coffeeCode";
			@SuppressWarnings("unchecked")
			Query<Coffee> query = session.createQuery(sql);

			List<Coffee> coffees = query.getResultList();

			return coffees;
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}

	public int deleteCoffee(Coffee coffee) {
		Session session = sessionFactory.getCurrentSession();

		try {
			session.delete(Coffee.class.getName(), coffee);

			return 1;
		} catch (Throwable e) {
			e.printStackTrace();

			return 0;
		}
	}
}
