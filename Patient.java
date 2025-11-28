import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Patient class - inherits from Person
public class Patient extends Person {
    private String bloodType;
    private List<MedicalHistoryEntry> medicalHistory;
    private List<String> appointments;
    private String registrationDate;

    // Inner class for medical history entries
    public static class MedicalHistoryEntry {
        private String date;
        private String entry;

        public MedicalHistoryEntry(String date, String entry) {
            this.date = date;
            this.entry = entry;
        }

        public String getDate() { return date; }
        public String getEntry() { return entry; }
    }

    // Constructor
    public Patient(String id, String name, int age, String gender, String phoneNumber, 
                   String address, String bloodType) {
        super(id, name, age, gender, phoneNumber, address);
        this.bloodType = bloodType;
        this.medicalHistory = new ArrayList<>();
        this.appointments = new ArrayList<>();
        this.registrationDate = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
    }

    // Getters
    public String getBloodType() { return bloodType; }
    public List<MedicalHistoryEntry> getMedicalHistory() { return medicalHistory; }
    public List<String> getAppointments() { return appointments; }
    public String getRegistrationDate() { return registrationDate; }

    // Override displayInfo to include patient-specific details
    @Override
    public void displayInfo() {
        System.out.println("\n========== PATIENT INFORMATION ==========");
        super.displayInfo();
        System.out.println("Blood Type: " + bloodType);
        System.out.println("Registration Date: " + registrationDate.substring(0, 10));
        System.out.println("Number of Appointments: " + appointments.size());
        System.out.println("=========================================\n");
    }

    // Add medical history entry
    public void addMedicalHistory(String entry) {
        String date = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
        medicalHistory.add(new MedicalHistoryEntry(date, entry));
    }

    // Display medical history
    public void displayMedicalHistory() {
        System.out.println("\n--- Medical History ---");
        if (medicalHistory.isEmpty()) {
            System.out.println("No medical history recorded.");
        } else {
            for (int i = 0; i < medicalHistory.size(); i++) {
                MedicalHistoryEntry record = medicalHistory.get(i);
                System.out.println((i + 1) + ". [" + record.getDate().substring(0, 10) + "] " + record.getEntry());
            }
        }
    }

    // Add appointment
    public void addAppointment(String appointmentId) {
        appointments.add(appointmentId);
    }

    // Abstract method implementation
    @Override
    public void performRole() {
        System.out.println("Patient " + getName() + " is receiving treatment.");
    }
}

