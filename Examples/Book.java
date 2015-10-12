package com.jbt.b.dao;

import java.sql.Date;

/** Book instances represent a row in the db table */
public class Book {

	private int id; // primary key
	private String title;
	private String author;
	private double price;
	private Date releaseDate;

	public Book(int id, String title, String author, double price,
			Date releaseDate) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.releaseDate = releaseDate;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", price="
				+ price + ", releaseDate=" + releaseDate + "]";
	}

}
