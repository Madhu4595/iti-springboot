package com.iti.entity.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Madhu
 *
 */
@Entity
@Table(name="dist_mst")
public class District_master {

	@Id
	@Column(name="statecode")
	private Integer statecode;
	@Column(name="dist_code")
	private Integer dist_code;
	@Column(name="dist_name")
	private String dist_name;
	@Column(name="itidist_code")
	private Integer itidist_code;
	
	
	public District_master() {
		super();
		// TODO Auto-generated constructor stub
	}


	public District_master(Integer statecode, Integer dist_code, String dist_name, Integer itidist_code) {
		super();
		this.statecode = statecode;
		this.dist_code = dist_code;
		this.dist_name = dist_name;
		this.itidist_code = itidist_code;
	}


	public Integer getStatecode() {
		return statecode;
	}


	public void setStatecode(Integer statecode) {
		this.statecode = statecode;
	}


	public Integer getDist_code() {
		return dist_code;
	}


	public void setDist_code(Integer dist_code) {
		this.dist_code = dist_code;
	}


	public String getDist_name() {
		return dist_name;
	}


	public void setDist_name(String dist_name) {
		this.dist_name = dist_name;
	}


	public Integer getItidist_code() {
		return itidist_code;
	}


	public void setItidist_code(Integer itidist_code) {
		this.itidist_code = itidist_code;
	}


	@Override
	public String toString() {
		return "District_master [statecode=" + statecode + ", dist_code=" + dist_code + ", dist_name=" + dist_name
				+ ", itidist_code=" + itidist_code + "]";
	}
	
	
	
}
