package com.curalink.managers;

import com.curalink.features.DischargePatientFeature;
import com.curalink.features.RegisterPatientFeature;
import com.curalink.features.ViewAllPatientsFeature;
import com.curalink.features.ViewPatientStatusFeature;
import com.curalink.models.Patient;
import com.curalink.utils.SystemUtils;
import java.util.List;

public class PatientManager {
    private List<Patient> patientList;

    public PatientManager(List<Patient> patientList) {
        this.patientList = patientList;
    }

    public void showPanel() {
        boolean back = false;
        while (!back) {
            SystemUtils.clearScreen();
            System.out.println("\t\t\t\t\t------ PATIENT MANAGEMENT PANEL ------\n\n");
            
            System.out.println("\t\t\t\t\t\t  1. Register New Patient\n");
            System.out.println("\t\t\t\t\t\t  2. View All Patients\n");
            System.out.println("\t\t\t\t\t\t  3. View Patients Status\n");
            System.out.println("\t\t\t\t\t\t  4. Discharge Patient\n\n");
            System.out.println("\t\t\t\t\t\t  5. Back to Main Menu\n\n");
            
            int choice = SystemUtils.readInt("\t\t\t\t\tEnter Choice: ");
            
            switch (choice) {
                case 1: new RegisterPatientFeature(patientList).execute(); break;
                case 2: new ViewAllPatientsFeature(patientList).execute(); break;
                case 3: new ViewPatientStatusFeature(patientList).execute(); break;
                case 4: new DischargePatientFeature(patientList).execute(); break;
                case 5: back = true; break;
                default: System.out.println("\t\t\t\t\tInvalid option."); SystemUtils.pause();
            }
        }
    }
}
