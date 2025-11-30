package com.curalink.features;

import com.curalink.models.Patient;
import com.curalink.utils.SystemUtils;
import java.util.List;

public class CheckBedAvailabilityFeature implements Feature {
    private List<Patient> patientList;
    private int maxBeds;

    public CheckBedAvailabilityFeature(List<Patient> patientList, int maxBeds) {
        this.patientList = patientList;
        this.maxBeds = maxBeds;
    }

    @Override
    public void execute() {
        SystemUtils.clearScreen();
        System.out.println("                                        ------ BED AVAILABILITY ------\n\n");
        int occupied = patientList.size();
        int available = maxBeds - occupied;
        
        System.out.println("                                        Max Capacity : " + maxBeds);
        System.out.println("                                        Occupied     : " + occupied);
        System.out.println("                                        Available    : " + available);
        
        if (available == 0) {
            System.out.println("\n                                        WARNING: No beds available!");
        } else if (available < 5) {
            System.out.println("\n                                        ALERT: Hospital is reaching capacity.");
        } else {
            System.out.println("\n                                        Status: Normal capacity.");
        }
        SystemUtils.pause();
    }
}
