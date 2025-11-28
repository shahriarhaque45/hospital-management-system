import java.util.ArrayList;
import java.util.List;

// Doctor class - inherits from Person
public class Doctor extends Person {
    private String specialization;
    private String licenseNumber;
    private String departmentId;
    private List<String> appointments;
    private String availability;
    private int yearsOfExperience;

    // Constructor
    public Doctor(String id, String name, int age, String gender, String phoneNumber, 
                  String address, String specialization, String licenseNumber, String departmentId) {
        super(id, name, age, gender, phoneNumber, address);
        this.specialization = specialization;
        this.licenseNumber = licenseNumber;
        this.departmentId = departmentId;
        this.appointments = new ArrayList<>();
        this.availability = "Available";
        this.yearsOfExperience = 0;
    }

    // Getters
    public String getSpecialization() { return specialization; }
    public String getLicenseNumber() { return licenseNumber; }
    public String getDepartmentId() { return departmentId; }
    public List<String> getAppointments() { return appointments; }
    public String getAvailability() { return availability; }
    public int getYearsOfExperience() { return yearsOfExperience; }

    // Setters
    public void setDepartmentId(String departmentId) { this.departmentId = departmentId; }

    // Override displayInfo to include doctor-specific details
    @Override
    public void displayInfo() {
        System.out.println("\n========== DOCTOR INFORMATION ==========");
        super.displayInfo();
        System.out.println("Specialization: " + specialization);
        System.out.println("License Number: " + licenseNumber);
        System.out.println("Department ID: " + departmentId);
        System.out.println("Years of Experience: " + yearsOfExperience);
        System.out.println("Availability: " + availability);
        System.out.println("Number of Appointments: " + appointments.size());
        System.out.println("========================================\n");
    }

    // Update availability status
    public void updateAvailability(String status) {
        this.availability = status;
    }

    // Set years of experience
    public void setExperience(int years) {
        this.yearsOfExperience = years;
    }

    // Add appointment
    public void addAppointment(String appointmentId) {
        appointments.add(appointmentId);
    }

    // Abstract method implementation
    @Override
    public void performRole() {
        System.out.println("Doctor " + getName() + " (" + specialization + ") is seeing patients.");
    }

    // Override toString
    @Override
    public String toString() {
        return super.toString() + " - [Doctor: " + specialization + "]";
    }
}

