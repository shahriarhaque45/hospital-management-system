package com.curalink.features;

import com.curalink.models.Doctor;
import com.curalink.models.Nurse;
import com.curalink.models.Person;
import com.curalink.utils.SystemUtils;
import java.util.List;

public class ViewStaffActivityFeature implements Feature {
    private List<Person> staffList;

    public ViewStaffActivityFeature(List<Person> staffList) {
        this.staffList = staffList;
    }

    @Override
    public void execute() {
        SystemUtils.clearScreen();
        System.out.println("\t\t\t\t\t------ STAFF ACTIVITY ------\n\n");
        
        if (staffList.isEmpty()) {
            System.out.println("\t\t\t\t\tEmpty Database");
        } else {
            for (Person p : staffList) {
                if (p instanceof Doctor) {
                    p.performRole();
                }
            }
            System.out.println(); 
            for (Person p : staffList) {
                if (p instanceof Nurse) {
                    p.performRole();
                }
            }
        }
        SystemUtils.pause();
    }
}
