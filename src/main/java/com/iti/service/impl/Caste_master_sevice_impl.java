package com.iti.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iti.entity.master.Caste_master;
import com.iti.repo.Caste_master_repo;
import com.iti.service.Caste_master_service;
@Service
public class Caste_master_sevice_impl implements Caste_master_service{
	@Autowired
	private Caste_master_repo repository;

	@Override
	@Transactional
	public String saveCaste(Caste_master caste_master) {
		return repository.save(caste_master).getCaste_code();
	}

	@Override
	@Transactional
	public void updateCaste(Caste_master caste_master) {
		repository.save(caste_master);
	}

	@Override
	@Transactional
	public void deleteCaste(String caste_code) {
		repository.deleteById(caste_code);
	}

	@Override
	@Transactional
	public void deleeteAllCastes() {
		repository.deleteAll();
	}

	@Override
	@Transactional
	public Optional<Caste_master> getCaste(String caste_code) {
		return repository.findById(caste_code);
	}

	@Override
	@Transactional
	public List<Caste_master> getAllCaste() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public boolean isPresent(String caste_code) {
		return repository.existsById(caste_code);
	}

}
