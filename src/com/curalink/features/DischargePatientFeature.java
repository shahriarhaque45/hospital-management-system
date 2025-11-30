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
        System.out.println("                                        ------ DISCHARGE PATIENT ------\n\n");
        System.out.print("                                 Enter Patient ID to Discharge: ");
        String id = SystemUtils.scanner.nextLine();
        
        Patient p = null;
        for (Patient patient : patientList) {
            if (patient.getId().equalsIgnoreCase(id)) {
                p = patient;
                break; 
            }
        }

        if (p != null) {
            int amount = SystemUtils.readInt("                                 Enter Total Bill Amount: ");
            
            System.out.print("                                 Has Insurance? (yes/no): ");
            String insuranceInput = SystemUtils.scanner.nextLine();
            boolean hasInsurance = insuranceInput.equalsIgnoreCase("yes") || insuranceInput.equalsIgnoreCase("true");
            
            SystemUtils.clearScreen();
            if (hasInsurance) {
                int coverage = SystemUtils.readInt("                                 Enter Insurance Coverage Amount: ");
                SystemUtils.clearScreen();
                System.out.println("                                        ------ FINAL BILL (INSURANCE APPLIED) ------\n\n");
                System.out.println("                                 Patient: " + p.getName());
                System.out.println("                                 Base Amount: BDT " + amount);
                System.out.println("                                 Insurance Paid: -BDT " + coverage);
                System.out.println("                                 Patient Pays: BDT " + (amount - coverage));
            } else {
                SystemUtils.clearScreen();
                System.out.println("                                        ------ FINAL BILL ------\n\n");
                System.out.println("                                 Patient: " + p.getName());
                System.out.println("                                 Total Amount: BDT " + amount);
            }
            
            System.out.print("\n\n                                 Confirm Discharge? (yes/no): ");
            String confirm = SystemUtils.scanner.nextLine();

            if (confirm.equalsIgnoreCase("yes")) {
                patientList.remove(p);
                System.out.println("\n                               Patient " + p.getName() + " has been discharged.");
            } else {
                System.out.println("\n                               Discharge cancelled.");
            }
            
        } else {
            System.out.println("                                  Patient not found in records.");
        }
        SystemUtils.pause();
    }
}
