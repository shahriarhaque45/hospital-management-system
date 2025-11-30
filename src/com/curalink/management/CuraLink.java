package com.curalink.management;

import com.curalink.managers.PatientManager;
import com.curalink.managers.StaffManager;
import com.curalink.managers.UtilityManager;
import com.curalink.models.Doctor;
import com.curalink.models.Nurse;
import com.curalink.models.Patient;
import com.curalink.models.Person;
import com.curalink.utils.SystemUtils;
import java.util.ArrayList;
import java.util.List;

public class CuraLink {
    
    private static List<Person> staffList = new ArrayList<>();
    private static List<Patient> patientList = new ArrayList<>();
    private static final int MAX_BEDS = 50; 

    public static void main(String[] args) {
        initializeData();
        
        StaffManager staffManager = new StaffManager(staffList);
        PatientManager patientManager = new PatientManager(patientList);
        UtilityManager utilityManager = new UtilityManager(staffList, patientList, MAX_BEDS);

        boolean running = true;
        while (running) {
            SystemUtils.clearScreen();
            System.out.println("\t\t\t\t\t------------------------------------------");
            System.out.println("\t\t\t\t\t\t  HOSPITAL MANAGEMENT SYSTEM");
            System.out.println("\t\t\t\t\t------------------------------------------\n\n");
            
            System.out.println("\t\t\t\t\t\t  1. Staff Management\n");
            System.out.println("\t\t\t\t\t\t  2. Patient Management\n");
            System.out.println("\t\t\t\t\t\t  3. Utility Management\n\n");
            System.out.println("\t\t\t\t\t\t  4. Exit System\n\n");
            
            System.out.println("\t\t\t\t\t------------------------------------------");
            
            int choice = SystemUtils.readInt("\t\t\t\t\tEnter Main Menu Choice: ");

            switch (choice) {
                case 1: staffManager.showPanel(); break;
                case 2: patientManager.showPanel(); break;
                case 3: utilityManager.showPanel(); break;
                case 4: 
                    running = false; 
                    System.out.println("\n\t\t\t\t\tSystem Exiting.");
                    break;
                default: System.out.println("\t\t\t\t\tInvalid Choice!"); SystemUtils.pause();
            }
        }
    }

    private static void initializeData() {
        staffList.add(new Doctor("D001", "Dr. Anisur Rahman", 45, "Cardiology"));
        staffList.add(new Doctor("D002", "Dr. Fatema Begum", 50, "Neurology"));
        staffList.add(new Nurse("N001", "Shirin Akter", 29, "Night"));
        staffList.add(new Nurse("N002", "Rahim Uddin", 32, "Day"));
        
        patientList.add(new Patient("P001", "Rafiqul Islam", 30, "Chest Pain"));
        patientList.add(new Patient("P002", "Karim Ahmed", 45, "High Fever"));
    }
}
