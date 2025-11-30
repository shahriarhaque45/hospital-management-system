package com.curalink.features;

import com.curalink.models.Doctor;
import com.curalink.models.Nurse;
import com.curalink.models.Person;
import com.curalink.utils.SystemUtils;
import java.util.List;

public class ViewStaffListFeature implements Feature {
    private List<Person> staffList;

    public ViewStaffListFeature(List<Person> staffList) {
        this.staffList = staffList;
    }

    @Override
    public void execute() {
        SystemUtils.clearScreen();
        System.out.println("\t\t\t\t\t------ STAFF LIST ------\n\n");
        
        if (staffList.isEmpty()) {
            System.out.println("\t\t\t\t\tEmpty Database");
        } else {
            System.out.println("\t\t\tDoctors:");
            for (Person p : staffList) {
                if (p instanceof Doctor) System.out.println("\n\t\t\t" + p);
            }
            
            System.out.println("\n\t\t\tNurses:");
            for (Person p : staffList) {
                if (p instanceof Nurse) System.out.println("\n\t\t\t" + p);
            }
        }
        SystemUtils.pause();
    }
}
