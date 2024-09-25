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

import com.springboot.springboot.entity.Aadhar;

import com.springboot.springboot.service.AadharService;
import com.springboot.springboot.util.ResponseStructure;

@RestController
@RequestMapping("aadhar")
public class AadharController {
	
	@Autowired
	AadharService service;
	
    @PostMapping	
    public ResponseEntity<ResponseStructure<Aadhar>> saveAdhar(@RequestBody Aadhar aadhar)	{
	 return  service.saveAadhar(aadhar);
    }

     @GetMapping
     public ResponseEntity<ResponseStructure<Aadhar>> find(@RequestParam int id) {
	
	return service.findAadharById(id);
    }
     @DeleteMapping
    public ResponseEntity<ResponseStructure<Aadhar>>  delete(@RequestParam int id) {
	
	return service.deleteById(id);
    }
    @PutMapping
    public ResponseEntity<ResponseStructure<Aadhar>> update(@RequestBody Aadhar aadhar,@RequestParam int id) {
	
	
	return service.updateAadhar(aadhar, id);
       }

       @GetMapping("all")
       public  ResponseEntity<ResponseStructure<List<Aadhar>>> findAll(){
	return service.findAllAadhar();
       }
	
	
	
	
	

}
