package com.cdac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("productInventory1")
public class ProductInventoryImpl1 implements ProductInventory {

	@Override
	public void add(Product product) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac","root","passw0rd");
			String sql = "insert into tbl_product (name, price, quantity) values (?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, product.getName());
			stmt.setDouble(2, product.getPrice());
			stmt.setInt(3, product.getQuantity());
			stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}		
	}

	@Override
	public List<Product> getAvailableProducts() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			long ms1 = System.currentTimeMillis();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac","root","passw0rd");
			long ms2 = System.currentTimeMillis();
			System.out.println("time taken to connect approx : " + (ms2 - ms1) + " ms");
			String sql = "select * from tbl_product";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			List<Product> list = new ArrayList<>();
			while(rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setPrice(rs.getDouble(3));
				p.setQuantity(rs.getInt(4));
				list.add(p);
			}
			return list;
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null; //instead we should throw exception
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}

	}

	
}
