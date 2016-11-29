package com.phantom.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SalaryGrade")
public class SalaryGrade {
	private Integer grade;
	private Float lowSalary;
	private Float hightSalary;

	public SalaryGrade() {
		super();
	}

	public SalaryGrade(Integer grade, Float lowSalary, Float hightSalary) {
		super();
		this.grade = grade;
		this.lowSalary = lowSalary;
		this.hightSalary = hightSalary;
	}

	@Id
	@Column(name = "grade")
	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	@Column(name = "low_salary", nullable = false)
	public Float getLowSalary() {
		return lowSalary;
	}

	public void setLowSalary(Float lowSalary) {
		this.lowSalary = lowSalary;
	}

	@Column(name = "high_salary", nullable = false)
	public Float getHightSalary() {
		return hightSalary;
	}

	public void setHightSalary(Float hightSalary) {
		this.hightSalary = hightSalary;
	}
}
