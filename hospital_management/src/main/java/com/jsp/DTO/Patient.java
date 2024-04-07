package com.jsp.DTO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Patient 
{
	private String patientAddress;
	private String patientDiagnosis;
	private String patientName;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Pat_id;
	
	@ManyToOne
	@JoinColumn(name = "hospital_id")
	Hospital hos;

	@OneToMany(mappedBy = "patient")
	List<Medical_Records> mr;
	
	public List<Medical_Records> getMr() {
		return mr;
	}

	public void setMr(List<Medical_Records> mr) {
		this.mr = mr;
	}

	public String getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}

	public String getPatientDiagnosis() {
		return patientDiagnosis;
	}

	public void setPatientDiagnosis(String patientDiagnosis) {
		this.patientDiagnosis = patientDiagnosis;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getPat_id() {
		return Pat_id;
	}

	public void setPat_id(int pat_id) {
		Pat_id = pat_id;
	}

	public Hospital getHos() {
		return hos;
	}

	public void setHos(Hospital hos) {
		this.hos = hos;
	}
	

}
