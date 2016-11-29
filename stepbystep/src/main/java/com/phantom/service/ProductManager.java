package com.phantom.service;

import java.io.Serializable;
import java.util.List;

import com.phantom.model.Product;

public interface ProductManager extends Serializable{
	
	public void increasePrice(int percentage);
	public List<Product> getProducts();
	public int createProduct(Product product);
}
