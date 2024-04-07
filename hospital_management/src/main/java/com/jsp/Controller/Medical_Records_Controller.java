package com.jsp.Controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.jsp.DAO.Medical_DAO;

public class Medical_Records_Controller {
    public static void main(String[] args) {
        Medical_DAO md = new Medical_DAO();
        System.out.println("\n\t\t\t=============== Welcome To Medical_Records Controller ================== \t \n\tChoose Your Choice ");
        System.out.println("\n\t 1 - Add Medical Records \t 2 - Update Date of Examination \t 3 - Remove Medical Records \n\t\t\t 4 - Display Medical Records of Particular Patient");
        Scanner mr = new Scanner(System.in);
        try {
            int medicalChoice = mr.nextInt();
            System.out.println("Enter Patient Id :");
            int patientId = mr.nextInt();
            switch (medicalChoice) {
                case 1:
                    
                    md.addMedicalRecords(patientId);
                    break;
                case 2:
                    
                    md.updateDate_of_Examination(patientId);
                    break;
                case 3:
                    
                    md.removeMedicalRecords(patientId);
                    break;
                case 4:
                 
                    md.displayMedicalRecordsOfParticularPatient(patientId);
                    break;
                default:
                    System.out.println("Invalid Choice. Please enter a valid choice.");
            }
        } catch (InputMismatchException e) {
            System.err.println("Invalid input. Please enter a valid integer choice.");
        } finally {
            md.closeScanner();
            mr.close();
        }
    }
}
