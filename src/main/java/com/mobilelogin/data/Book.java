package com.mobilelogin.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book 
{  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;
    @Column
	private String title;
    @Column
    private String category;
    @Column
    private String subject;
    @Column 
    private String description;
    @Column
    private String author;
    @Column
    private int stock;
	 
	 
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String title, String category, String subject, String description, String author,
			int stock) {
		super();
		this.title = title;
		this.category = category;
		this.subject = subject;
		this.description = description;
		this.author = author;
		this.stock = stock;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", category=" + category + ", subject=" + subject
				+ ", description=" + description + ", author=" + author + ", stock=" + stock + "]";
	}
	
}
