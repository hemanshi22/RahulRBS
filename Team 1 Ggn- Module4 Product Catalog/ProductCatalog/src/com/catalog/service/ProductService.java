package com.catalog.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.catalog.dao.implement.ProductsDaoImpl;
import com.catalog.model.Products;

@Path("/Products")
public class ProductService {

	@GET
	@Path("/getAllData")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Products> getAllProducts() {

		ProductsDaoImpl productsDao = new ProductsDaoImpl();
		return productsDao.getAllProducts();
	}

	@GET
	@Path("/getByPid/{pid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Products getProduct(@PathParam("pid") int pid) {

		ProductsDaoImpl productsDao = new ProductsDaoImpl();
		return productsDao.getProduct(pid);

	}

}
