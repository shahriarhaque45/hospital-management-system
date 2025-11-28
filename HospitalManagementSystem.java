import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HospitalManagementSystem {
    
    // Polymorphism in stafflist  
    private static List<Person> staffList = new ArrayList<>();
    private static List<Patient> patientList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Pre-populating some data
        staffList.add(new Doctor("D001", "Dr. Anisur Rahman", 45, "Cardiology"));
        staffList.add(new Doctor("D002", "Dr. Fatema Begum", 50, "Neurology"));
        staffList.add(new Doctor("D003", "Dr. Kamal Hossain", 55, "Orthopedics"));
        staffList.add(new Doctor("D004", "Dr. Nasreen Sultana", 40, "Pediatrics"));

        staffList.add(new Nurse("N001", "Shirin Akter", 29, "Night"));
        staffList.add(new Nurse("N002", "Rahim Uddin", 32, "Day"));
        staffList.add(new Nurse("N003", "Salma Khatun", 25, "Morning"));
        staffList.add(new Nurse("N004", "Joya Das", 27, "Evening"));
        
        patientList.add(new Patient("P001", "Rafiqul Islam", 30, "Chest Pain"));
        patientList.add(new Patient("P002", "Karim Ahmed", 45, "High Fever"));
        patientList.add(new Patient("P003", "Sumaiya Parvin", 22, "Dengue"));
        patientList.add(new Patient("P004", "Amit Roy", 12, "Fracture"));
        
        // Loop for menu
        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("                                                            ------------------------------------------");
            System.out.println("                                                            ---     HOSPITAL MANAGEMENT SYSTEM     ---");
            System.out.println("                                                            ------------------------------------------");
            System.out.println("                                                            1. Register New Patient");
            System.out.println("                                                            2. View Staff Details");
            System.out.println("                                                            3. View Staff Activity");
            System.out.println("                                                            4. View Patient Activity");
            System.out.println("                                                            5. View All Patients");
            System.out.println("                                                            6. Doctor Diagnosis");
            System.out.println("                                                            7. Generate Bill");
            System.out.println("                                                            8. Search Patient");
            System.out.println("                                                            9. Exit");
            System.out.println("                                                            ------------------------------------------");
            System.out.print("                                                            Enter Choice: ");
            
            String input = scanner.nextLine();
            int choice = -1;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("                                                                    Invalid Input!");
                continue;
            }

            switch (choice) {
                case 1: registerPatient(); break;
                case 2: viewStaffDetails(); break;
                case 3: viewStaffActivity(); break;
                case 4: viewPatientActivity(); break;
                case 5: viewPatients(); break;
                case 6: performDiagnosis(); break;
                case 7: billingProcess(); break;
                case 8: searchSystem(); break;
                case 9:
                    running = false;
                    System.out.println("                                                                    System Exiting...");
                    break;
                default:
                    System.out.println("                                                                    Invalid Choice!");
            }
        }
    }
    
    // Option 1: Patient registration
    private static void registerPatient() {
        System.out.println();
        System.out.println("                                                                    --- REGISTER PATIENT ---");
        
        System.out.print("                                                            Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("                                                            Enter Age: ");
        String ageStr = scanner.nextLine();
        int age;
        try {
            age = Integer.parseInt(ageStr);
        } catch (NumberFormatException e) {
            System.out.println("                                                                    Invalid Age! Registration Cancelled.");
            return;
        }

        System.out.print("                                                            Enter Illness: ");
        String illness = scanner.nextLine();
        
        // Patient ID generation
        String id = String.format("P%03d", patientList.size() + 1); 
        
        Patient newPatient = new Patient(id, name, age, illness);
        patientList.add(newPatient);
        System.out.println("                                                                    Patient Registered Successfully! ID: " + id);

        // Pause logic
        pause();
    }

    // Option 2: Shows staff details
    private static void viewStaffDetails() {
        System.out.println();
        System.out.println("                                                                            --- STAFF DETAILS ---");
        for (Person p : staffList) {
            System.out.println("                                                            " + p);
        }
        pause();
    }

    // Option 3: Shows staff specific activity
    private static void viewStaffActivity() {
        System.out.println();
        System.out.println("                                                                            --- STAFF ACTIVITY ---");
        for (Person p : staffList) {
            System.out.print("                                                            ");
            p.performRole(); 
        }
        pause();
    }

    // Option 4: Shows Patient specific activity
    private static void viewPatientActivity() {
        System.out.println();
        System.out.println("                                                                            --- PATIENT ACTIVITY ---");
        for (Patient p : patientList) {
            System.out.print("                                                            ");
            p.performRole(); 
        }
        pause();
    }
    
    // Option 5: Shows patient list
    private static void viewPatients() {
        System.out.println();
        System.out.println("                                                                            --- ADMITTED PATIENTS ---");
        for (Patient p : patientList) {
            System.out.println("                                                            " + p);
        }
        pause();
    }

    // Option 6: Doctor performs diagnosis
    private static void performDiagnosis() {
        System.out.println();
        System.out.println("                                                                            --- DOCTOR DIAGNOSIS ---");
        
        System.out.print("                                                            Enter Patient ID: ");
        String pId = scanner.nextLine();

        Patient p = (Patient) HospitalUtils.findPerson(new ArrayList<>(patientList), pId);

        if (p != null) {
            System.out.print("                                                            Enter Doctor ID: ");
            String dId = scanner.nextLine();

            Person staff = HospitalUtils.findPerson(staffList, dId);
            
            if (staff instanceof Doctor) {
                System.out.print("                                                            Enter Diagnosis Details: ");
                String diagnosis = scanner.nextLine();

                System.out.print("                                                            ");
                ((Doctor) staff).diagnosePatient(p, diagnosis);
                pause();

            } else {
                System.out.println("                                                                    Invalid Doctor ID or ID belongs to Nurse.");
                pause();
            }
        } else {
            System.out.println("                                                                    Patient not found.");
            pause();
        }
    }

    private static void billingProcess() {
        System.out.print("                                                            Enter Patient ID: ");
        String id = scanner.nextLine();
        
        Patient p = (Patient) HospitalUtils.findPerson(new ArrayList<>(patientList), id);

        if (p != null) {
            HospitalBilling billing = new HospitalBilling();
            
            System.out.print("                                                            Enter Bill Amount: ");
            String amountStr = scanner.nextLine();
            
            int amount;
            try {
                amount = Integer.parseInt(amountStr);
            } catch (NumberFormatException e) {
                System.out.println("                                                                    Invalid Amount! Billing Cancelled.");
                return;
            }
            
            System.out.print("                                                            Has Insurance? (true/false): ");
            String insuranceInput = scanner.nextLine();

            boolean hasInsurance = Boolean.parseBoolean(insuranceInput);
            
            if (hasInsurance) {
                System.out.print("                                                            Enter Insurance Coverage Amount: ");
                String coverageStr = scanner.nextLine();
                
                int coverage;
                try {
                    coverage = Integer.parseInt(coverageStr);
                } catch (NumberFormatException e) {
                    System.out.println("                                                                    Invalid Coverage Amount! Billing Cancelled.");
                    return;
                }
                billing.generateBill(p, amount, coverage);
            } else {
                billing.generateBill(p, amount);
            }
            pause();
        } else {
            System.out.println("                                                                    Patient not found.");
            pause();
        }
    }
    
    // Option 8: Search Patients
    private static void searchSystem() {
        System.out.println();
        System.out.println("                                                                                        --- SEARCH PERSON ---");
        System.out.println("                                                            Search by: 1. ID  2. Name & Age");
        System.out.print("                                                            Enter Choice: ");
        String choiceStr = scanner.nextLine();

        int choice;
        try {
            choice = Integer.parseInt(choiceStr);
        } catch (NumberFormatException e) {
            System.out.println("                                                                    Invalid Input!");
            return;
        }

        List<Person> allPeople = new ArrayList<>();
        allPeople.addAll(staffList);
        allPeople.addAll(patientList);

        Person result = null;

        if (choice == 1) {
            System.out.print("                                                            Enter ID: ");
            String id = scanner.nextLine();
            result = HospitalUtils.findPerson(allPeople, id);
        } else if (choice == 2) {
            System.out.print("                                                            Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("                                                            Enter Age: ");
            String ageStr = scanner.nextLine();
            
            int age;
            try {
                age = Integer.parseInt(ageStr);
            } catch (NumberFormatException e) {
                System.out.println("                                                                    Invalid Age! Search Cancelled.");
                return;
            }
            result = HospitalUtils.findPerson(allPeople, name, age);
        }

        if (result != null) {
            System.out.println("                                                                    Found: " + result);
        } else {
            System.out.println("                                                                    Person not found.");
        }
        pause();
    }

    // Helper method to reduce code repetition for the "Type 0 to go back" logic
    private static void pause() {
        System.out.println();
        System.out.print("                                                            Type 0 to go back: ");
        while (!scanner.nextLine().equals("0")) {
            System.out.print("                                                            Type 0 to go back: ");
        }
    }
}