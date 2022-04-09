package com.iti.entity.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ssc_examboard_mst")
public class Ssc_boards {

	@Id
	@Column(name="board_code")
	private Integer board_code;
	@Column(name="board_name")
	private String board_name;
	@Column(name="trno")
	private Long trno;
	@Column(name="display_order")
	private Integer display_order;
	public Ssc_boards(Integer board_code, String board_name, Long trno, Integer display_order) {
		super();
		this.board_code = board_code;
		this.board_name = board_name;
		this.trno = trno;
		this.display_order = display_order;
	}
	public Ssc_boards() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getBoard_code() {
		return board_code;
	}
	public void setBoard_code(Integer board_code) {
		this.board_code = board_code;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public Long getTrno() {
		return trno;
	}
	public void setTrno(Long trno) {
		this.trno = trno;
	}
	public Integer getDisplay_order() {
		return display_order;
	}
	public void setDisplay_order(Integer display_order) {
		this.display_order = display_order;
	}
	@Override
	public String toString() {
		return "Ssc_boards [board_code=" + board_code + ", board_name=" + board_name + ", trno=" + trno
				+ ", display_order=" + display_order + "]";
	}
	
	
	
	
	 	
}
