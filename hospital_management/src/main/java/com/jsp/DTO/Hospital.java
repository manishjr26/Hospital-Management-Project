package com.jsp.DTO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hospital 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hospital_id;
	private String hname;
	private String haddress;
	private String hcity;
	
	@OneToMany(mappedBy = "hos")
	List<Patient> pa=new ArrayList<Patient>();
	
	@OneToMany(mappedBy = "h")
	List<Doctor> d=new ArrayList<Doctor>();

	public int getHospital_id() {
		return hospital_id;
	}

	public void setHospital_id(int hospital_id) {
		this.hospital_id = hospital_id;
	}

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	public String getHaddress() {
		return haddress;
	}

	public void setHaddress(String haddress) {
		this.haddress = haddress;
	}

	public String getHcity() {
		return hcity;
	}

	public void setHcity(String hcity) {
		this.hcity = hcity;
	}

	public List<Patient> getPa() {
		return pa;
	}

	public void setPa(List<Patient> pa) {
		this.pa = pa;
	}

	public List<Doctor> getD() {
		return d;
	}

	public void setD(List<Doctor> d) {
		this.d = d;
	}

}
