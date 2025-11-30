package com.curalink.features;

import com.curalink.models.Patient;
import com.curalink.utils.SystemUtils;
import java.util.List;

public class RegisterPatientFeature implements Feature {
    private List<Patient> patientList;

    public RegisterPatientFeature(List<Patient> patientList) {
        this.patientList = patientList;
    }

    @Override
    public void execute() {
        SystemUtils.clearScreen();
        System.out.println("\t\t\t\t\t------ NEW PATIENT REGISTRATION ------\n\n");
        System.out.print("\t\t\t\t\tEnter Name: ");
        String name = SystemUtils.scanner.nextLine();
        int age = SystemUtils.readInt("\t\t\t\t\tEnter Age: ");
        System.out.print("\t\t\t\t\tEnter Complaint/Illness: ");
        String illness = SystemUtils.scanner.nextLine();
        
        String id = String.format("P%03d", patientList.size() + 1); 
        Patient newPatient = new Patient(id, name, age, illness);
        patientList.add(newPatient);
        System.out.println("\t\t\t\t\tSuccess! Patient Registered with ID: " + id);
        SystemUtils.pause();
    }
}

