package com.mobilelogin.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mobilelogin.dao.Book_Repository;
import com.mobilelogin.dao.User_Repository;
import com.mobilelogin.data.Book;
import com.mobilelogin.data.User;


@Component
public class LibraryService {

	@Autowired
	private User_Repository userrepo;

	public User findById(String email, String password) 
	{
		User user = userrepo.findByEmailAndPassword(email, password);
		return user;
	}

	@Autowired
	private Book_Repository bookrepo;

	public void delete(int bookId) 
	{
		// TODO Auto-generated method stub
		bookrepo.deleteById(bookId);
		return;
	}

	public Book saveadd(String title, String category, String subject, String description, String author,
			int stock) 
	{
		// TODO Auto-generated method stub
		Book book= new Book();
		book.setAuthor(author);
		book.setCategory(category);
		book.setDescription(description);
		book.setStock(stock);
		book.setSubject(subject);
		book.setTitle(title);
		bookrepo.save(book);
		return book;
	}

	public Book savestock(int bookId, int stock) 
	{
		// TODO Auto-generated method stub
      Book book = bookrepo.getById(bookId);
      book.setStock(stock);
      bookrepo.save(book);
      return book;
	}

	public Book saveup(int bookId, String title, String category, String subject, String description, String author) 
	{
		// TODO Auto-generated method stub
		Book book = bookrepo.getById(bookId);
		System.out.println(book);
		if(title.isEmpty())
		{book.getTitle();}
		else
		{book.setTitle(title);}
		if(category.isEmpty())
		{book.getCategory();}
		else
		{book.setCategory(category);}
		if(subject.isEmpty())
		{book.getSubject();}
		else
		{book.setSubject(subject);}
		if(description.isEmpty())
		{book.getDescription();}
		else
		{book.setDescription(description);}
		if(author.isEmpty())
		{book.getAuthor();}
		else
		{book.setAuthor(author);}
		bookrepo.save(book);
		return book;
	}
public List<Book> searchForBooks(String title,String category, String subject,String author)
{   
	if(Strings.isEmpty(title)) 
	{
		title=null;
	}
	if(Strings.isEmpty(author))
	{
		author=null;
	}
	if(Strings.isEmpty(title) && Strings.isEmpty(author))
	{
		title=null;
		author=null;
	}
	return bookrepo.getbooksLike(title, category, subject, author);
}
	
	public Book rentBook(int bookId) 
	{
		// TODO Auto-generated method stub

		Book book = bookrepo.getById(bookId);
		if (book == null) 
		{
			return null;
		}
		else 
		{
			if (book.getStock() > 0) 
			{
				book.setStock(book.getStock() - 1);
				bookrepo.save(book);
				return book;
			} 
			else 
			{
				return null;
			}
		}
	}
			

