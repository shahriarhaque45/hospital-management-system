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
        System.out.println("\t\t\t\t\t------ BED AVAILABILITY ------\n\n");
        int occupied = patientList.size();
        int available = maxBeds - occupied;
        
        System.out.println("\t\t\t\t\tMax Capacity : " + maxBeds);
        System.out.println("\t\t\t\t\tOccupied     : " + occupied);
        System.out.println("\t\t\t\t\tAvailable    : " + available);
        
        if (available == 0) {
            System.out.println("\n\t\t\t\t\tWARNING: No beds available!");
        } else if (available < 5) {
            System.out.println("\n\t\t\t\t\tALERT: Hospital is reaching capacity.");
        } else {
            System.out.println("\n\t\t\t\t\tStatus: Normal capacity.");
        }
        SystemUtils.pause();
    }
}
