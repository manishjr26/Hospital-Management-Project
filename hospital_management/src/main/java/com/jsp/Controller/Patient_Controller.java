package com.jsp.Controller;


import com.jsp.DAO.Patient_DAO;

public class Patient_Controller
{
	public static void main(String[] args) 
	{
		Patient_DAO a=new Patient_DAO();
		System.out.println("\n\t\t ==================== Welome To Patient Controller ===================== \t \nChoose Your Choice ");
		System.out.println("\n\t\t 1 - Create Patient \t 2 - Remove Patient \t 3 - display Patient Details By name \n\t\t\t 4 - display all Patient Details in Hospital");		
		java.util.Scanner mr=new java.util.Scanner(System.in);
		int patientChoice=mr.nextInt();
		mr.nextLine();
		if(patientChoice==1)
		{System.out.println("Enter Hosiptal id");
		int id=mr.nextInt();
			a.createPatient(id);
			
		}else if(patientChoice==2)
		{System.out.println("Enter Hosiptal id");
		int id=mr.nextInt();
			a.removePatient(id);
		}else if(patientChoice==3)
		{System.out.println("Enter Patient name");
			String name=mr.nextLine();
			a.displayPatientDetailsByname(name);
		}else if(patientChoice==4)
		{
			System.out.println("Enter Hosiptal id");
			int id=mr.nextInt();
			a.displayAllPatientDetails(id);
		}else
			System.out.println("Invalid Details");
			System.exit(0);
	mr.close();
	}

}
