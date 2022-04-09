package com.iti.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iti.entity.master.District_master;
import com.iti.repo.District_master_repo;
import com.iti.service.District_master_service;

@Service
public class District_master_service_impl implements District_master_service{

	@Autowired private District_master_repo repo;
	
	@Override
	public Integer saveDistrict(District_master district_master) {
		return repo.save(district_master).getStatecode();
	}

	@Override
	public Integer updateDistrict(District_master district_master) {
		return repo.save(district_master).getDist_code();
	}

	@Override
	public void deleteDistrict(Integer statecode) {
		repo.deleteById(statecode);
	}

	@Override
	public void deleteAllDistricts() {
		repo.deleteAll();
	}

	@Override
	public Optional<District_master> getOneDistrict(Integer statecode) {
		return repo.findById(statecode);
	}

	@Override
	public List<District_master> getAllDistricts() {
		return repo.findAll();
	}

	@Override
	public boolean isExists(Integer statecode) {
		return repo.existsById(statecode);
	}

}
