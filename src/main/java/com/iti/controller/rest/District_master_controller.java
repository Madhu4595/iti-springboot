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

import com.iti.entity.master.District_master;
import com.iti.service.District_master_service;

@RestController
@RequestMapping("/rest/dist_master")
public class District_master_controller {
	
	@Autowired private District_master_service service;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveDist(@RequestBody District_master district_master){
		ResponseEntity<String> responseEntity = null;

		try {
			Integer id = service.saveDistrict(district_master);
			responseEntity = new ResponseEntity<String>("dist_master is saved with statecode "+id, HttpStatus.OK);
		}catch(Exception e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return responseEntity;
	}
	@PutMapping("/update")
	public ResponseEntity<String> updateDist(@RequestBody District_master district_master){
		ResponseEntity<String> responseEntity = null;
		boolean isExists = service.isExists(district_master.getDist_code());
		
		if(isExists) {
			Integer id= service.updateDistrict(district_master);
			responseEntity = new ResponseEntity<String>(id+" distcode is updated successfuly", HttpStatus.OK);
		}else {
			responseEntity = new ResponseEntity<String>("record is not found", HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	@DeleteMapping("/delete/{statecode}")
	public ResponseEntity<String> delete(@PathVariable Integer statecode){
		ResponseEntity<String> responseEntity = null;
		
		boolean found= service.isExists(statecode);
		if(found) {
			service.deleteDistrict(statecode);
			responseEntity = new ResponseEntity<String>("deleted successfully",HttpStatus.OK);
		}else {
			responseEntity = new ResponseEntity<String>("record is not found", HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	@DeleteMapping("/delete/all")
	public ResponseEntity<String> deleteAll(){
		ResponseEntity<String> responseEntity = null;
		List<District_master> list= service.getAllDistricts();
		
		if(list == null || list.isEmpty()) {
			responseEntity = new ResponseEntity<String>("no records found", HttpStatus.NOT_FOUND);
		}else {
			service.deleteAllDistricts();
			responseEntity = new ResponseEntity<String>("records are deleted successfully", HttpStatus.OK);
		}
		return responseEntity;
	}
	@GetMapping("/get/{caste_code}")
	public ResponseEntity<District_master> getCaste(@PathVariable Integer statecode){
		ResponseEntity<District_master> responseEntity = null;
		boolean isExist = service.isExists(statecode);
		
		if(isExist) {
			Optional<District_master> dist_master= service.getOneDistrict(statecode);
			District_master dist_master2= dist_master.get();
			
			responseEntity = new ResponseEntity<District_master>(dist_master2,HttpStatus.OK);
		}else {
			responseEntity = new ResponseEntity<District_master>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	@DeleteMapping("/get/all")
	public ResponseEntity<?> deleteAllCastes(){
		ResponseEntity<?> responseEntity = null;
		List<District_master> listdistricts = service.getAllDistricts();
		
		if(listdistricts == null || listdistricts.isEmpty() ) {
			responseEntity = new ResponseEntity<String>("records are not available", HttpStatus.NOT_FOUND);
		}else {
			responseEntity = new ResponseEntity<List<District_master>>(listdistricts, HttpStatus.OK);
		}
		return responseEntity;
	}

}
