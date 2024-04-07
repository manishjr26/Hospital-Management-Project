package com.jsp.Controller;

import java.util.InputMismatchException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.DAO.Hospital_DAO;

public class Hospital_Controller 
{
	public static void main(String[] args) 
	{
		System.out.println("\n\t\t ============== !!! Welcome to Hospital !!! ==================== ") ;
		System.out.println("Choose what operations you want to perform \n\n\t\t\t 1 - Display All Hospital Details \t 2 - Display Particular Hospital  Details \t\n\n\t\t\t\t\t\t 3 - Remove Hospital \t\t\n\n\t\t\t 4 - Update Hospital Name \t 5 - Add Hospital Details  ");
		java.util.Scanner mr=new java.util.Scanner(System.in);
		try
		{
			int hospitalChoice=mr.nextInt();
			mr.nextLine();
			Hospital_DAO hd=new Hospital_DAO();
			if(hospitalChoice==1)
			{
				hd.displayAllHospitalDetails();
				
			}else if(hospitalChoice==2)
			{
				System.out.println("Enter Hosiptal Name to get its details .");
				String name=mr.nextLine();
				//mr.nextLine();
				hd.displayHospitalDetailsBasedName(name);
				
			}else if(hospitalChoice==3)
			{
				System.out.println("Enter Hosiptal Id to delete ");
				int id=mr.nextInt();
				//mr.nextLine();
				hd.removeHospital(id);
				
			}else if(hospitalChoice==4)
			{
				System.out.println("Enter Hosiptal Id to update details .");
				int id=mr.nextInt();
				hd.updateHospital(id);
				
			}else if(hospitalChoice==5)
			{
				hd.addObject();
				
			}else
				System.out.println("Invalid Choice.");
				System.exit(0);
		}catch(InputMismatchException e)
		{
			System.out.println("Invalid Input ");
		}
		finally
		{
			mr.close();
		}

		
	}

}
