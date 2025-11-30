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
        System.out.println("                                        ------ NEW PATIENT REGISTRATION ------\n\n");
        System.out.print("                                        Enter Name: ");
        String name = SystemUtils.scanner.nextLine();
        int age = SystemUtils.readInt("                                        Enter Age: ");
        System.out.print("                                        Enter Complaint/Illness: ");
        String illness = SystemUtils.scanner.nextLine();
        
        String id = String.format("P%03d", patientList.size() + 1); 
        Patient newPatient = new Patient(id, name, age, illness);
        patientList.add(newPatient);
        System.out.println("                                        Success! Patient Registered with ID: " + id);
        SystemUtils.pause();
    }
}

