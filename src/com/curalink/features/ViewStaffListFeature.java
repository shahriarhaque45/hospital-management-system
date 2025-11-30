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
        System.out.println("                                        ------ STAFF LIST ------\n\n");
        
        System.out.println("                                        Doctors:");
        for (Person p : staffList) {
            if (p instanceof Doctor) System.out.println("\n                    " + p);
        }
        
        System.out.println("\n                                        Nurses:");
        for (Person p : staffList) {
            if (p instanceof Nurse) System.out.println("\n                    " + p);
        }
        SystemUtils.pause();
    }
}
