package com.phantom.springbean;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.phantom.springbean.aop.Student;
import com.phantom.springbean.dao.StudentDAO;

public class Main {

	public static void main(String[] args) {
		System.out.println("Bean example");
		System.out.println("\n");

		ApplicationContext context = new ClassPathXmlApplicationContext("helloworld-beans.xml");
		
		StudentDAO studentDAO = (StudentDAO) context.getBean("studentDAO");
		
		List<Student> students = studentDAO.listStudent();
		
		for (Student record : students) {
			studentDAO.delete(record.getId());
		}
		
		studentDAO.create("Toan", 23);
		studentDAO.create("Tung", 24);
		studentDAO.create("Nguyen", 25);

		students = studentDAO.listStudent();

		for (Student record : students) {
			System.out.println("ID: " + record.getId() + ", Name: " + record.getName() + ", Age: "
					+ record.getAge());
		}

		studentDAO.update(2, 25);
		Student student = studentDAO.getStudent(2);
		System.out.println("ID: " + student.getId() + ", Name: " + student.getName() + ", Age: "
				+ student.getAge());
		
		studentDAO.delete(1);

		students = studentDAO.listStudent();

		for (Student record : students) {
			System.out.println("ID: " + record.getId() + ", Name: " + record.getName() + ", Age: "
					+ record.getAge());
		}
		
		((ClassPathXmlApplicationContext) context).close();
	}
}
