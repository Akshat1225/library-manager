package com.mobilelogin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobilelogin.data.User;

@Repository
public interface User_Repository extends JpaRepository<User,Integer>
{   User findByEmail(String Email);
	User findByEmailAndPassword(String email, String password);
}
