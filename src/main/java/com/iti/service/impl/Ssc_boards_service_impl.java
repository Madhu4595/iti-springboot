package com.iti.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iti.entity.master.Ssc_boards;
import com.iti.repo.Ssc_boards_repo;
import com.iti.service.Ssc_boards_service;

@Service
public class Ssc_boards_service_impl implements Ssc_boards_service {

	@Autowired
	private Ssc_boards_repo repo;

	@Override
	@Transactional
	public Integer saveBoard(Ssc_boards boards) {
		return repo.save(boards).getBoard_code();
	}

	@Override
	@Transactional
	public void updateBoard(Ssc_boards boards) {
		repo.save(boards);
	}

	@Override
	@Transactional
	public void deleteBoard(Integer board_code) {
		repo.deleteById(board_code);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Ssc_boards> getOneBoard(Integer board_code) {
		return repo.findById(board_code);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Ssc_boards> getAllBoards() {
		return repo.findAll();
	}

	@Override
	@Transactional
	public boolean isPresent(Integer board_code) {
		return repo.existsById(board_code);
	}

	@Override
	@Transactional
	public void deleteAllBoards() {
		repo.deleteAll();
	}
}
