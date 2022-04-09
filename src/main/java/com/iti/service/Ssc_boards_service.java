package com.iti.service;

import java.util.List;
import java.util.Optional;

import com.iti.entity.master.Ssc_boards;

public interface Ssc_boards_service {
	public Integer saveBoard(Ssc_boards boards);
	public void updateBoard(Ssc_boards boards);
	public void deleteBoard(Integer board_code);
	public void deleteAllBoards();
	public Optional<Ssc_boards> getOneBoard(Integer board_code);
	public List<Ssc_boards> getAllBoards();
	public boolean isPresent(Integer board_code);
	

}
