package com.cg.onlineflatrental.repository;

import java.util.List; 
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cg.onlineflatrental.entity.User;


@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {

	
	List<User> findByUserName(String username);
	List<User> findByPassword(String password);
//	
//	List<User> findByUsernNameAndPassword(String userName,String Password);
	
	

}
