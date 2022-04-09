package com.iti.entity.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="caste_master")
public class Caste_master {
	@Id
	@Column(name="caste_code")
	@NotNull
	private String caste_code;
	@Column(name="caste_name")
	private String caste_name;
	
	public Caste_master() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Caste_master(String caste_code, String caste_name) {
		super();
		this.caste_code = caste_code;
		this.caste_name = caste_name;
	}
	public String getCaste_code() {
		return caste_code;
	}
	public void setCaste_code(String caste_code) {
		this.caste_code = caste_code;
	}
	public String getCaste_name() {
		return caste_name;
	}
	public void setCaste_name(String caste_name) {
		this.caste_name = caste_name;
	}
	@Override
	public String toString() {
		return "Caste_master [caste_code=" + caste_code + ", caste_name=" + caste_name + "]";
	}
	
	
	

}
