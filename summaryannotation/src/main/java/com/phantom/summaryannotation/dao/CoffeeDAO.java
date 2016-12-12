package com.phantom.summaryannotation.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.phantom.summaryannotation.model.Coffee;

@Repository
@Transactional
public class CoffeeDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public int addCoffee(Coffee coffee) {
		Session session = sessionFactory.getCurrentSession();

		try {
			session.save(Coffee.class.getName(), coffee);
			System.out.println("Added " + coffee.getName());
			return 1;
		} catch (Throwable e) {
			System.out.println("Add " + coffee.getName() + " failed");
			return 0;
		}
	}

	public int updateCoffee(Coffee coffee) {
		Session session = sessionFactory.getCurrentSession();

		try {
			session.update(Coffee.class.getName(), coffee);
			System.out.println("Updated " + coffee.getName());
			return 1;
		} catch (Throwable e) {
			System.out.println("Update " + coffee.getName() + " failed");
			return 0;
		}
	}

	public Coffee findCoffeeByCode(String code) {
		Session session = sessionFactory.getCurrentSession();

		try {
			String sql = "select coffee from " + Coffee.class.getName() + " coffee"
					+ " where coffee.coffeeCode = :code";
			@SuppressWarnings("unchecked")
			Query<Coffee> query = session.createQuery(sql);
			query.setParameter("code", code);

			Coffee coffee = query.getSingleResult();

			return coffee;
		} catch (Throwable e) {
			System.out.println("No coffee found.");
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
			System.out.println("No coffee found.");
			return null;
		}
	}

	public int deleteCoffee(Coffee coffee) {
		Session session = sessionFactory.getCurrentSession();

		try {
			session.delete(Coffee.class.getName(), coffee);
			System.out.println("Delete " + coffee.getName() + " completed");
			return 1;
		} catch (Throwable e) {
			System.out.println("Cannot delete " + coffee.getName());
			return 0;
		}
	}
}
