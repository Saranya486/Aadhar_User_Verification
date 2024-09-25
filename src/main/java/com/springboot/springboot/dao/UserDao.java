package com.springboot.springboot.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.springboot.entity.User;
import com.springboot.springboot.repo.UserRepo;

@Repository
public class UserDao {

	
	   @Autowired
	   UserRepo repo;
	   
	   
	   public User saveUser(User user) {
		   
		   
		   return repo.save(user);
	   }
	   
	   
	   public User findById(int uid) {
		   
		   Optional<User> optionaluser=repo.findById(uid);
		   
		   if(optionaluser.isPresent()) {
			   
			   return optionaluser.get();
		   }
		   return null;
		   
	   }
	   
	   public User deleteById(int uid) {
		   
		   
		   User user=findById(uid);
		   if(user!=null) {
			   
			   repo.delete(user);
			   return user;
		   }
		   return null;
	   }
	   
	   public User updateUser(User user,int uid) {
		   
		   User updateduser=findById(uid);
		   if(updateduser!=null){
			   
			   user.setUid(uid);
			   return repo.save(user);
			  
			   
		   }
		   return null;
		   
	   }
	   public List<User> findAll(){
		   
		   return repo.findAll();
	   }
	   
	   
}
