import java.util.ArrayList;
import java.util.List;

public class HospitalManagementSystem {
    
    private static List<Person> staffList = new ArrayList<>();
    private static List<Patient> patientList = new ArrayList<>();
    private static final int MAX_BEDS = 50; 

    public static void main(String[] args) {
        initializeData();
        
        StaffManager staffManager = new StaffManager(staffList);
        PatientManager patientManager = new PatientManager(patientList);
        UtilityManager utilityManager = new UtilityManager(staffList, patientList, MAX_BEDS);

        boolean running = true;
        while (running) {
            SystemUtils.clearScreen();
            System.out.println("                                        ------------------------------------------");
            System.out.println("                                              HOSPITAL MANAGEMENT SYSTEM");
            System.out.println("                                        ------------------------------------------\n\n");
            
            System.out.println("                                                  1. Staff Management\n");
            System.out.println("                                                  2. Patient Management\n");
            System.out.println("                                                  3. Utility Management\n\n");
            System.out.println("                                                  4. Exit System\n\n");
            
            System.out.println("                                        ------------------------------------------");
            
            int choice = SystemUtils.readInt("                                        Enter Main Menu Choice: ");

            switch (choice) {
                case 1: staffManager.showPanel(); break;
                case 2: patientManager.showPanel(); break;
                case 3: utilityManager.showPanel(); break;
                case 4: 
                    running = false; 
                    System.out.println("\n                                        System Exiting.");
                    break;
                default: System.out.println("                                        Invalid Choice!"); SystemUtils.pause();
            }
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

    private static class StaffManager {
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

    private static class PatientManager {
        private List<Patient> patientList;

        public PatientManager(List<Patient> patientList) {
            this.patientList = patientList;
        }

        public void showPanel() {
            boolean back = false;
            while (!back) {
                SystemUtils.clearScreen();
                System.out.println("                                        ------ PATIENT MANAGEMENT PANEL ------\n\n");
                
                System.out.println("                                                  1. Register New Patient\n");
                System.out.println("                                                  2. View All Patients\n");
                System.out.println("                                                  3. View Patients Status\n");
                System.out.println("                                                  4. Discharge Patient\n\n");
                System.out.println("                                                  5. Back to Main Menu\n\n");
                
                int choice = SystemUtils.readInt("                                        Enter Choice: ");
                
                switch (choice) {
                    case 1: new RegisterPatientFeature(patientList).execute(); break;
                    case 2: new ViewAllPatientsFeature(patientList).execute(); break;
                    case 3: new ViewPatientStatusFeature(patientList).execute(); break;
                    case 4: new DischargePatientFeature(patientList).execute(); break;
                    case 5: back = true; break;
                    default: System.out.println("                                        Invalid option."); SystemUtils.pause();
                }
            }
        }
    }

    private static class UtilityManager {
        private List<Person> staffList;
        private List<Patient> patientList;
        private int maxBeds;

        public UtilityManager(List<Person> staffList, List<Patient> patientList, int maxBeds) {
            this.staffList = staffList;
            this.patientList = patientList;
            this.maxBeds = maxBeds;
        }

        public void showPanel() {
            boolean back = false;
            while (!back) {
                SystemUtils.clearScreen();
                System.out.println("                                        ------ UTILITY MANAGEMENT PANEL ------\n\n");
                
                System.out.println("                                                  1. General Statistics\n");
                System.out.println("                                                  2. Check Bed Availability\n");
                System.out.println("                                                  3. Global Search\n\n");
                System.out.println("                                                  4. Back to Main Menu\n\n");

                int choice = SystemUtils.readInt("                                        Enter Choice: ");

                switch (choice) {
                    case 1: new GenerateStatisticsFeature(staffList, patientList).execute(); break;
                    case 2: new CheckBedAvailabilityFeature(patientList, maxBeds).execute(); break;
                    case 3: new GlobalSearchFeature(staffList, patientList).execute(); break;
                    case 4: back = true; break;
                    default: System.out.println("                                        Invalid option."); SystemUtils.pause();
                }
            }
        }
    }
}