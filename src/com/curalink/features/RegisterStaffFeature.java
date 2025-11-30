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
        System.out.println("\t\t\t\t\t------ ADD NEW STAFF ------\n\n");
        System.out.println("\t\t\t\t\t1. Doctor\n");
        System.out.println("\t\t\t\t\t2. Nurse\n\n");
        
        int type = SystemUtils.readInt("\t\t\t\t\tSelect Staff Type: ");

        if (type != 1 && type != 2) {
            System.out.println("\t\t\t\t\tInvalid selection.");
            return;
        }

        System.out.print("\t\t\t\t\tEnter Name: ");
        String name = SystemUtils.scanner.nextLine();
        int age = SystemUtils.readInt("\t\t\t\t\tEnter Age: ");

        if (type == 1) { 
            System.out.print("\t\t\t\t\tEnter Department: ");
            String spec = SystemUtils.scanner.nextLine();
            
            int count = 0;
            for (Person p : staffList) {
                if (p instanceof Doctor) count++;
            }
            String id = String.format("D%03d", count + 1);
            
            staffList.add(new Doctor(id, name, age, spec));
            System.out.println("\t\t\t\t\tSuccess! Doctor Registered with ID: " + id);
            
        } else { 
            System.out.print("\t\t\t\t\tEnter Shift (Day/Night): ");
            String shift = SystemUtils.scanner.nextLine();
            
            int count = 0;
            for (Person p : staffList) {
                if (p instanceof Nurse) count++;
            }
            String id = String.format("N%03d", count + 1);
            
            staffList.add(new Nurse(id, name, age, shift));
            System.out.println("\t\t\t\t\tSuccess! Nurse Registered with ID: " + id);
        }
        SystemUtils.pause();
    }
}
