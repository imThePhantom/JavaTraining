package com.phantom.hibernate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "TimeKeeper")
public class TimeKeeper {
	public static final char IN = 'I';
	public static final char OUT = 'O';

	private String timeKeeperId;
	private Date dateTime;
	private Employee employee;

	private char inOut;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "timekeeper_id", length = 36)
	public String getTimeKeeperId() {
		return timeKeeperId;
	}

	public void setTimeKeeperId(String timeKeeperId) {
		this.timeKeeperId = timeKeeperId;
	}

	@Column(name = "date_time", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "emp_id", nullable = false)
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Column(name = "in_out", nullable = false, length = 1)
	public char getInOut() {
		return inOut;
	}

	public void setInOut(char inOut) {
		this.inOut = inOut;
	}
}
