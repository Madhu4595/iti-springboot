package com.iti.service;

import java.util.List;
import java.util.Optional;

import com.iti.entity.master.District_master;

public interface District_master_service {
	public Integer saveDistrict(District_master district_master);
	public Integer updateDistrict(District_master district_master);
	public void deleteDistrict(Integer statecode);
	public void deleteAllDistricts();
	public Optional<District_master> getOneDistrict(Integer statecode);
	public List<District_master> getAllDistricts();
	public boolean isExists(Integer statecode);
	
}
