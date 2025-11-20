import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Person {
    
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

    public abstract void performRole();
    
    @Override
    public String toString() {
        return "[" + id + "] " + name + " (" + age + " yrs)";
    }
}

class Doctor extends Person {
    private String specialization;

    public Doctor(String id, String name, int age, String specialization) {
        super(id, name, age);
        this.specialization = specialization;
    }

    @Override
    public void performRole() {
        System.out.println("Doctor " + getName() + " (" + specialization + ") is seeing patients.");
    }

    public void diagnosePatient(Patient p, String disease) {
        System.out.println("Dr. " + getName() + " has diagnosed " + p.getName() + " with " + disease);
        p.setDiagnosis(disease);
    }
}

class Nurse extends Person {
    private String shift;

    public Nurse(String id, String name, int age, String shift) {
        super(id, name, age);
        this.shift = shift;
    }

    @Override
    public void performRole() {
        System.out.println("Nurse " + getName() + " is on " + shift + " shift checking vitals.");
    }
}

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

    @Override
    public void performRole() {
        System.out.println("Patient " + getName() + " is recovering from " + illness);
    }

    // Specific methods for Patient
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    
    public String getDiagnosis() { return diagnosis; }
    
    @Override
    public String toString() {
        return super.toString() + " - Complaint: " + illness + " | Diagnosis: " + diagnosis;
    }
}

class HospitalUtils {
    
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

class HospitalBilling {

    public void generateBill(Patient p, double amount) {
        System.out.println("\n--- FINAL BILL ---");
        System.out.println("Patient: " + p.getName());
        System.out.println("Total Amount: $" + amount);
    }

    public void generateBill(Patient p, double amount, double insuranceCoverage) {
        System.out.println("\n--- FINAL BILL (INSURANCE APPLIED) ---");
        System.out.println("Patient: " + p.getName());
        System.out.println("Base Amount: $" + amount);
        System.out.println("Insurance Paid: -$" + insuranceCoverage);
        System.out.println("Patient Pays: $" + (amount - insuranceCoverage));
    }
}

public class HospitalManagementSystem {
    private static List<Person> staffList = new ArrayList<>();
    private static List<Patient> patientList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
    
        staffList.add(new Doctor("D001", "Rahmina Akhter", 45, "Cardiology"));
        staffList.add(new Doctor("D002", "Sharif Hossain", 50, "Neurology"));
        staffList.add(new Doctor("D003", "Syeda Ishrat", 35, "Dermatologist"));
        staffList.add(new Doctor("D004", "Md. Mizanur Rahman", 61, "General Physician"));
        staffList.add(new Nurse("N001", "Hafisa Naznin", 29, "Night"));
        staffList.add(new Nurse("N002", "Nasrin Farjana", 25, "Night"));
        staffList.add(new Nurse("N003", "Samira Shifa", 24, "Day"));
        staffList.add(new Nurse("N004", "Yusuf Hamid", 28, "Day"));
        
        patientList.add(new Patient("P001", "Ahmed Shafi", 30, "Dengue"));

        boolean running = true;
        while (running) {
            System.out.println("\n    HOSPITAL MANAGEMENT SYSTEM    ");
            System.out.println("                                    ");
            System.out.println("1. Register New Patient");
            System.out.println("2. View All Staff");
            System.out.println("3. View All Patients");
            System.out.println("4. Doctor Diagnosis");
            System.out.println("5. Generate Bil");
            System.out.println("6. Search Person");
            System.out.println("7. Exit");
            System.out.print("Enter Choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerPatient();
                    break;
                case 2:
                    viewStaff();
                    break;
                case 3:
                    viewPatients();
                    break;
                case 4:
                    performDiagnosis();
                    break;
                case 5:
                    billingProcess();
                    break;
                case 6:
                    searchSystem();
                    break;
                case 7:
                    running = false;
                    System.out.println("System Exiting...");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    private static void registerPatient() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Illness: ");
        String illness = scanner.nextLine();
        
        String id = "P" + (patientList.size() + 101); // Auto-ID
        Patient newPatient = new Patient(id, name, age, illness);
        patientList.add(newPatient);
        System.out.println("Patient Registered Successfully! ID: " + id);
    }

    private static void viewStaff() {
        System.out.println("\n--- STAFF ON DUTY ---");
        for (Person p : staffList) {
            p.performRole(); 
        }
    }

    private static void viewPatients() {
        System.out.println("\n--- ADMITTED PATIENTS ---");
        for (Patient p : patientList) {
            System.out.println(p);
        }
    }

    private static void performDiagnosis() {
        System.out.print("Enter Patient ID: ");
        String pId = scanner.nextLine();
        Patient p = (Patient) HospitalUtils.findPerson(new ArrayList<>(patientList), pId);

        if (p != null) {
            System.out.print("Enter Doctor ID: ");
            String dId = scanner.nextLine();
            Person staff = HospitalUtils.findPerson(staffList, dId);
            
            if (staff instanceof Doctor) {
                System.out.print("Enter Diagnosis Details: ");
                String diagnosis = scanner.nextLine();
                ((Doctor) staff).diagnosePatient(p, diagnosis);
            } else {
                System.out.println("Invalid Doctor ID.");
            }
        } else {
            System.out.println("Patient not found.");
        }
    }

    private static void billingProcess() {
        System.out.print("Enter Patient ID: ");
        String id = scanner.nextLine();
        Patient p = (Patient) HospitalUtils.findPerson(new ArrayList<>(patientList), id);

        if (p != null) {
            HospitalBilling billing = new HospitalBilling();
            System.out.print("Enter Bill Amount: ");
            double amount = scanner.nextDouble();
            
            System.out.print("Has Insurance? (true/false): ");
            boolean hasInsurance = scanner.nextBoolean();
            
            if (hasInsurance) {
                System.out.print("Enter Insurance Coverage Amount: ");
                double coverage = scanner.nextDouble();
                billing.generateBill(p, amount, coverage);
            } else {
                billing.generateBill(p, amount);
            }
        } else {
            System.out.println("Patient not found.");
        }
    }

    private static void searchSystem() {
        System.out.println("Search by: 1. ID  2. Name & Age");
        int choice = scanner.nextInt();
        scanner.nextLine();

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
            System.out.print("Enter Age: ");
            int age = scanner.nextInt();
            result = HospitalUtils.findPerson(allPeople, name, age);
        }

        if (result != null) {
            System.out.println("Found: " + result);
        } else {
            System.out.println("Person not found.");
        }
    }
}