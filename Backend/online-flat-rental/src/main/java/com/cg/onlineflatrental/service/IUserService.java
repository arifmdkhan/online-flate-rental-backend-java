package com.cg.onlineflatrental.service;

import java.util.List; 
import java.util.Optional;

import com.cg.onlineflatrental.entity.User;
import com.cg.onlineflatrental.exception.UserNotFoundException;


public interface IUserService {
	
	User addUser(User user);
	
	User viewUser(int id) throws UserNotFoundException;
	
	List<User> viewAllUser();
	
	User validateUser(String username, String password);
	
	void removeUser(int id) throws UserNotFoundException;
	
	User updateUser(User user, int id) throws UserNotFoundException;
	
	User updatePassword(User user,String newpass) throws UserNotFoundException;
}

