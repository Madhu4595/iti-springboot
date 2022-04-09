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

import com.iti.entity.master.Ssc_boards;
import com.iti.service.Ssc_boards_service;

@RestController
@RequestMapping("/rest/ssc_boards")
public class Ssc_boards_Rest_Controller {
	
	@Autowired
	private Ssc_boards_service service;
	
	//save entity
	@PostMapping("/save")
	public ResponseEntity<String> saveBoards(@RequestBody Ssc_boards boards){
		ResponseEntity<String> responseEntity= null;
		try {
			Integer id = service.saveBoard(boards);
			responseEntity = new ResponseEntity<String>("Board is created with board_code'"+id+"'is created successfully", HttpStatus.OK);
			
		}catch(Exception e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return responseEntity;
	}
	//update entity
	@PutMapping("/update")
	public ResponseEntity<String> updateBoard(@RequestBody Ssc_boards boards){
		ResponseEntity<String> responseEntity = null;
		boolean isExist = service.isPresent(boards.getBoard_code());
		if(isExist) {
			//if board exists
			service.updateBoard(boards);
			responseEntity = new ResponseEntity<String>("Board updated successfully", HttpStatus.OK);
		}else {
			//if board not exists
			responseEntity = new ResponseEntity<String>("Updation failed '"+boards.getBoard_code()+"' is not available", HttpStatus.BAD_REQUEST);
		}
		return responseEntity; 
	}
	//delete entity
	@DeleteMapping("/delete/{board_code}")
	public ResponseEntity<String> deleteBoard(@PathVariable Integer board_code){
		ResponseEntity<String> responseEntity = null;
		boolean isExist = service.isPresent(board_code);
		if(isExist) {
			//if board exists
			service.deleteBoard(board_code);
			responseEntity = new ResponseEntity<String>("Board is deleted with id is '"+board_code+"'", HttpStatus.OK);
		}else {
			//if board not exists
			responseEntity = new ResponseEntity<String>("Board code '"+board_code+"' is not exists", HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	//get one board
	@GetMapping("/get/{board_code}")
	public ResponseEntity<Ssc_boards> getoneboard(@PathVariable("board_code") Integer board_code){
		ResponseEntity<Ssc_boards> responseEntity = null;
		boolean isExist = service.isPresent(board_code);
		if(isExist) {
			Optional<Ssc_boards> board = service.getOneBoard(board_code);
			Ssc_boards ssc_boards= board.get();
			responseEntity = new ResponseEntity<Ssc_boards>(ssc_boards, HttpStatus.OK);
		}else{
			responseEntity = new ResponseEntity<Ssc_boards>(HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	//get all boards
	@GetMapping("/get/all")
	public ResponseEntity<?> getAllBoards(){
		ResponseEntity<?> responseEntity = null;
		List<Ssc_boards> listofBoards = service.getAllBoards();
		
		if(listofBoards == null || listofBoards.isEmpty()) {
			responseEntity = new ResponseEntity<String>("No data found", HttpStatus.OK);
		}else {
			responseEntity = new ResponseEntity<List<Ssc_boards>>(listofBoards, HttpStatus.OK);
		}
		return responseEntity;
	}
	@DeleteMapping("/delete/all")
	public ResponseEntity<String> deleteBoards() {
		ResponseEntity<String> responseEntity = null;
		List<Ssc_boards> listofBoards = service.getAllBoards();
		boolean isExist = listofBoards.isEmpty();
		if(isExist) {
			responseEntity = new ResponseEntity<String>("No records found",HttpStatus.BAD_REQUEST);
		}else {
			service.deleteAllBoards();
			responseEntity = new ResponseEntity<String>("All records are deleted", HttpStatus.OK);
		}
		
	return responseEntity;	
	}

	
}
