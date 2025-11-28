import java.util.ArrayList;
import java.util.List;

// Nurse class - inherits from Person
public class Nurse extends Person {
    private String licenseNumber;
    private String departmentId;
    private String shift; // Morning, Evening, Night
    private List<String> assignedPatients;
    private String availability;
    private int yearsOfExperience;

    // Constructor
    public Nurse(String id, String name, int age, String gender, String phoneNumber, 
                 String address, String licenseNumber, String departmentId, String shift) {
        super(id, name, age, gender, phoneNumber, address);
        this.licenseNumber = licenseNumber;
        this.departmentId = departmentId;
        this.shift = shift;
        this.assignedPatients = new ArrayList<>();
        this.availability = "Available";
        this.yearsOfExperience = 0;
    }

    // Getters
    public String getLicenseNumber() { return licenseNumber; }
    public String getDepartmentId() { return departmentId; }
    public String getShift() { return shift; }
    public List<String> getAssignedPatients() { return assignedPatients; }
    public String getAvailability() { return availability; }
    public int getYearsOfExperience() { return yearsOfExperience; }

    // Override displayInfo to include nurse-specific details
    @Override
    public void displayInfo() {
        System.out.println("\n========== NURSE INFORMATION ==========");
        super.displayInfo();
        System.out.println("License Number: " + licenseNumber);
        System.out.println("Department ID: " + departmentId);
        System.out.println("Shift: " + shift);
        System.out.println("Years of Experience: " + yearsOfExperience);
        System.out.println("Availability: " + availability);
        System.out.println("Assigned Patients: " + assignedPatients.size());
        System.out.println("=======================================\n");
    }

    // Assign a patient to the nurse
    public boolean assignPatient(String patientId) {
        if (!assignedPatients.contains(patientId)) {
            assignedPatients.add(patientId);
            return true;
        }
        return false;
    }

    // Remove patient assignment
    public boolean unassignPatient(String patientId) {
        return assignedPatients.remove(patientId);
    }

    // Update availability status
    public void updateAvailability(String status) {
        this.availability = status;
    }

    // Set years of experience
    public void setExperience(int years) {
        this.yearsOfExperience = years;
    }

    // Change shift
    public boolean changeShift(String newShift) {
        String[] validShifts = {"Morning", "Evening", "Night"};
        for (String validShift : validShifts) {
            if (validShift.equals(newShift)) {
                this.shift = newShift;
                return true;
            }
        }
        return false;
    }

    // Abstract method implementation
    @Override
    public void performRole() {
        System.out.println("Nurse " + getName() + " is on " + shift + " shift checking vitals.");
    }

    // Override toString
    @Override
    public String toString() {
        return super.toString() + " - [Nurse: " + shift + " Shift]";
    }
}

