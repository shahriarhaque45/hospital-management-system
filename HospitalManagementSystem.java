import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HospitalManagementSystem {
    
    private static List<Person> staffList = new ArrayList<>();
    private static List<Patient> patientList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final int MAX_BEDS = 50; 

    public static void main(String[] args) {
        initializeData();
        
        boolean running = true;
        while (running) {
            clearScreen();
            System.out.println("------------------------------------------");
            System.out.println("      HOSPITAL MANAGEMENT SYSTEM");
            System.out.println("------------------------------------------\n\n");
            
            System.out.println("          1. Staff Management\n");
            System.out.println("          2. Patient Management\n");
            System.out.println("          3. Utility Management\n");
            System.out.println("          4. Exit System\n\n");
            
            System.out.println("------------------------------------------");
            
            int choice = readInt("Enter Main Menu Choice: ");

            switch (choice) {
                case 1: staffPanel(); break;
                case 2: patientPanel(); break;
                case 3: utilityPanel(); break;
                case 4: 
                    running = false; 
                    System.out.println("System Exiting. Stay Healthy!");
                    break;
                default: System.out.println("Invalid Choice!"); pause();
            }
        }
    }

    private static void staffPanel() {
        boolean back = false;
        while (!back) {
            clearScreen();
            System.out.println("------ STAFF MANAGEMENT PANEL ------\n\n");
            
            System.out.println("          1. Add New Staff\n");
            System.out.println("          2. View Staff List\n");
            System.out.println("          3. View Staff Activity\n");
            System.out.println("          4. Back to Main Menu\n\n");
            
            int choice = readInt("Enter Choice: ");
            
            switch (choice) {
                case 1: registerStaff(); pause(); break;
                case 2:
                    System.out.println("\n------ STAFF LIST ------");
                    System.out.println("Doctors:");
                    for (Person p : staffList) {
                        if (p instanceof Doctor) System.out.println(p);
                    }
                    
                    System.out.println("\nNurses:");
                    for (Person p : staffList) {
                        if (p instanceof Nurse) System.out.println(p);
                    }
                    pause();
                    break;
                case 3:
                    System.out.println("\n------ STAFF ACTIVITY ------");
                    for (Person p : staffList) {
                        if (p instanceof Doctor) p.performRole();
                    }
                    
                    System.out.println(); 
                    
                    for (Person p : staffList) {
                        if (p instanceof Nurse) p.performRole();
                    }
                    pause();
                    break;
                case 4: back = true; break;
                default: System.out.println("Invalid option."); pause();
            }
        }
    }

    private static void patientPanel() {
        boolean back = false;
        while (!back) {
            clearScreen();
            System.out.println("------ PATIENT MANAGEMENT PANEL ------\n\n");
            
            System.out.println("          1. Register New Patient\n");
            System.out.println("          2. View All Patients\n");
            System.out.println("          3. View Patients Status\n");
            System.out.println("          4. Discharge Patient\n");
            System.out.println("          5. Back to Main Menu\n\n");
            
            int choice = readInt("Enter Choice: ");
            
            switch (choice) {
                case 1: registerPatient(); pause(); break;
                case 2: 
                    System.out.println("\n------ PATIENT LIST ------");
                    for (Patient p : patientList) System.out.println(p);
                    pause();
                    break;
                case 3:
                    System.out.println("\n------ PATIENT STATUS ------");
                    for (Patient p : patientList) p.performRole();
                    pause();
                    break;
                case 4: dischargePatient(); pause(); break;
                case 5: back = true; break;
                default: System.out.println("Invalid option."); pause();
            }
        }
    }

    private static void utilityPanel() {
        boolean back = false;
        while (!back) {
            clearScreen();
            System.out.println("------ UTILITY MANAGEMENT PANEL ------\n\n");
            
            System.out.println("          1. General Statistics\n");
            System.out.println("          2. Check Bed Availability\n");
            System.out.println("          3. Global Search\n");
            System.out.println("          4. Back to Main Menu\n\n");

            int choice = readInt("Enter Choice: ");

            switch (choice) {
                case 1: generateStatistics(); pause(); break;
                case 2: checkBedAvailability(); pause(); break;
                case 3: searchSystem(); pause(); break;
                case 4: back = true; break;
                default: System.out.println("Invalid option."); pause();
            }
        }
    }

    private static void generateStatistics() {
        System.out.println("\n------ HOSPITAL STATISTICS ------");
        
        int doctorCount = 0;
        int nurseCount = 0;
        
        for (Person p : staffList) {
            if (p instanceof Doctor) doctorCount++;
            else if (p instanceof Nurse) nurseCount++;
        }
        
        int patientCount = patientList.size();
        
        System.out.println("  Total Doctors  : " + doctorCount);
        System.out.println("  Total Nurses   : " + nurseCount);
        System.out.println("  Total Patients : " + patientCount);
        System.out.println("  -------------------------");
        System.out.println("  Total People   : " + (doctorCount + nurseCount + patientCount));
        
        if (patientCount > 0 && doctorCount > 0) {
            float ratio = (float)patientCount / doctorCount;
            if (ratio == (int)ratio) {
                System.out.println("  Doctor/Patient Ratio: 1:" + (int)ratio);
            } else {
                System.out.printf("  Doctor/Patient Ratio: 1:%.1f\n", ratio);
            }
        } else {
            System.out.println("  Doctor/Patient Ratio: N/A (Insufficient Data)");
        }
    }

    private static void checkBedAvailability() {
        System.out.println("\n------ BED AVAILABILITY ------");
        int occupied = patientList.size();
        int available = MAX_BEDS - occupied;
        
        System.out.println("  Max Capacity : " + MAX_BEDS);
        System.out.println("  Occupied     : " + occupied);
        System.out.println("  Available    : " + available);
        
        if (available == 0) {
            System.out.println("\n  WARNING: No beds available!");
        } else if (available < 5) {
            System.out.println("\n  ALERT: Hospital is reaching capacity.");
        } else {
            System.out.println("\n  Status: Normal capacity.");
        }
    }

    private static void registerStaff() {
        System.out.println("\n\n------ ADD NEW STAFF ------\n\n");
        
        System.out.println("          1. Doctor\n");
        System.out.println("          2. Nurse\n\n");
        
        int type = readInt("Select Staff Type: ");

        if (type != 1 && type != 2) {
            System.out.println("Invalid selection.");
            return;
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        int age = readInt("Enter Age: ");

        if (type == 1) { 
            System.out.print("Enter Department: ");
            String spec = scanner.nextLine();
            
            int count = 0;
            for (Person p : staffList) {
                if (p instanceof Doctor) count++;
            }
            String id = String.format("D%03d", count + 1);
            
            staffList.add(new Doctor(id, name, age, spec));
            System.out.println("Success! Doctor Registered with ID: " + id);
            
        } else { 
            System.out.print("Enter Shift (Day/Night): ");
            String shift = scanner.nextLine();
            
            int count = 0;
            for (Person p : staffList) {
                if (p instanceof Nurse) count++;
            }
            String id = String.format("N%03d", count + 1);
            
            staffList.add(new Nurse(id, name, age, shift));
            System.out.println("Success! Nurse Registered with ID: " + id);
        }
    }

    private static void registerPatient() {
        System.out.println("\n------ NEW PATIENT REGISTRATION ------");
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        int age = readInt("Enter Age: ");
        System.out.print("Enter Complaint/Illness: ");
        String illness = scanner.nextLine();
        
        String id = String.format("P%03d", patientList.size() + 1); 
        Patient newPatient = new Patient(id, name, age, illness);
        patientList.add(newPatient);
        System.out.println("Success! Patient Registered with ID: " + id);
    }

    private static void dischargePatient() {
        System.out.println("\n------ DISCHARGE PATIENT ------");
        System.out.print("Enter Patient ID to Discharge: ");
        String id = scanner.nextLine();
        
        List<Person> searchList = new ArrayList<Person>(patientList);
        Patient p = (Patient) HospitalUtils.findPerson(searchList, id);

        if (p != null) {
            HospitalBilling billing = new HospitalBilling();
            int amount = readInt("Enter Total Bill Amount: ");
            
            System.out.print("Has Insurance? (yes/no): ");
            String insuranceInput = scanner.nextLine();
            boolean hasInsurance = insuranceInput.equalsIgnoreCase("yes") || insuranceInput.equalsIgnoreCase("true");
            
            if (hasInsurance) {
                int coverage = readInt("Enter Insurance Coverage Amount: ");
                billing.generateBill(p, amount, coverage);
            } else {
                billing.generateBill(p, amount);
            }
            
            System.out.print("\nConfirm Discharge? (yes/no): ");
            String confirm = scanner.nextLine();

            if (confirm.equalsIgnoreCase("yes")) {
                patientList.remove(p);
                System.out.println("\nPatient " + p.getName() + " has been discharged.");
            } else {
                System.out.println("\nDischarge cancelled.");
            }
            
        } else {
            System.out.println("Patient not found in records.");
        }
    }

    private static void searchSystem() {
        System.out.println("\n\n------ SEARCH ------\n\n");
        
        System.out.println("          1. Search by ID\n");
        System.out.println("          2. Search by Name & Age\n\n");
        
        int choice = readInt("Select method: ");

        List<Person> allPeople = new ArrayList<>();
        allPeople.addAll(staffList);
        allPeople.addAll(patientList);
        Person result = null;

        if (choice == 1) {
            System.out.print("Enter ID: ");
            String id = scanner.nextLine();
            result = HospitalUtils.findPerson(allPeople, id);
        } else if (choice == 2) {
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            int age = readInt("Enter Age: ");
            result = HospitalUtils.findPerson(allPeople, name, age);
        }

        if (result != null) {
            System.out.println("Result Found: " + result);
        } else {
            System.out.println("No records found.");
        }
    }

    private static void initializeData() {
        staffList.add(new Doctor("D001", "Dr. Anisur Rahman", 45, "Cardiology"));
        staffList.add(new Doctor("D002", "Dr. Fatema Begum", 50, "Neurology"));
        staffList.add(new Nurse("N001", "Shirin Akter", 29, "Night"));
        staffList.add(new Nurse("N002", "Rahim Uddin", 32, "Day"));
        
        patientList.add(new Patient("P001", "Rafiqul Islam", 30, "Chest Pain"));
        patientList.add(new Patient("P002", "Karim Ahmed", 45, "High Fever"));
    }

    private static int readInt(String prompt) {
        System.out.print(prompt);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void pause() {
        System.out.print("\nType 0 to go back: ");
        while (!scanner.nextLine().equals("0")) {
            System.out.print("Type 0 to go back: ");
        }
    }
    
    private static void clearScreen() {
        System.out.print("\n\n");
    }
}