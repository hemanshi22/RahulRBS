package com.catalog.dao.methods;

import java.util.List;

import com.catalog.model.Products;

public interface ProductsDao {
	
	public List<Products> getAllProducts();
	
	public Products getProduct(int a);
	

	
}
