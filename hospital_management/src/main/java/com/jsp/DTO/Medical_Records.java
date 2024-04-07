package com.jsp.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Medical_Records 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int record_id;
	private String date_of_examination;
	private String problem;
	
	@ManyToOne
	@JoinColumn(name = "Pat_id")
	Patient patient;

	public int getRecord_id() {
		return record_id;
	}

	public void setRecord_id(int record_id) {
		this.record_id = record_id;
	}
	public String getDate_of_examination() {
		return date_of_examination;
	}

	public void setDate_of_examination(String date_of_examination) {
		this.date_of_examination = date_of_examination;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public Patient getP() {
		return patient;
	}

	public void setP(Patient patient) {
		this.patient = patient;
	}
	

}
