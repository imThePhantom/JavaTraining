package com.phantom.springbean.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.phantom.springbean.aop.Student;

public class StudentDAO {
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
	}
	
	public void create(String name, Integer age) {
		String SQL = "insert into Student (name, age) values (?,?)";
		jdbcTemplate.update(SQL, name, age);
		return;
	}
	
	public Student getStudent(Integer id) {
		String SQL = "select * from Student where id = ?";
		Student student = jdbcTemplate.queryForObject(SQL, new Object[]{id}, new StudentMapper());
		return student;
	}
	
	public List<Student> listStudent() {
		String SQL = "select * from Student";
		List<Student> students = jdbcTemplate.query(SQL, new StudentMapper());
		return students;
	}
	
	public void delete(Integer id) {
		String SQL = " delete from Student where id = ?";
		jdbcTemplate.update(SQL, id);
		System.out.println("Id " + id + " has been deleted");
		return;
	}
	
	public void update(Integer id, Integer age) {
		String SQL = "update Student set age = ? where id = ?";
		jdbcTemplate.update(SQL, age, id);
		return;
	}
	
}
