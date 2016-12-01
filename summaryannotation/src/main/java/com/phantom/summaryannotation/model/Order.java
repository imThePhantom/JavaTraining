package com.phantom.summaryannotation.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Orders")
public class Order {
	private Long orderId;
	private User user;
	private Set<OrderItem> listItems = new HashSet<OrderItem>();
	private Timestamp purchaseDate;
	private Integer discount;

	public Order() {
	}

	public Order(Long orderId, User user, Set<OrderItem> listItems, Timestamp purchaseDate,
			Integer discount) {
		this.orderId = orderId;
		this.user = user;
		this.listItems = listItems;
		this.purchaseDate = purchaseDate;
		this.discount = discount;
	}

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "order_id")
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
	public Set<OrderItem> getListItems() {
		return listItems;
	}

	public void setListItems(Set<OrderItem> listItems) {
		this.listItems = listItems;
	}

	@Column(name = "purchase_date", nullable = false)
	public Timestamp getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Timestamp purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Column(name = "discount", columnDefinition = "int default 0")
	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
}
