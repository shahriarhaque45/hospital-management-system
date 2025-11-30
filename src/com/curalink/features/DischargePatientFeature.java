package com.curalink.features;

import com.curalink.models.Patient;
import com.curalink.utils.SystemUtils;
import java.util.List;

public class DischargePatientFeature implements Feature {
    private List<Patient> patientList;

    public DischargePatientFeature(List<Patient> patientList) {
        this.patientList = patientList;
    }

    @Override
    public void execute() {
        SystemUtils.clearScreen();
        System.out.println("\t\t\t\t\t------ DISCHARGE PATIENT ------\n\n");
        System.out.print("\t\t\t\t Enter Patient ID to Discharge: ");
        String id = SystemUtils.scanner.nextLine();
        
        Patient p = null;
        for (Patient patient : patientList) {
            if (patient.getId().equalsIgnoreCase(id)) {
                p = patient;
                break; 
            }
        }

        if (p != null) {
            int amount = SystemUtils.readInt("\t\t\t\t Enter Total Bill Amount: ");
            
            System.out.print("\t\t\t\t Has Insurance? (yes/no): ");
            String insuranceInput = SystemUtils.scanner.nextLine();
            boolean hasInsurance = insuranceInput.equalsIgnoreCase("yes") || insuranceInput.equalsIgnoreCase("true");
            
            SystemUtils.clearScreen();
            if (hasInsurance) {
                int coverage = SystemUtils.readInt("\t\t\t\t Enter Insurance Coverage Amount: ");
                SystemUtils.clearScreen();
                System.out.println("\t\t\t\t\t------ FINAL BILL (INSURANCE APPLIED) ------\n\n");
                System.out.println("\t\t\t\t Patient: " + p.getName());
                System.out.println("\t\t\t\t Base Amount: BDT " + amount);
                System.out.println("\t\t\t\t Insurance Paid: -BDT " + coverage);
                System.out.println("\t\t\t\t Patient Pays: BDT " + (amount - coverage));
            } else {
                SystemUtils.clearScreen();
                System.out.println("\t\t\t\t\t------ FINAL BILL ------\n\n");
                System.out.println("\t\t\t\t Patient: " + p.getName());
                System.out.println("\t\t\t\t Total Amount: BDT " + amount);
            }
            
            System.out.print("\n\n\t\t\t\t Confirm Discharge? (yes/no): ");
            String confirm = SystemUtils.scanner.nextLine();

            if (confirm.equalsIgnoreCase("yes")) {
                patientList.remove(p);
                System.out.println("\n\t\t\t\tPatient " + p.getName() + " has been discharged.");
            } else {
                System.out.println("\n\t\t\t\tDischarge cancelled.");
            }
            
        } else {
            System.out.println("\t\t\t\t  Patient not found in records.");
        }
        SystemUtils.pause();
    }
}
