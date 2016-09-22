package com.catalog.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.catalog.connection.Connections;
import com.catalog.dao.methods.ProductsDao;
import com.catalog.model.Products;

public class ProductsDaoImpl implements ProductsDao {

	public List<Products> getAllProducts() {

		List<Products> list = new ArrayList<Products>();
		Connection connection = Connections.getConnections();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM PRODUCTS");
			while (resultSet.next()) {
				Products products = new Products();
				products.setProductType(resultSet.getString(2));
				products.setDescription(resultSet.getString(3));
				list.add(products);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			Connections.closeConnections(connection);
		}
		return list;

	}

	public Products getProduct(int a) {

		Products products = new Products();
		Connection connection = Connections.getConnections();
		try {
			String select = "select * from products where product_id=?";

			PreparedStatement preparedStatement = connection.prepareStatement(select);

			preparedStatement.setInt(1, a);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				products.setProductType(resultSet.getString(2));
				products.setDescription(resultSet.getString(3));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			Connections.closeConnections(connection);
		}
		return products;
	}

}
