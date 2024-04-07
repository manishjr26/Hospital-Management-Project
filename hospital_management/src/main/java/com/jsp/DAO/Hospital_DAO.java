package com.jsp.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.DTO.Hospital;

public class Hospital_DAO 
{
	
		EntityManagerFactory f=Persistence.createEntityManagerFactory("Your");
		EntityManager em=f.createEntityManager();
		EntityTransaction t=em.getTransaction();
		java.util.Scanner mr=new java.util.Scanner(System.in);
		
	public  void addObject()
	{t.begin();
		Hospital hs=new Hospital();
		
		System.out.println("Enter Hospital Name ");
		String name=mr.nextLine();
		//Query q=em.createQuery("");
		System.out.println("Enter Hospital Address ");
		String address=mr.nextLine();
		System.out.println("Enter Hospital City ");
		String city=mr.nextLine();
		hs.setHname(name);
		hs.setHaddress(address);
		hs.setHcity(city);
		em.persist(hs);
		System.out.println(name+" Created Hospital ");
		t.commit();
		
	}
	
	public void updateHospital(int id)
	{t.begin();
		Hospital hs=em.find(Hospital.class, id);
		if(hs!=null)
		{
			
			System.out.println("Enter Hospital Name ");
			String name=mr.nextLine();
			System.out.println("Enter Hospital Address ");
			String address=mr.nextLine();
			System.out.println("Enter Hospital City ");
			String city=mr.nextLine();
			hs.setHname(name);
			hs.setHaddress(address);
			hs.setHcity(city);
			//em.merge(hs);
			System.out.println(id+" Updated Successfully . ");
			t.commit();
		}else
		{
			System.err.println("Invalid Hospital Details");
			
		}
		
		
	}
	public void removeHospital(int id)
	{t.begin();
		Hospital hs=em.find(Hospital.class, id);
		if(hs!=null)
		{
			
			em.remove(hs);
			t.commit();
			System.out.println(id+" Deleted Successgfully.");
		}else
		{
			System.err.println("Invalid Hospital Details");
			
		}
		
	}

	public void displayHospitalDetailsBasedName(String name) {
	    String lower = name.trim().toLowerCase();
	    try {
	        Query q = em.createQuery("select h from Hospital h where lower(h.hname)=lower(?1)");
	        q.setParameter(1, lower);
	        List<Hospital> ho = q.getResultList();
	        if (!ho.isEmpty()) { 
	            for (Hospital hs : ho) {
	                System.out.println(hs.getHospital_id() + " " + hs.getHname() + " " + hs.getHaddress() + " " + hs.getHcity());
	            }
	        } else {
	            System.err.println("Invalid Hospital Name");
	        }
	    } catch (Exception e) {
	        System.err.println("Error retrieving hospital details from the database");
	    }
	}

	public void displayAllHospitalDetails()
	{
		Query q=em.createQuery("select h from Hospital h");
		List<Hospital> ho=q.getResultList();
		if(ho!=null)
		{
			for(Hospital hs:ho)
			{
				System.out.println(hs.getHospital_id()+ " "+hs.getHname()+" "+hs.getHaddress()+" "+hs.getHcity());
			}
		}else
			System.err.println("Invalid Hospital Details");
	}
	public void closeScanner()
	{
		mr.close();
		f.close();
		em.clear();
		
	}

}
