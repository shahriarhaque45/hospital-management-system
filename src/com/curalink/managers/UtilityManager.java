package com.curalink.managers;

import com.curalink.features.CheckBedAvailabilityFeature;
import com.curalink.features.GenerateStatisticsFeature;
import com.curalink.features.GlobalSearchFeature;
import com.curalink.models.Patient;
import com.curalink.models.Person;
import com.curalink.utils.SystemUtils;
import java.util.List;

public class UtilityManager {
    private List<Person> staffList;
    private List<Patient> patientList;
    private int maxBeds;

    public UtilityManager(List<Person> staffList, List<Patient> patientList, int maxBeds) {
        this.staffList = staffList;
        this.patientList = patientList;
        this.maxBeds = maxBeds;
    }

    public void showPanel() {
        boolean back = false;
        while (!back) {
            SystemUtils.clearScreen();
            System.out.println("                                        ------ UTILITY MANAGEMENT PANEL ------\n\n");
            
            System.out.println("                                                  1. General Statistics\n");
            System.out.println("                                                  2. Check Bed Availability\n");
            System.out.println("                                                  3. Global Search\n\n");
            System.out.println("                                                  4. Back to Main Menu\n\n");

            int choice = SystemUtils.readInt("                                        Enter Choice: ");

            switch (choice) {
                case 1: new GenerateStatisticsFeature(staffList, patientList).execute(); break;
                case 2: new CheckBedAvailabilityFeature(patientList, maxBeds).execute(); break;
                case 3: new GlobalSearchFeature(staffList, patientList).execute(); break;
                case 4: back = true; break;
                default: System.out.println("                                        Invalid option."); SystemUtils.pause();
            }
        }
    }
}
