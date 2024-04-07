package com.jsp.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.jsp.DTO.Doctor;
import com.jsp.DTO.Hospital;

public class Doctor_DAO 
{
    EntityManagerFactory f = Persistence.createEntityManagerFactory("Your");
    EntityManager em = f.createEntityManager();
    EntityTransaction t = em.getTransaction();
    java.util.Scanner mr = new java.util.Scanner(System.in);

    public void createDoctor(int hospitalId)
    {
        t.begin();
        Hospital hospital = em.find(Hospital.class, hospitalId);
        if (hospital != null) 
        {
            Doctor doctor = new Doctor();
            System.out.println("Enter Doctor Name: ");
            String name = mr.nextLine();
            String upper=name.toUpperCase();
            System.out.println("Enter Doctor Qualification: ");
            String qualification = mr.nextLine();
            System.out.println("Enter Doctor Salary: ");
            double salary = mr.nextDouble();
            doctor.setD_name(name);
            doctor.setQualification(qualification);
            doctor.setSalary(salary);
            doctor.setH(hospital);
            em.persist(doctor);
            t.commit();
            System.out.println("Doctor with Name \"" + upper + "\" created and assigned to Hospital \"" + hospital.getHname() + "\"");
        } else 
        {
            System.err.println("Invalid Hospital Details");
        }
    }

    public void updateSalaryBasedOnId(int hospitalId) 
    {
        t.begin();
        Hospital hs = em.find(Hospital.class, hospitalId);
        if (hs != null)
        {
            System.out.println("Enter Doctor Id :");
            int doctorId = mr.nextInt();
            Doctor dc = em.find(Doctor.class, doctorId);
            if (dc != null) 
            {
                System.out.println("Enter Doctor Salary ");
                double salary = mr.nextDouble();
                dc.setSalary(salary);
                em.merge(dc);
                t.commit();
                System.out.println("Updated Salary of Doctor : " + doctorId);
            } else 
            {
                System.err.println("Invalid Doctor Details");
                System.exit(0);
            }
        } else 
        {
            System.err.println("Invalid Hospital Details");
            System.exit(0);
        }
    }

    public void removeDoctor(int hospitalId)
    {
        t.begin();
        Hospital hs = em.find(Hospital.class, hospitalId);
        if (hs != null) 
        {
            System.out.println("Enter Doctor Id :");
            int doctorId = mr.nextInt();
            Doctor dc = em.find(Doctor.class, doctorId);
            if (dc != null) 
            {
                em.remove(dc);
                t.commit();
                System.out.println("Doctor with id : " + doctorId + " deleted successfully from Hospital " + hs.getHname());
            } else 
            {
                System.err.println("Invalid Doctor Details");
                System.exit(0);
            }
        } else
        {
            System.err.println("Invalid Hospital Details");
            System.exit(0);
        }
    }

    public void displayDoctorDetails(int hospitalId)
    {
        t.begin();
        Hospital hs = em.find(Hospital.class, hospitalId);
        if (hs != null)
        {
            System.out.println("Enter Doctor Name");
            String name = mr.nextLine();
            String lower = name.trim().toLowerCase();
            Query q = em.createQuery("select d from Doctor d where lower(d.d_name) = :name");
            q.setParameter("name", lower);
            List<Doctor> doctors = q.getResultList();
            if (!doctors.isEmpty()) 
            {
                System.out.println("Doctor Details:");
                for (Doctor d : doctors) 
                {
                    System.out.println("Doctor ID: " + d.getDoctor_id());
                    System.out.println("Doctor Name: " + d.getD_name());
                    System.out.println("Doctor Qualification: " + d.getQualification());
                    System.out.println("Doctor Salary: " + d.getSalary());
                }
                
            } else 
            {
                System.err.println("Invalid Doctor Name ..... ");
            }
        } else 
        {
            System.err.println("Invalid Hospital Details .... ");
        }
        t.commit();
    }

    public void allDoctorsDetailsOfSpecificHospital(int hospitalId)
    {
        t.begin();
        Hospital hs = em.find(Hospital.class, hospitalId);
        if (hs != null) 
        {
            System.out.println("Doctors Present in Hospital " + hs.getHname() + ":");
            Query q = em.createQuery("select d from Doctor d where d.hospital_id = :hospitalId");
            q.setParameter("hospitalId", hospitalId);
            List<Doctor> doctors = q.getResultList();
            if (!doctors.isEmpty()) 
            {
                System.out.println("Doctor Details:");
                for (Doctor d : doctors)
                {
                    System.out.println("Doctor ID: " + d.getDoctor_id());
                    System.out.println("Doctor Name: " + d.getD_name());
                    System.out.println("Doctor Qualification: " + d.getQualification());
                    System.out.println("Doctor Salary: " + d.getSalary());
                }
            } else 
            {
                System.err.println("No doctors found for this hospital.");
            }
        } else
        {
            System.err.println("Invalid Hospital Details");
        }
        t.commit();
    }

    public void closeScanner()
    {
        mr.close();
        em.close();
        f.close();
    }
}
