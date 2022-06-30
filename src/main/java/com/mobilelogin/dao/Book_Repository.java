package com.mobilelogin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mobilelogin.data.Book;




@Repository
public interface Book_Repository extends JpaRepository<Book,Integer>
{
//	@Query(value="SELECT c FROM libary_manger.book c WHERE"+"MATCH(title,category,subject,author)"+"AGAINST(?1)",nativeQuery=true)
//		public List<Book> getbooks(String title);
	@Query(value="SELECT b FROM Book b WHERE b.title LIKE %:t% or b.author LIKE %:a% or b.category=:c or b.subject=:s ")
	public List<Book> getbooksLike(@Param("t")String title,@Param("c")String category,@Param("s")String subject,@Param("a")String author);
}
