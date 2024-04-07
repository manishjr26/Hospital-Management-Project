package com.jsp.Controller;

import com.jsp.DAO.Doctor_DAO;

public class Doctor_Controller
{
    public static void main(String[] args) 
    {
        Doctor_DAO a = new Doctor_DAO();
        java.util.Scanner mr = new java.util.Scanner(System.in);
        System.out.println("\n\t\t\t=============== Welcome To Doctor Controller ============== \t \nChoose Your Choice ");
        System.out.println("\n\t\t\t 1- Add Doctor \t 2 - Update Doctor Salary \t 3 - Remove Doctor \n\t\t 4 - Display Doctor Details By Name \t 5 - Display All doctor details of particular Hospital  ");
        int doctorChoice = mr.nextInt();
        if (doctorChoice == 1 || doctorChoice == 2 || doctorChoice == 3 || doctorChoice == 4 || doctorChoice == 5) 
        {
            System.out.println("Enter Hospital Id");
            int id = mr.nextInt();
            switch (doctorChoice) 
            {
                case 1:
                    a.createDoctor(id);
                    break;
                case 2:
                    a.updateSalaryBasedOnId(id);
                    break;
                case 3:
                    a.removeDoctor(id);
                    break;
                case 4:
                    a.displayDoctorDetails(id);
                    break;
                case 5:
                    a.allDoctorsDetailsOfSpecificHospital(id);
                    break;
                default:
                    System.out.println("Invalid Details .");
                    break;
            }
        } else 
        {
            System.err.println("Invalid Details .");
        }
        mr.close();
    }
}
