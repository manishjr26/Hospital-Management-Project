package com.jsp.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.DTO.Hospital;
import com.jsp.DTO.Patient;

public class Patient_DAO 
{
	EntityManagerFactory f=Persistence.createEntityManagerFactory("Your");
	EntityManager em=f.createEntityManager();
	EntityTransaction t=em.getTransaction();
	java.util.Scanner mr=new java.util.Scanner(System.in);
	
	public void createPatient(int hospitalId)
	{
		t.begin();
	
	Hospital hs=em.find(Hospital.class, hospitalId);
		
		if(hs!=null)
		{
			Patient p=new Patient();
			System.out.println("Enter Patient Name");
			String name=mr.nextLine();
			System.out.println("Enter Patient Diagnosis");
			String diagonsis=mr.nextLine();
			System.out.println("Enter Patient Address");
			String address=mr.nextLine();
			
			p.setPatientName(name);
			p.setPatientDiagnosis(diagonsis);
			p.setPatientAddress(address);
			p.setHos(hs);
			em.persist(p);
			System.out.println("Patient "+name+" inserted into Hospital : "+hospitalId+" successfully.");
			t.commit();
		}else
			System.err.println("Invalid Hospital Details");
	}
	public void removePatient(int hospitalId)
	{
	    t.begin();
	    Hospital hospital = em.find(Hospital.class, hospitalId);
	    if (hospital != null) {
	        System.out.println("Enter Patient Id");
	        int patientId = mr.nextInt();
	        Patient p = em.find(Patient.class, patientId);
	        if (p != null) {
	            em.remove(p);
	            System.out.println("Patient :"+patientId+" removed successfully.");
	            t.commit();
	        } else {
	            System.err.println("Patient is not present.");
	        }
	    } else {
	        System.err.println("Invalid Hospital ID: " + hospitalId);
	    }
	}
	public void displayPatientDetailsByname(String patientName) 
	{
		String lower=patientName.trim().toLowerCase();
	    Query q = em.createQuery("SELECT p FROM Patient p WHERE lower(p.patientName) =?1");
	    q.setParameter(1, lower);
	    List<Patient> patients = q.getResultList();
	    
	    if (!patients.isEmpty())
	    {System.out.println("\nPatient Id \t Patient Name \t Patient Address \t Patient Diagonsis");
	        for (Patient p : patients)
	        {
	            System.out.println(p.getPat_id() + " \t\t" + p.getPatientName() + " \t\t" + p.getPatientAddress() + " \t\t\t" + p.getPatientDiagnosis());
	        }
	    } else 
	    {
	        System.err.println("No patients found with the name: " + patientName);
	    }
	}

	public void displayAllPatientDetails(int hospitalId) {
	    Hospital hospital = em.find(Hospital.class, hospitalId);
	    if (hospital != null) {
	    	Query q1=em.createQuery("select h.hname from Hospital h");
	    	List<Hospital> hname=q1.getResultList();
	        Query q = em.createQuery("SELECT p FROM Patient p");
	        List<Patient> patients = q.getResultList();
	        if (!patients.isEmpty()) 
	        {System.out.println("\n\t\tPatients Admitted in "+hname+" hospital are .");
	        	System.out.println("\nPatient Id \t Patient Name \t Patient Address \t Patient Diagonsis");
	            for (Patient p : patients) 
	            {
	            	System.out.println(p.getPat_id() + " \t\t" + p.getPatientName() + " \t\t" + p.getPatientAddress() + " \t\t\t" + p.getPatientDiagnosis());
	            }
	        } else 
	        {
	            System.err.println("No patients found in the hospital with ID: " + hospitalId);
	        }
	    } else 
	    {
	    	System.err.println("No patients found in the hospital with ID: " + hospitalId);
	    }
	}

	public void closeScanner()
	{
		mr.close();
		f.close();
		em.clear();
		
	}

}
