package com.curalink.managers;

import com.curalink.features.RegisterStaffFeature;
import com.curalink.features.ViewStaffActivityFeature;
import com.curalink.features.ViewStaffListFeature;
import com.curalink.models.Person;
import com.curalink.utils.SystemUtils;
import java.util.List;

public class StaffManager {
    private List<Person> staffList;

    public StaffManager(List<Person> staffList) {
        this.staffList = staffList;
    }

    public void showPanel() {
        boolean back = false;
        while (!back) {
            SystemUtils.clearScreen();
            System.out.println("                                        ------ STAFF MANAGEMENT PANEL ------\n\n");
            
            System.out.println("                                                  1. Add New Staff\n");
            System.out.println("                                                  2. View Staff List\n");
            System.out.println("                                                  3. View Staff Activity\n\n");
            System.out.println("                                                  4. Back to Main Menu\n\n");
            
            int choice = SystemUtils.readInt("                                        Enter Choice: ");
            
            switch (choice) {
                case 1: new RegisterStaffFeature(staffList).execute(); break;
                case 2: new ViewStaffListFeature(staffList).execute(); break;
                case 3: new ViewStaffActivityFeature(staffList).execute(); break;
                case 4: back = true; break;
                default: System.out.println("                                        Invalid option."); SystemUtils.pause();
            }
        }
    }
}
