package com.JSP.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.JSP.model.Product;
import com.JSP.util.DbUtil;

public class ProductDao {

    private Connection connection;

    public ProductDao() {
        connection = DbUtil.getConnection();
    }

    public void addProduct(Product product) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into products(price,producer,model) values (?, ?, ? )");
            preparedStatement.setFloat(1, product.getPrice());
            preparedStatement.setString(2, product.getProducer());
            preparedStatement.setString(3, product.getModel());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int productId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from products where productId=?");
         
            preparedStatement.setInt(1, productId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProduct(Product product) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update products set price=?, producer=?, model=?" +
                            "where productId=?");
      
            preparedStatement.setFloat(1, product.getPrice());
            preparedStatement.setString(2, product.getProducer());
            preparedStatement.setString(3, product.getModel());
            preparedStatement.setInt(4, product.getProductId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<Product>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from products");
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("productId"));
                product.setPrice(rs.getFloat("price"));
                product.setProducer(rs.getString("producer"));
                product.setModel(rs.getString("model"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    public Product getProductById(int productId) {
        Product product = new Product();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from products where productId=?");
            preparedStatement.setInt(1, productId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                product.setProductId(rs.getInt("productId"));
                product.setPrice(rs.getFloat("price"));
                product.setProducer(rs.getString("producer"));
                product.setModel(rs.getString("model"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }
}