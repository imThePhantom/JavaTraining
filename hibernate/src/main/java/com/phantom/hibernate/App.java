package com.phantom.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.phantom.hibernate.model.Employee;

public class App {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();

		System.out.println("Start demo!\n");
		System.out.println("\nQuery Object Demo 1!\n");
		queryObjectDemo2(factory);
		System.out.println("\nQuery Object Demo 2!\n");
		queryObjectDemo1(factory);
		System.out.println("\nQuery Some Column Demo!\n");
		queryColumnDemo(factory);
	}

	private static void queryObjectDemo1(SessionFactory factory) {
		Session session = factory.getCurrentSession();

		try {
			session.getTransaction().begin();

			String sql = "Select e from " + Employee.class.getName() + " e "
					+ " where e.department.deptNo=:deptNo ";
			@SuppressWarnings("unchecked")
			Query<Employee> query = session.createQuery(sql);
			query.setParameter("deptNo", "D10");

			List<Employee> employees = query.getResultList();

			for (Employee employee : employees) {
				System.out.println("Emp: " + employee.getEmpNo() + " : " + employee.getEmpName());
			}

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}

	private static void queryObjectDemo2(SessionFactory factory) {
		Session session = factory.getCurrentSession();

		try {
			session.getTransaction().begin();

			String sql = "Select e from " + Employee.class.getName() + " e "
					+ " order by e.empName, e.empNo ";
			@SuppressWarnings("unchecked")
			Query<Employee> query = session.createQuery(sql);

			List<Employee> employees = query.getResultList();

			for (Employee employee : employees) {
				System.out.println("Emp: " + employee.getEmpNo() + " : " + employee.getEmpName());
			}

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}

	private static void queryColumnDemo(SessionFactory factory) {
		Session session = factory.getCurrentSession();

		try {
			session.getTransaction().begin();

			String sql = "Select e.empId, e.empNo, e.empName from " + Employee.class.getName()
					+ " e ";
			@SuppressWarnings("unchecked")
			Query<Object[]> query = session.createQuery(sql);

			List<Object[]> datas = query.getResultList();

			for (Object[] emp : datas) {
				System.out.println("Emp Id: " + emp[0]);
				System.out.println(" Emp No: " + emp[1]);
				System.out.println(" Emp Name: " + emp[2]);
			}

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
}
