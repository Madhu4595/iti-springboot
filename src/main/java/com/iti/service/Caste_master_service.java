package com.iti.service;

import java.util.List;
import java.util.Optional;

import com.iti.entity.master.Caste_master;

public interface Caste_master_service {

	public String saveCaste(Caste_master caste_master);
	public void updateCaste(Caste_master caste_master);
	public void deleteCaste(String caste_code);
	public void deleeteAllCastes();
	public Optional<Caste_master> getCaste(String caste_code);
	public List<Caste_master> getAllCaste();
	public boolean isPresent(String caste_code);
}
