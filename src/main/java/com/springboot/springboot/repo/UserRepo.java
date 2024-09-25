package com.springboot.springboot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.springboot.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	@Query(value = "SELECT u FROM User u JOIN u.aadhar a WHERE a.number= ?1")
	public User findUserByAadNumber(long anumber);
	
	@Query(value = "SELECT u FROM User u WHERE u.gender=?1")
	public List<User> findByGender(String gender);
	

}
