package com.jbt.b.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class CarDB {

	public static void addCar(PreparedStatement stmt,int id, String brand,int year,double price) throws SQLException
	{
		stmt.setInt(1, id);
		stmt.setString(2, brand);
		stmt.setInt(3, year);
		stmt.setDouble(4, price);
		stmt.executeUpdate();
	}
	
	public static void showQuery(Statement stmt,String sql) throws SQLException
	{
		ResultSet rs=stmt.executeQuery(sql);
		ResultSetMetaData md=rs.getMetaData();
		while(rs.next())
		{
			for(int k=1;k<=md.getColumnCount();k++)
			{
				System.out.print(rs.getObject(k)+ "  ");
			}
			System.out.println("\n");
		}
	}
	
	public static void main(String[] args) {
		
		String driverName = "org.apache.derby.jdbc.ClientDriver40";
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		System.out.println("driver class loaded");

		String url = "jdbc:derby://localhost:1527/db1";

		try (Connection con = DriverManager.getConnection(url);) 
		{	
			PreparedStatement pstmt=con.prepareStatement("insert into cars values(?,?,?,?)");
			Statement stmt=con.createStatement();
			
			addCar(pstmt, 1, "subaru", 2013, 70000);
			addCar(pstmt, 2, "ford", 2000, 35000);
			addCar(pstmt, 3, "toyota", 2008, 40000);
			
			showQuery(stmt, "select * from cars");
			
			pstmt=con.prepareStatement("update cars set price=price*0.9");
			pstmt.executeUpdate();
			
			showQuery(stmt, "select * from cars");

			showQuery(stmt, "select * from cars where brand='ford'");
			showQuery(stmt, "select * from cars where price<50000");

			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("connection to db1 closed");
}
}