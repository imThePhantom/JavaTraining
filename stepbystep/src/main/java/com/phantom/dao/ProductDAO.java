package com.phantom.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.phantom.model.Product;

public class ProductDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	public ProductDAO() {
		
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
	}
	
	public java.util.List<Product> getProductList() {
		logger.info("Getting Products");
		String sql = "select * from products";
		ProductMapper mapper = new ProductMapper();
		List<Product> products = jdbcTemplate.query(sql, mapper);
		return products;
	}

	public int createProduct(Product product) {
		logger.info("Save new product: " + product.getName());
		String sql = "insert into products (name, description, price) values (?,?,?)";
		return jdbcTemplate.update(sql, product.getName(), product.getDescription(),
				product.getPrice());
	}

	public int saveProduct(Product product) {
		logger.info("Saving product: " + product.getName());
		String sql = "update products set price = ? where id = ? ";
		return jdbcTemplate.update(sql, product.getPrice(), product.getId());
	}

	public static class ProductMapper implements RowMapper<Product> {
		public Product mapRow(ResultSet resSet, int rowNum) throws SQLException {
			int id = resSet.getInt("id");
			String name = resSet.getString("name");
			String description = resSet.getString("description");
			Double price = resSet.getDouble("price");
			return new Product(id, name, description, price);
		}
	}
}
