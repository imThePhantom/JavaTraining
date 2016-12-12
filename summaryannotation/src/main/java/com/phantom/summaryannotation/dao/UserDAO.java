package com.phantom.summaryannotation.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.phantom.summaryannotation.model.User;

@Repository
@Transactional
public class UserDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public int addUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println(sessionFactory);
		System.out.println(session);
		try {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			session.save(User.class.getName(), user);
			System.out.println("Created user: " + user.getUsername() + "|" + user.getEmail() + "|"
					+ user.getPassword() + "|" + user.getRole());

			return 1;
		} catch (Throwable e) {
			System.out.println("Create user failed");
			return 0;
		}
	}

	public int updateUser(User user) {
		Session session = sessionFactory.getCurrentSession();

		try {
			session.update(User.class.getName(), user);
			System.out.println("Updated user: " + user.getUsername() + "|" + user.getEmail() + "|"
					+ user.getPassword() + "|" + user.getRole());

			return 1;
		} catch (Throwable e) {
			System.out.println("Update user failed");
			return 0;
		}
	}

	public int changePassword(User user) {
		Session session = sessionFactory.getCurrentSession();

		try {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			session.update(User.class.getName(), user);
			System.out.println("Change password: " + user.getUsername() + "|" + user.getEmail() + "|"
					+ user.getPassword() + "|" + user.getRole());

			return 1;
		} catch (Throwable e) {
			System.out.println("Update user failed");
			return 0;
		}
	}

	public User findUserByEmail(String email) throws NoResultException {
		Session session = sessionFactory.getCurrentSession();

		try {
			String sql = "select user from " + User.class.getName() + " user"
					+ " where user.email = :email";

			@SuppressWarnings("unchecked")
			Query<User> query = session.createQuery(sql);
			query.setParameter("email", email);
			User user = (User) query.getSingleResult();

			return (user != null) ? user : null;
		} catch (NoResultException e) {
			System.out.println("User not found or get user failed");
			return null;
		}
	}

	public List<User> listUser() throws NoResultException {
		Session session = sessionFactory.getCurrentSession();

		try {
			String sql = "select user from " + User.class.getName() + " user"
					+ " order by user.username";

			@SuppressWarnings("unchecked")
			List<User> users = session.createQuery(sql).getResultList();

			return users;
		} catch (NoResultException e) {
			System.out.println("User not found or get user failed");
			return null;
		}
	}

	public int deleteUser(User user) {
		Session session = sessionFactory.getCurrentSession();

		try {
			session.delete(User.class.getName(), user);
			System.out.println("User " + user.getUsername() + " deleted!");
			return 1;
		} catch (Throwable e) {
			System.out.println("Can not delete user");
			return 0;
		}
	}
}
