package com.mobilelogin.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mobilelogin.data.Book;
import com.mobilelogin.data.User;

@Controller
public class Library_controller 
{

	@Autowired
	LibraryService libraryService;

	@RequestMapping("/")
	public String home() 
	{
		return "home.jsp";
	}

	@PostMapping("/login")
	public Object String(@RequestParam String email, String password)
	{
		User user = libraryService.findById(email, password);
		System.out.println("hello user" + user);
		if (user != null) 
		{
			String a = user.getUserType();
			System.out.println(a);

			if (a.equals("Admin"))
			{
				System.out.println("hi admin");
				return "adminlogin.jsp";
			} else if (a.equals("normal"))
			{
				System.out.println("hi user");
				return "userlogin.jsp";
			} else if (a != "normal" && a != "Admin") 
			{
				System.out.println("retry");
				return "home.jsp";
			}
		} else
			return "home.jsp";
		return user;
	}

	@PostMapping("/delete")
	public ModelAndView Delete_Entry(@RequestParam int bookId) 
	{
		ModelAndView mv = new ModelAndView("adminlogin.jsp");
		libraryService.delete(bookId);
		return mv;
	}

	@RequestMapping("/update")
	public ModelAndView Update_Entry(@RequestParam int bookId, String title, String category, String subject,
			String description, String author) 
	{   
		ModelAndView mv1 = new ModelAndView("adminlogin.jsp");
		Book book=libraryService.saveup(bookId,title,category,subject,description,author);
		System.out.println(book);
		return mv1;
	}

	@PostMapping("/add")
	public ModelAndView Add_Entry(@RequestParam  String title, String category, String subject,
			String description, String author, int stock)
	{
		System.out.println("what is this?");
		ModelAndView mv2 = new ModelAndView("adminlogin.jsp");
//		Book book = new Book(title, category, subject, description, author, stock);
//		System.out.println(book);
		Book book=libraryService.saveadd(title, category, subject, description, author, stock);
		System.out.println(book);
		return mv2;
	}

	@PostMapping("/signout")
	public String Logout(HttpServletRequest req)
	{   
//	    libraryService.logout();
		req.getSession().invalidate();
		return "home.jsp";
	}
	@PostMapping("/changestock")
	public String stockchange(@RequestParam int bookId,int stock)
	{
		libraryService.savestock(bookId,stock);
	    return "adminlogin.jsp";	
	}
//	@PostMapping("/search")
//	public String searchForBooks(@RequestParam String title,String category, String subject, String author)
//	{
//		libraryService.searchbooks(title,category,subject,author);
//		return "books.jsp";
//	}
	@PostMapping("/search")
	public String searchForBooks(@RequestParam String title,String category, String subject,String author,ModelMap model,Model model1)
	{   List<Book> list1= libraryService.searchForBooks(title, category, subject, author);
	    System.out.println(list1);
	    if(list1.isEmpty())
        {
	    	String error="please search with other variable as your search shows no result";
	    	model1.addAttribute("error", error);
	    	return "userlogin.jsp";
        }
	    else
	    {
	    	model.put("list", list1);
		    return "books.jsp";
	    }
    }
	@PostMapping("/adminsearch")
	public String searchForAdminBooks(@RequestParam String title,String category, String subject,String author,ModelMap model)
	{   List<Book> list1= libraryService.searchForBooks(title, category, subject, author);
	    System.out.println(list1);
        model.put("adminlist", list1);
		return "editbook.jsp";
	}
	@RequestMapping("/rent")
	public String bookRent(@RequestParam int bookId, int timePeriod,Model model) 
	{
		if (timePeriod <= 62) 
		{   Book book=new Book();
			book=libraryService.rentBook(bookId);
			if (book == null)
			{   String error="Sorry this book is not available please search again";
		        model.addAttribute("error", error);
				return "userlogin.jsp";
			}
			else
			{
				model.addAttribute("timePeriod", timePeriod);
				model.addAttribute(book);
				return "dashboard.jsp";
			}
		}
		else 
		{   String error="enter the right amount of time to rent and search again ";
		    model.addAttribute("error", error);
			return "userlogin.jsp";
		}
	}
}