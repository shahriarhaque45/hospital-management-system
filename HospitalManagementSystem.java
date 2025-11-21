import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract class
abstract class Person {
    
    //Encapsulation
    private String id;
    private String name;
    private int age;

    public Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getId() { return id; }

    // Abstract method enforcing specific behavior in child classes
    public abstract void performRole();
    
    // Method Overriding - polymorphism
    @Override
    public String toString() {
        return "[" + id + "] " + name + " (" + age + " yrs)";
    }
}

// Inheritance
class Doctor extends Person {
    private String specialization;

    public Doctor(String id, String name, int age, String specialization) {
        super(id, name, age);
        this.specialization = specialization;
    }
    // Method Overriding - polymorphism
    @Override
    public void performRole() {
        System.out.println("Doctor " + getName() + " (" + specialization + ") is seeing patients.");
    }

    // Method Overriding - polymorphism
    @Override
    public String toString() {
        return super.toString() + " - [Doctor: " + specialization + "]";
    }

    public void diagnosePatient(Patient p, String disease) {
        System.out.println(getName() + " has diagnosed " + p.getName() + " with " + disease);
        p.setDiagnosis(disease);
    }
}

// Inheritance
class Nurse extends Person {
    private String shift;

    public Nurse(String id, String name, int age, String shift) {
        super(id, name, age);
        this.shift = shift;
    }
    
    // Method Overriding - polymorphism
    @Override
    public void performRole() {
        System.out.println("Nurse " + getName() + " is on " + shift + " shift checking vitals.");
    }

    // Method Overriding - polymorphism
    @Override
    public String toString() {
        return super.toString() + " - [Nurse: " + shift + " Shift]";
    }
}

// Inheritance
class Patient extends Person {
    private String illness;
    private String diagnosis;
    private boolean admitted;

    public Patient(String id, String name, int age, String illness) {
        super(id, name, age);
        this.illness = illness;
        this.admitted = true;
        this.diagnosis = "Pending";
    }
    
    // Method Overriding - polymorphism
    @Override
    public void performRole() {
        System.out.println("Patient " + getName() + " is recovering from " + illness);
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    
    public String getDiagnosis() { return diagnosis; }
    
    // Method Overriding - polymorphism
    @Override
    public String toString() {
        return super.toString() + " - Complaint: " + illness + " | Diagnosis: " + diagnosis;
    }
}

class HospitalUtils {
    
    // Search by ID (Method Overloading - polymorphism)
    public static Person findPerson(List<Person> people, String id) {
        for (Person p : people) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }

    // Search by name & age(Method Overloading - polymorphism)
    public static Person findPerson(List<Person> people, String name, int age) {
        for (Person p : people) {
            if (p.getName().equalsIgnoreCase(name) && p.getAge() == age) {
                return p;
            }
        }
        return null;
    }
}

class HospitalBilling {
    //Option 7: Generate and Shows specific bills

    // Standard Bill (Method Overloading - polymorphism)
    public void generateBill(Patient p, int amount) {
        System.out.println();
        System.out.println("                                                          --- FINAL BILL ---");
        System.out.println("                                                        Patient: " + p.getName());
        System.out.println("                                                        Total Amount: BDT " + amount);
    }

    // Discounted Bill (Method Overloading - polymorphism)
    public void generateBill(Patient p, int amount, int insuranceCoverage) {
        System.out.println();
        System.out.println("                                                          --- FINAL BILL (INSURANCE APPLIED) ---");
        System.out.println("                                                        Patient: " + p.getName());
        System.out.println("                                                        Base Amount: BDT " + amount);
        System.out.println("                                                        Insurance Paid: -BDT " + insuranceCoverage);
        System.out.println("                                                        Patient Pays: BDT " + (amount - insuranceCoverage));
    }
}

// Main class
public class HospitalManagementSystem {
    
    // polymorphism in stafflist  
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
        
        // loop for menu
        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("                                                        ------------------------------------------");
            System.out.println("                                                        ---     HOSPITAL MANAGEMENT SYSTEM     ---");
            System.out.println("                                                        ------------------------------------------");
            System.out.println("                                                        1. Register New Patient");
            System.out.println("                                                        2. View Staff Details");
            System.out.println("                                                        3. View Staff Activity");
            System.out.println("                                                        4. View Patient Activity");
            System.out.println("                                                        5. View All Patients");
            System.out.println("                                                        6. Doctor Diagnosis");
            System.out.println("                                                        7. Generate Bill");
            System.out.println("                                                        8. Search Patient");
            System.out.println("                                                        9. Exit");
            System.out.println("                                                        ------------------------------------------");
            System.out.print("                                                        Enter Choice: ");
            
