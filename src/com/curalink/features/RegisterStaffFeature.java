package com.curalink.features;

import com.curalink.models.Doctor;
import com.curalink.models.Nurse;
import com.curalink.models.Person;
import com.curalink.utils.SystemUtils;
import java.util.List;

public class RegisterStaffFeature implements Feature {
    private List<Person> staffList;

    public RegisterStaffFeature(List<Person> staffList) {
        this.staffList = staffList;
    }

    @Override
    public void execute() {
        SystemUtils.clearScreen();
        System.out.println("                                        ------ ADD NEW STAFF ------\n\n");
        System.out.println("                                        1. Doctor\n");
        System.out.println("                                        2. Nurse\n\n");
        
        int type = SystemUtils.readInt("                                        Select Staff Type: ");

        if (type != 1 && type != 2) {
            System.out.println("                                        Invalid selection.");
            return;
        }

        System.out.print("                                        Enter Name: ");
        String name = SystemUtils.scanner.nextLine();
        int age = SystemUtils.readInt("                                        Enter Age: ");

        if (type == 1) { 
            System.out.print("                                        Enter Department: ");
            String spec = SystemUtils.scanner.nextLine();
            
            int count = 0;
            for (Person p : staffList) {
                if (p instanceof Doctor) count++;
            }
            String id = String.format("D%03d", count + 1);
            
            staffList.add(new Doctor(id, name, age, spec));
            System.out.println("                                        Success! Doctor Registered with ID: " + id);
            
        } else { 
            System.out.print("                                        Enter Shift (Day/Night): ");
            String shift = SystemUtils.scanner.nextLine();
            
            int count = 0;
            for (Person p : staffList) {
                if (p instanceof Nurse) count++;
            }
            String id = String.format("N%03d", count + 1);
            
            staffList.add(new Nurse(id, name, age, shift));
            System.out.println("                                        Success! Nurse Registered with ID: " + id);
        }
        SystemUtils.pause();
    }
}
