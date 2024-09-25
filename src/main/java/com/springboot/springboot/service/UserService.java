package com.springboot.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.springboot.dao.AadharDao;

import com.springboot.springboot.dao.UserDao;

import com.springboot.springboot.entity.Aadhar;
import com.springboot.springboot.entity.User;
import com.springboot.springboot.exception.AadharNotFoundException;
import com.springboot.springboot.exception.UserNotFoundException;
import com.springboot.springboot.exception.UserSaveFailedException;
import com.springboot.springboot.util.ResponseStructure;

@Service
public class UserService {
     
	@Autowired
	UserDao udao;
	
	@Autowired
	AadharDao adao;
	
	public ResponseEntity<ResponseStructure<User>> saveadhar(User u) {
		User savedUser=udao.saveUser(u);
		if(savedUser!=null) {
			ResponseStructure<User> structure=new ResponseStructure<User>();
			structure.setData(savedUser);
			structure.setMessage("Aadhar saved");
			structure.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.CREATED);
		}
		throw new UserSaveFailedException("User is not saved successfully");
	}
	
	public  ResponseEntity<ResponseStructure<User>> findUserById(int id) {
		User findUserById=udao.findById(id);
		if(findUserById!=null) {
			ResponseStructure<User> structure=new ResponseStructure<User>();
			structure.setData(findUserById);
			structure.setMessage(" User found based on id");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);
		}
		throw new UserNotFoundException("user not found with given id");
	}
	
	public ResponseEntity<ResponseStructure<User>> deleteById(int id) {
		User deleteById=udao.deleteById(id);
		if(deleteById!=null) {
			ResponseStructure<User> structure=new ResponseStructure<User>();
			structure.setData(deleteById);
			structure.setMessage("Delete User based on id");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
		}
		throw new UserNotFoundException("user not found with given id");
	}
	
	public ResponseEntity<ResponseStructure<User>> assignAadharToUser(int aid,int uid){
		Aadhar aadhar=adao.findAadharById(aid);
		User user=udao.findById(uid);
		if(aadhar!=null) {
			if(user!=null) {
				user.setAadhar(aadhar);
				User updatedUser=udao.updateUser(user, uid);
				ResponseStructure<User> structure=new ResponseStructure<User>();
				structure.setData(updatedUser);
				structure.setMessage("Aadhar assigned to User");
				structure.setStatus(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
			}
			throw new AadharNotFoundException("aadhar not found");
		}
		return null;
	}
	
	public  ResponseEntity<ResponseStructure<List<User>>> findAllUser(){
		List<User> findall=udao.findAll();
		ResponseStructure<List<User>> structure=new ResponseStructure<List<User>>();;
		structure.setData(findall);
		structure.setMessage("data found for all Users");
		structure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<List<User>>>(structure,HttpStatus.FOUND);
	}
	
	public  ResponseEntity<ResponseStructure<List<User>>> fetchAllUserWithNoAadhar(){
		List<User> findall=udao.findAll().stream().filter(user->user.getAadhar()==null).toList();
		ResponseStructure<List<User>> structure=new ResponseStructure<List<User>>();;
		structure.setData(findall);
		structure.setMessage("data found for all Users with no adhar");
		structure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<List<User>>>(structure,HttpStatus.FOUND);
		
	}
}
