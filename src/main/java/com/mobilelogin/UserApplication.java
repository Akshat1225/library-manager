package com.mobilelogin;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserApplication implements CommandLineRunner {

	public static void main(String[] args) {
//		ConfigurableApplicationContext context=
		SpringApplication.run(UserApplication.class, args);
//      User_Repository userrepo=context.getBean(User_Repository.class);
//      Book_Repository bookrepo=context.getBean(Book_Repository.class);
//      com.mobilelogin.data.User user=new com.mobilelogin.data.User();
//      user.setUserId(3);
//      user.setEmail("aditya12@gmail.com");
//      user.setGender("M");
//      user.setName("aditya");
//      user.setUserType("normal");
//      user.setPassword(1234321);
//      
//      com.mobilelogin.data.User user1 =userrepo.save(user);
//      System.out.println(user1);
//		
//		System.out.println(User);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
