package com.jsp.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.DTO.Medical_Records;
import com.jsp.DTO.Patient;

public class Medical_DAO 
{
	EntityManagerFactory f=Persistence.createEntityManagerFactory("Your");
	EntityManager em=f.createEntityManager();
	EntityTransaction t=em.getTransaction();
	java.util.Scanner mr=new java.util.Scanner(System.in);
	
	public void addMedicalRecords(int patientId)
	{t.begin();
		Patient p=em.find(Patient.class, patientId);
		if(p!=null)
		{
			Query q=em.createQuery("select p.patientName from Patient p");
			List<Patient> pa=q.getResultList();
			Medical_Records m=new Medical_Records();
			System.out.println("Enter Date of Examination : ");
			String date=mr.nextLine();
			System.out.println(" Enter Problem :");
			String problem=mr.nextLine();
			m.setDate_of_examination(date);
			m.setProblem(problem);
			m.setP(p);
			em.persist(m);
			t.commit();
			System.out.println(" Medical Records of Patient "+pa+" inserted successfully .");
			
		}else
			System.err.println("Invalid Patient Details");
		
	}
	public void updateDate_of_Examination(int patientId) {
	    t.begin();
	    Patient p = em.find(Patient.class, patientId);
	    if (p != null) {
	        Query q = em.createQuery("select m from Medical_Records m where m.patient.Pat_id = ?1");
	        q.setParameter(1, patientId);
	        List<Medical_Records> medicalRecords = q.getResultList();
	        
	        if (!medicalRecords.isEmpty()) 
	        {
	            System.out.println("Enter Date of Examination : ");
	            String date = mr.nextLine();
	            
	           
	            Medical_Records record = medicalRecords.get(0);
	            record.setDate_of_examination(date);
	            
	            System.out.println("Date of Examination of Patient " + p.getPatientName() + " updated successfully.");
	            t.commit();
	        } else 
	        {
	            System.err.println("No medical records found for patient with ID " + patientId);
	        }
	    } else {
	        System.err.println("Invalid Patient Details");
	    }
	}

	public void removeMedicalRecords(int patientId)
	{
        t.begin();
        Patient p = em.find(Patient.class, patientId);
        if (p != null) {
            Query q = em.createQuery("select m from Medical_Records m where m.patient.Pat_id = ?1");
            q.setParameter(1, patientId);
            List<Medical_Records> m = q.getResultList();
            for (Medical_Records record : m) {
                em.remove(record);
            }
            t.commit();
            System.out.println("Medical Records of Patient " + p.getPatientName() + " removed successfully.");
        } else {
            System.err.println("Invalid Patient Details");
        }
    }
	public void displayMedicalRecordsOfParticularPatient(int patientId)
	{
	    t.begin();
	    Patient p = em.find(Patient.class, patientId);
	    if (p != null)
	    {
	        Query q = em.createQuery("select m from Medical_Records m where m.patient.Pat_id = ?1");
	        q.setParameter(1, patientId);
	        List<Medical_Records> medicalRecords = q.getResultList();
	        System.out.println("\nMedical Record Id \t Date of Examination \t  Problem \t Patient Id");
	        for (Medical_Records mer : medicalRecords) 
	        {
	            System.out.println(" \t"+mer.getRecord_id() + " \t\t" + mer.getDate_of_examination() + " \t\t\t" + mer.getProblem() + " \t\t" + mer.getP().getPat_id());
	        }
	        t.commit();
	    } else
	    {
	        System.err.println("Invalid Patient Details");
	    }
	}


	public void closeScanner()
	{
		mr.close();
		em.clear();
		f.close();
	}	
}
