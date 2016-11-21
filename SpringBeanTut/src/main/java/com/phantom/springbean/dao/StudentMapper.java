package com.phantom.springbean.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.phantom.springbean.aop.Student;

public class StudentMapper implements RowMapper<Student>{
	public Student mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		Student student = new Student();
		student.setId(resultSet.getInt("id"));
		student.setName(resultSet.getString("name"));
		student.setAge(resultSet.getInt("age"));
		return student;
	}
}
