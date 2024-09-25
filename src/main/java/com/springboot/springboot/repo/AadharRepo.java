package com.springboot.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.springboot.entity.Aadhar;

public interface AadharRepo  extends JpaRepository<Aadhar, Integer>  {
   
	@Query(value = "SELECT a FROM Aadhar a where a.number=?1")
	public Aadhar findAadharByNumber(long number);
	
}
