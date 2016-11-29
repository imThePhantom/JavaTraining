package com.phantom.service;

import java.util.List;

import com.phantom.dao.ProductDAO;
import com.phantom.model.Product;

public class SimpleProductManager implements ProductManager {
	private static final long serialVersionUID = 1L;

	private ProductDAO productDAO;

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@Override
	public List<Product> getProducts() {
		return productDAO.getProductList();
	}

	@Override
	public void increasePrice(int percentage) {
		List<Product> products = productDAO.getProductList();
		if (products != null) {
			for (Product product : products) {
				double newPrice = product.getPrice().doubleValue() * (100 + percentage) / 100;
				product.setPrice(newPrice);
				productDAO.saveProduct(product);
			}
		}
	}

	@Override
	public int createProduct(Product product) {
		return this.productDAO.createProduct(product);
	}

}
