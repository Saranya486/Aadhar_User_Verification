package com.springboot.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.springboot.dao.AadharDao;
import com.springboot.springboot.entity.Aadhar;
import com.springboot.springboot.exception.AadharNotFoundException;
import com.springboot.springboot.exception.AadharSaveFailedException;
import com.springboot.springboot.util.ResponseStructure;

@Service
public class AadharService {
	
	
    @Autowired
	AadharDao dao;
   
   public ResponseEntity<ResponseStructure<Aadhar>> saveAadhar(Aadhar aadhar){
	  Aadhar savedAadhar    = dao.saveAadhar(aadhar);
	  if(savedAadhar!=null) {
		  ResponseStructure<Aadhar> structure=new ResponseStructure<Aadhar>();
			structure.setData(savedAadhar);
			structure.setMessage("Aadhar saved");
			structure.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Aadhar>>(structure,HttpStatus.CREATED);
		}
		throw new AadharSaveFailedException("aadhar not saved ");
	}
	 
   public  ResponseEntity<ResponseStructure<Aadhar>> findAadharById(int id) {
		Aadhar aadharById=dao.findAadharById(id);
		if(aadharById!=null) {
			ResponseStructure<Aadhar> structure=new ResponseStructure<Aadhar>();
			structure.setData(aadharById);
			structure.setMessage("Aadhar founded based on id");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Aadhar>>(structure,HttpStatus.FOUND);
		}
		throw new AadharNotFoundException("aadhar not found with given id");
	}	  
		  
   public ResponseEntity<ResponseStructure<Aadhar>> deleteById(int id) {
		Aadhar deletebyid=dao.deleteById(id);
		if(deletebyid!=null) {
			ResponseStructure<Aadhar> structure=new ResponseStructure<Aadhar>();
			structure.setData(deletebyid);
			structure.setMessage(" Aadhar deleted based on id");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Aadhar>>(structure,HttpStatus.OK);
		}
		throw new AadharNotFoundException("aadhar not found with given id");
	}
	
   public ResponseEntity<ResponseStructure<Aadhar>> updateAadhar(Aadhar a,int id) {
		Aadhar updatedAadhar=dao.updateAadhar(a, id);
		if(updatedAadhar!=null) {
			ResponseStructure<Aadhar> structure=new ResponseStructure<Aadhar>();
			structure.setData(updatedAadhar);
			structure.setMessage(" Aadhar updated based on id");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Aadhar>>(structure,HttpStatus.OK);
		}
		throw new AadharNotFoundException("aadhar not found with given id");
	}
	  
	   
   public  ResponseEntity<ResponseStructure<List<Aadhar>>> findAllAadhar(){
		List<Aadhar> findall=dao.findAll();
		ResponseStructure<List<Aadhar>> structure=new ResponseStructure<List<Aadhar>>();;
		structure.setData(findall);
		structure.setMessage("data found for all Aadhar");
		structure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<List<Aadhar>>>(structure,HttpStatus.FOUND);
	}
	
	
	
	

}
