package com.iti.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iti.projections.ITIApiDashBoardReportProj;
import com.iti.repo.Caste_master_repo;

@RestController
public class ReportsController {
	
	@Autowired Caste_master_repo caste_master_repo;

	@GetMapping("/getITIApiDashboard")
	public ResponseEntity<?> getITIApiDashboard(@RequestParam String admissionYear,@RequestParam String itiCode){
		List<ITIApiDashBoardReportProj> getITIApiDashboard = caste_master_repo.getITIApiDashboard(admissionYear,itiCode);
		return new ResponseEntity<List<ITIApiDashBoardReportProj>>(getITIApiDashboard, HttpStatus.OK);
	}
}
