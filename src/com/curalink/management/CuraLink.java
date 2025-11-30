package com.curalink.management;

import com.curalink.data.DataManager;
import com.curalink.managers.PatientManager;
import com.curalink.managers.StaffManager;
import com.curalink.managers.UtilityManager;
import com.curalink.models.Patient;
import com.curalink.models.Person;
import com.curalink.utils.SystemUtils;
import java.util.List;
import java.util.Map;

public class CuraLink {
    
    private static List<Person> staffList;
    private static List<Patient> patientList;
    private static final int MAX_BEDS = 50;
    private static boolean isTestingMode = false;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Map<String, List<?>> data = DataManager.loadPrimaryData();
        staffList = (List<Person>) data.get("staff");
        patientList = (List<Patient>) data.get("patients");
        
        StaffManager staffManager = new StaffManager(staffList);
        PatientManager patientManager = new PatientManager(patientList);
        UtilityManager utilityManager = new UtilityManager(staffList, patientList, MAX_BEDS);

        boolean running = true;
        while (running) {
            SystemUtils.clearScreen();
            System.out.println("\t\t\t\t\t------------------------------------------");
            System.out.println("\t\t\t\t\t\t  HOSPITAL MANAGEMENT SYSTEM");
            if (isTestingMode) {
                System.out.println("\t\t\t\t\t\t      (TESTING MODE)");
            }
            System.out.println("\t\t\t\t\t------------------------------------------\n\n");
            
            System.out.println("\t\t\t\t\t\t  1. Staff Management\n");
            System.out.println("\t\t\t\t\t\t  2. Patient Management\n");
            System.out.println("\t\t\t\t\t\t  3. Utility Management\n");
            System.out.println("\t\t\t\t\t\t  4. Load Default (Test) Data\n\n");
            System.out.println("\t\t\t\t\t\t  5. Exit System\n\n");
            
            System.out.println("\t\t\t\t\t------------------------------------------");
            
            int choice = SystemUtils.readInt("\t\t\t\t\tEnter Main Menu Choice: ");

            switch (choice) {
                case 1: staffManager.showPanel(); break;
                case 2: patientManager.showPanel(); break;
                case 3: utilityManager.showPanel(); break;
                case 4:
                    Map<String, List<?>> defaultData = DataManager.loadDefaultData();
                    staffList = (List<Person>) defaultData.get("staff");
                    patientList = (List<Patient>) defaultData.get("patients");

                    staffManager = new StaffManager(staffList);
                    patientManager = new PatientManager(patientList);
                    utilityManager = new UtilityManager(staffList, patientList, MAX_BEDS);
                    
                    isTestingMode = true;
                    System.out.println("\n\t\t\t\t\tIn testing mode, default data loaded. Changes will not be saved.");
                    SystemUtils.pause();
                    break;
                case 5: 
                    if (isTestingMode) {
                        System.out.println("\n\t\t\t\t\tExiting test mode without saving.");
                    } else {
                        DataManager.saveData(staffList, patientList);
                    }
                    running = false; 
                    System.out.println("\n\t\t\t\t\tSystem Exiting.");
                    break;
                default: System.out.println("\t\t\t\t\tInvalid Choice!"); SystemUtils.pause();
            }
        }
    }
}
