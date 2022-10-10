package com.cg.onlineflatrental.service;

import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineflatrental.entity.User;
import com.cg.onlineflatrental.exception.UserNotFoundException;
import com.cg.onlineflatrental.exception.ValidationException;
import com.cg.onlineflatrental.repository.IUserRepository;


@Service
public class UserService implements IUserService{
	
	@Autowired
	private IUserRepository ur;

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		User u = ur.save(user);
		return u;
	}
	
	@Override
	public User viewUser(int id) throws UserNotFoundException{
		Optional<User> o = ur.findById(id);
		if(ur.existsById(id))
			return o.get();
		else
			throw new UserNotFoundException("User Not Found");
		
	}

	@Override
	public List<User> viewAllUser() {
		List<User> l=ur.findAll();
		return l;
	}

	@Override
	public void removeUser(int id) throws UserNotFoundException{
		// TODO Auto-generated method stub
		Optional<User> fb= ur.findById(id);
		if(ur.existsById(id))			
			ur.delete(fb.get());
		else
			throw new UserNotFoundException("User Not Found");
		
	}
	
	@Override
	public User updateUser(User user, int id) throws UserNotFoundException{
		Optional<User> o= ur.findById(id);
		if(ur.existsById(id)) {
			o.get().setUserName(user.getUserName());
			o.get().setPassword(user.getPassword());
			o.get().setUserType(user.getUserType());
		}
		else
			throw new UserNotFoundException("User Not Found");
		return ur.save(o.get());
	}

	@Override
	public User updatePassword(User user, String newPass) throws UserNotFoundException{
		Optional<User> o= ur.findById(user.getUserId());
		if(ur.existsById(user.getUserId()))
		{
			o.get().setPassword(newPass);
		}
		else
			throw new UserNotFoundException("User Not Found");
		
		
	
	return ur.save(o.get());
}

	@Override
	public User validateUser(String username, String password) throws UserNotFoundException{
		List<User> o = ur.findByUserName(username);
		if(o.isEmpty())
			throw new UserNotFoundException("User Not Found");
		else
		{
			System.out.println(password+" "+o.get(0).getPassword());
//			return o.get(0);
			if(o.get(0).getPassword().equals(password))
				return o.get(0);
			else
				throw new ValidationException("Incorrect Password");
		}
			
	}

		
}

