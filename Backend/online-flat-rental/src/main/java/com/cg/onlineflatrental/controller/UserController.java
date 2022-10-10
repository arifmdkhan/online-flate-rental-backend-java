package com.cg.onlineflatrental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineflatrental.entity.User;
import com.cg.onlineflatrental.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	private UserService us;
	
	@PostMapping("/user")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		User u=us.addUser(user);
		return new ResponseEntity<String>("user saved",HttpStatus.CREATED);
	}
	

	@GetMapping("/user/{id}")
	public ResponseEntity<User> viewUser(@PathVariable Integer id) {
		User value = us.viewUser(id);
		ResponseEntity<User> retvalue = new ResponseEntity<User>(value, HttpStatus.OK);
		return retvalue;
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> viewAllUser() {
		List<User> list=us.viewAllUser();
		return new ResponseEntity<List<User>>(list,HttpStatus.OK);
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> removeUser(@PathVariable Integer id){
		us.removeUser(id);
		return new ResponseEntity<String>("User : "+id+" sucessfully deleted.",HttpStatus.OK);
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<String> updateUser(@RequestBody User user,@PathVariable Integer id){
		User value = us.updateUser(user,id);
		return new ResponseEntity<String>("User with ID: "+value.getUserId()+" sucessfully updated.",HttpStatus.ACCEPTED);
		
	}
	
	@PatchMapping("/user/{newpass}")
	public ResponseEntity<String> updatePassword(@RequestBody User user,@PathVariable String newpass){
		User usr = us.updatePassword(user, newpass);
		ResponseEntity<String> value = new ResponseEntity<String>("User with ID's password is: "+usr.getUserId()+" sucessfully updated.",HttpStatus.ACCEPTED);
		return value;
	}
	
	@PatchMapping("/user/{username}/{password}")
	public ResponseEntity<String> validateUser(@PathVariable String username, @PathVariable String password) {
		User u=us.validateUser(username,password);
		return new ResponseEntity<String>("user Validated",HttpStatus.OK);
	}
	
//	@GetMapping("/validate/usernameandpassword")
//	public ResponseEntity<List<User>> getUsersByUsernameAndPassword(@RequestParam String username, @RequestParam String password){
//		return new ResponseEntity<>(ur.find)
//	}

}