            String input = scanner.nextLine();
            int choice = -1;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("                                                        Invalid Input!");
                continue;
            }

            switch (choice) {
                case 1:
                    registerPatient();
                    break;
                case 2:
                    viewStaffDetails();
                    break;
                case 3:
                    viewStaffActivity();
                    break;
                case 4:
                    viewPatientActivity();
                    break;
                case 5:
                    viewPatients();
                    break;
                case 6:
                    performDiagnosis();
                    break;
                case 7:
                    billingProcess();
                    break;
                case 8:
                    searchSystem();
                    break;
                case 9:
                    // loop for menu exit
                    running = false;
                    System.out.println("                                                        System Exiting...");
                    break;
                default:
                    System.out.println("                                                        Invalid Choice!");
            }
        }
    }
    
    //Option 1: Patient registeration
    private static void registerPatient() {
        System.out.println();
        System.out.println("                                                               --- REGISTER PATIENT ---");
        
        System.out.print("                                                        Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("                                                        Enter Age: ");
        String ageStr = scanner.nextLine();
        int age;
        try {
            age = Integer.parseInt(ageStr);
        } catch (NumberFormatException e) {
            System.out.println("                                                        Invalid Age! Registration Cancelled.");
            return;
        }

        System.out.print("                                                        Enter Illness: ");
        String illness = scanner.nextLine();
        
        // Patient ID generation
        String id = String.format("P%03d", patientList.size() + 1); 
        
        Patient newPatient = new Patient(id, name, age, illness);
        patientList.add(newPatient);
        System.out.println("                                                        Patient Registered Successfully! ID: " + id);

        // Pause logic on success
        System.out.println();
        System.out.print("                                                        Type 0 to go back: ");
        while (!scanner.nextLine().equals("0")) {
            System.out.print("                                                        Type 0 to go back: ");
        }
    }

    // Option 2: Shows staff details
    private static void viewStaffDetails() {
        System.out.println();
        System.out.println("                                                                        --- STAFF DETAILS ---");
        for (Person p : staffList) {
            System.out.println("                                                        " + p);
        }
        // Pause logic
        System.out.println();
        System.out.print("                                                        Type 0 to go back: ");
        while (!scanner.nextLine().equals("0")) {
            System.out.print("                                                        Type 0 to go back: ");
        }
    }

    // Option 3: Shows staff specific activity
    private static void viewStaffActivity() {
        System.out.println();
        System.out.println("                                                                         --- STAFF ACTIVITY ---");
        for (Person p : staffList) {
            System.out.print("                                                        ");
            p.performRole(); 
        }
        // Pause logic
        System.out.println();
        System.out.print("                                                        Type 0 to go back: ");
        while (!scanner.nextLine().equals("0")) {
            System.out.print("                                                        Type 0 to go back: ");
        }
    }

    // Option 4: Shows Patient specific activity
    private static void viewPatientActivity() {
        System.out.println();
        System.out.println("                                                                       --- PATIENT ACTIVITY ---");
        for (Patient p : patientList) {
            System.out.print("                                                        ");
            p.performRole(); 
        }
        // Pause logic
        System.out.println();
        System.out.print("                                                        Type 0 to go back: ");
        while (!scanner.nextLine().equals("0")) {
            System.out.print("                                                        Type 0 to go back: ");
        }
    }
    
    // Option 5:Shows patient list
    private static void viewPatients() {
        System.out.println();
        System.out.println("                                                                                --- ADMITTED PATIENTS ---");
        for (Patient p : patientList) {
            System.out.println("                                                        " + p);
        }
        // Pause logic
        System.out.println();
        System.out.print("                                                        Type 0 to go back: ");
        while (!scanner.nextLine().equals("0")) {
            System.out.print("                                                        Type 0 to go back: ");
        }
    }

    // Option 6: Doctor performs diagnosis
    private static void performDiagnosis() {
        System.out.println();
        System.out.println("                                                                        --- DOCTOR DIAGNOSIS ---");
        
        System.out.print("                                                        Enter Patient ID: ");
        String pId = scanner.nextLine();

        Patient p = (Patient) HospitalUtils.findPerson(new ArrayList<>(patientList), pId);

        if (p != null) {
            System.out.print("                                                        Enter Doctor ID: ");
            String dId = scanner.nextLine();

            Person staff = HospitalUtils.findPerson(staffList, dId);
            
            if (staff instanceof Doctor) {
                System.out.print("                                                        Enter Diagnosis Details: ");
                String diagnosis = scanner.nextLine();

                System.out.print("                                                        ");
                ((Doctor) staff).diagnosePatient(p, diagnosis);
                
                // Pause logic on success
                System.out.println();
                System.out.print("                                                        Type 0 to go back: ");
                while (!scanner.nextLine().equals("0")) {
                    System.out.print("                                                        Type 0 to go back: ");
                }

            } else {
                System.out.println("                                                        Invalid Doctor ID or ID belongs to Nurse.");
                // Pause logic on error
                System.out.println();
                System.out.print("                                                        Type 0 to go back: ");
                while (!scanner.nextLine().equals("0"));
            }
        } else {
            System.out.println("                                                        Patient not found.");
            // Pause logic on error
            System.out.println();
            System.out.print("                                                        Type 0 to go back: ");
            while (!scanner.nextLine().equals("0"));
        }
    }

    private static void billingProcess() {
        
        System.out.print("                                                        Enter Patient ID: ");
        String id = scanner.nextLine();
        
        Patient p = (Patient) HospitalUtils.findPerson(new ArrayList<>(patientList), id);

        if (p != null) {
            HospitalBilling billing = new HospitalBilling();
            
            System.out.print("                                                        Enter Bill Amount: ");
            String amountStr = scanner.nextLine();
            
            int amount;
            try {
                amount = Integer.parseInt(amountStr);
            } catch (NumberFormatException e) {
                System.out.println("                                                        Invalid Amount! Billing Cancelled.");
                return;
            }
            
            System.out.print("                                                        Has Insurance? (true/false): ");
            String insuranceInput = scanner.nextLine();

            boolean hasInsurance = Boolean.parseBoolean(insuranceInput);
            
            if (hasInsurance) {
                System.out.print("                                                        Enter Insurance Coverage Amount: ");
                String coverageStr = scanner.nextLine();
                
                int coverage;
                try {
                    coverage = Integer.parseInt(coverageStr);
                } catch (NumberFormatException e) {
                    System.out.println("                                                        Invalid Coverage Amount! Billing Cancelled.");
                    return;
                }
                billing.generateBill(p, amount, coverage);
            } else {
                billing.generateBill(p, amount);
            }
            
            // Pause logic on success
            System.out.println();
            System.out.print("                                                        Type 0 to go back: ");
            while (!scanner.nextLine().equals("0")) {
                System.out.print("                                                        Type 0 to go back: ");
            }

        } else {
            System.out.println("                                                        Patient not found.");
            // Pause logic on error
            System.out.println();
            System.out.print("                                                        Type 0 to go back: ");
            while (!scanner.nextLine().equals("0"));
        }
    }
    
    //Option 8: Search Patients
    private static void searchSystem() {
        
        System.out.println();
        System.out.println("                                                                                        --- SEARCH PERSON ---");
        System.out.println("                                                        Search by: 1. ID  2. Name & Age");
        System.out.print("                                                        Enter Choice: ");
        String choiceStr = scanner.nextLine();

        int choice;
        try {
            choice = Integer.parseInt(choiceStr);
        } catch (NumberFormatException e) {
            System.out.println("                                                        Invalid Input!");
            return;
        }

        List<Person> allPeople = new ArrayList<>();
        allPeople.addAll(staffList);
        allPeople.addAll(patientList);

        Person result = null;

        if (choice == 1) {
            System.out.print("                                                        Enter ID: ");
            String id = scanner.nextLine();
            result = HospitalUtils.findPerson(allPeople, id);
        } else if (choice == 2) {
            System.out.print("                                                        Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("                                                        Enter Age: ");
            String ageStr = scanner.nextLine();
            
            int age;
            try {
                age = Integer.parseInt(ageStr);
            } catch (NumberFormatException e) {
                System.out.println("                                                        Invalid Age! Search Cancelled.");
                return;
            }
            result = HospitalUtils.findPerson(allPeople, name, age);
        }

        if (result != null) {
            System.out.println("                                                        Found: " + result);
        } else {
            System.out.println("                                                        Person not found.");
        }
        
        // Pause logic
        System.out.println();
        System.out.print("                                                        Type 0 to go back: ");
        while (!scanner.nextLine().equals("0")) {
            System.out.print("                                                        Type 0 to go back: ");
        }
    }
}