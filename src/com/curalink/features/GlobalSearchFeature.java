package com.curalink.features;

import com.curalink.models.Patient;
import com.curalink.models.Person;
import com.curalink.utils.SystemUtils;
import java.util.ArrayList;
import java.util.List;

public class GlobalSearchFeature implements Feature {
    private List<Person> staffList;
    private List<Patient> patientList;

    public GlobalSearchFeature(List<Person> staffList, List<Patient> patientList) {
        this.staffList = staffList;
        this.patientList = patientList;
    }

    @Override
    public void execute() {
        SystemUtils.clearScreen();
        System.out.println("\t\t\t\t\t------ GLOBAL SEARCH ------\n\n");
        
        System.out.println("\t\t\t\t\t1. Search by ID\n");
        System.out.println("\t\t\t\t\t2. Search by Name & Age\n\n");
        
        int choice = SystemUtils.readInt("\t\t\t\t\tSelect method: ");

        List<Person> allPeople = new ArrayList<>();
        allPeople.addAll(staffList);
        allPeople.addAll(patientList);
        Person result = null;

        if (choice == 1) {
            System.out.print("\t\t\t\t\tEnter ID: ");
            String id = SystemUtils.scanner.nextLine();
            result = findPerson(allPeople, id);
        } else if (choice == 2) {
            System.out.print("\t\t\t\t\tEnter Name: ");
            String name = SystemUtils.scanner.nextLine();
            int age = SystemUtils.readInt("\t\t\t\t\tEnter Age: ");
            result = findPerson(allPeople, name, age);
        }

        if (result != null) {
            System.out.println("\n\t\t\t\t\tResult Found: " + result);
        } else {
            System.out.println("\n\t\t\t\t\tNo records found.");
        }
        SystemUtils.pause();
    }

    public static Person findPerson(List<Person> people, String id) {
        for (Person p : people) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }

    public static Person findPerson(List<Person> people, String name, int age) {
        for (Person p : people) {
            if (p.getName().equalsIgnoreCase(name) && p.getAge() == age) {
                return p;
            }
        }
        return null;
    }
}
