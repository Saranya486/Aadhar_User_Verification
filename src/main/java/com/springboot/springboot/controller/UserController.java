package com.springboot.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springboot.entity.User;
import com.springboot.springboot.repo.AadharRepo;
import com.springboot.springboot.repo.UserRepo;
import com.springboot.springboot.service.UserService;
import com.springboot.springboot.util.ResponseStructure;
@RestController
@RequestMapping("user")
public class UserController {

	   
		@Autowired
		UserService service;
		@Autowired
		UserRepo urepo;
		
		@PostMapping
		public ResponseEntity<ResponseStructure<User>> saveuser(@RequestBody User user) {
			return service.saveadhar(user);
		}
		
		@GetMapping
		public ResponseEntity<ResponseStructure<User>> finduserbyid(@RequestParam int uid) {
			return service.findUserById(uid);
		}
		
		@DeleteMapping
		public ResponseEntity<ResponseStructure<User>> deletebyid(@RequestParam int uid) {
			return service.deleteById(uid);
		}
		
		@PutMapping
		public ResponseEntity<ResponseStructure<User>> updateaadhar(@RequestParam int aid,@RequestParam int uid) {
			return service.assignAadharToUser(aid, uid);
		}
		
		@GetMapping("all")
		public ResponseEntity<ResponseStructure<List<User>>> findalluser(){
			return service.findAllUser();
		}
		@GetMapping("noadhar")
		public ResponseEntity<ResponseStructure<List<User>>> fetchalluserwithnoaadhar(){
			return service.fetchAllUserWithNoAadhar();
		}
		
		@GetMapping("bynumber")
		public User finduserbyanumber(@RequestParam long anumber) {
			return urepo.findUserByAadNumber(anumber);
		}
		
		@GetMapping("bygender")
		public List<User> findbygender(@RequestParam String gender){
			return urepo.findByGender(gender);
		}
	

}