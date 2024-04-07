package com.jsp.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Doctor 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int doctor_id;
	private String d_name;
	private String qualification;
	private double salary;
	
	@ManyToOne
	@JoinColumn(name = "hospital_id")
	Hospital h;

	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	public String getD_name() {
		return d_name;
	}

	public void setD_name(String d_name) {
		this.d_name = d_name;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Hospital getH() {
		return h;
	}

	public void setH(Hospital h) {
		this.h = h;
	}
	
	
	
	
	
}
