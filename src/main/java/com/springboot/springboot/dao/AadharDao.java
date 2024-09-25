package com.springboot.springboot.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.springboot.entity.Aadhar;
import com.springboot.springboot.repo.AadharRepo;

@Repository
public class AadharDao {
	
	
	  @Autowired
	  AadharRepo repo;
	  
	  public Aadhar saveAadhar(Aadhar aadhar) {
		  
		  
		  return repo.save(aadhar);
	  }
	  
	  public Aadhar findAadharById(int id) {
		  
		 Optional<Aadhar> optionalAadhar= repo.findById(id);
		 if(optionalAadhar.isPresent()) {
			 
			 return optionalAadhar.get();
		 }
		 
		 return null;
		 
	  }
	  
	  public Aadhar deleteById(int id) {
		  
		  Aadhar aadhar=findAadharById(id);
		  
		  if(aadhar!=null) {
			  repo.delete(aadhar);
			  return aadhar;
			  
		  }
		  return null;
	  }
	  
	  public Aadhar updateAadhar(Aadhar aadhar,int id) {
		  Aadhar adhar=findAadharById(id);
		  if(adhar!=null) {
			  aadhar.setId(id);
			  repo.save(aadhar);
			  return aadhar;
		  }
		  return null;
		  
		 
	  }
	  
	  public List<Aadhar> findAll(){
		  
		 return repo.findAll();
	  }
	  
	  
	  
	  
	

}
