package com.jbt.b.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BookDAO {

	public static void createPrep(Book book, Connection con) throws SQLException {
		PreparedStatement pstmt = con.prepareStatement("insert into books values(?,?,?,?,?)");
		pstmt.setInt(1, book.getId());
		pstmt.setString(2, book.getTitle());
		pstmt.setString(3, book.getAuthor());
		pstmt.setDouble(4, book.getPrice());
		pstmt.setDate(5, book.getReleaseDate());	
		pstmt.executeUpdate();
	}
	
	public static void create(Book book, Connection con) throws SQLException {
		Statement stmt = con.createStatement();
		String sql = "INSERT INTO books VALUES(" + book.getId() + ", '"
				+ book.getTitle() + "', '" + book.getAuthor() + "', "
				+ book.getPrice() + ", '" + book.getReleaseDate() + "')";
		stmt.executeUpdate(sql);
		System.out.println("success: " + sql);
	}

	public static void update(Book book, Connection con) throws SQLException {
		Statement stmt = con.createStatement();
		String sql = "UPDATE books set title='"
				+ book.getTitle() + "', author= '" + book.getAuthor() 
				+ "', price="  + book.getPrice() + ", release_date='" + book.getReleaseDate() 
				+ "' where id="+ book.getId() ;
		stmt.executeUpdate(sql);
		System.out.println("success: " + sql);
	}
	
	public static void delete(Book book, Connection con) throws SQLException {
		Statement stmt = con.createStatement();
		String sql = "DELETE from books where id="+ book.getId() ;
		stmt.executeUpdate(sql);
		System.out.println("success: " + sql);
	}
	
	

}

