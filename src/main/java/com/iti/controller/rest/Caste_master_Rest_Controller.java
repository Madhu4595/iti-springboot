package com.iti.controller.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iti.entity.master.Caste_master;
import com.iti.service.Caste_master_service;

@RestController
@RequestMapping("/rest/caste_master")
public class Caste_master_Rest_Controller {
	
	@Autowired private Caste_master_service service;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveCaste(@RequestBody Caste_master caste_master){
		ResponseEntity<String> responseEntity = null;
		try {
			String caste_code = service.saveCaste(caste_master);
			responseEntity = new ResponseEntity<String>("Caste is inserted with caste code is "+caste_code, HttpStatus.OK);
		}catch(Exception e){
			responseEntity = new ResponseEntity<String>("record is not inserted", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return responseEntity;
	}
	@PutMapping("/update")
	public ResponseEntity<String> updateCaste(@RequestBody Caste_master caste_master){
		ResponseEntity<String> responseEntity = null;
		boolean isExist = service.isPresent(caste_master.getCaste_code());
		if(isExist) {
			service.saveCaste(caste_master);
			responseEntity = new ResponseEntity<String>("caste is updated",HttpStatus.OK);
		}else {
			responseEntity = new ResponseEntity<String>("",HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCaste(@PathVariable String caste_code){
		ResponseEntity<String> responseEntity = null;
		boolean isExist = service.isPresent(caste_code);
		if(isExist) {
			service.deleteCaste(caste_code);
			responseEntity = new ResponseEntity<String>("deleted caste code is"+caste_code,HttpStatus.OK);
		}else {
			responseEntity = new ResponseEntity<String>("record is not found",HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	@DeleteMapping("/delete/all")
	public ResponseEntity<String> deleteAllCaste(){
		ResponseEntity<String> responseEntity = null;
		List<Caste_master> list= service.getAllCaste();
		boolean empty = list.isEmpty();
		
		if(empty) {
			responseEntity = new ResponseEntity<String>("no recors are available",HttpStatus.NOT_FOUND);
		}else {
			service.deleeteAllCastes();
			responseEntity = new ResponseEntity<String>("records are deleted",HttpStatus.OK);
		}
		return responseEntity;
	}
	@GetMapping("/get/{caste_code}")
	public ResponseEntity<Caste_master> getCaste(@PathVariable String caste_code){
		ResponseEntity<Caste_master> responseEntity = null;
		boolean isExist = service.isPresent(caste_code);
		
		if(isExist) {
			Optional<Caste_master> caste_master= service.getCaste(caste_code);
			Caste_master caste_master2= caste_master.get();
			
			responseEntity = new ResponseEntity<Caste_master>(caste_master2,HttpStatus.OK);
		}else {
			responseEntity = new ResponseEntity<Caste_master>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	@DeleteMapping("/get/all")
	public ResponseEntity<?> deleteAllCastes(){
		ResponseEntity<?> responseEntity = null;
		List<Caste_master> listCastes = service.getAllCaste();
		
		if(listCastes == null || listCastes.isEmpty() ) {
			responseEntity = new ResponseEntity<String>("records are not available", HttpStatus.NOT_FOUND);
		}else {
			responseEntity = new ResponseEntity<List<Caste_master>>(listCastes, HttpStatus.OK);
		}
		return responseEntity;
	}
		
}
