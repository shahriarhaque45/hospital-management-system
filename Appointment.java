import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Appointment class
public class Appointment {
    private String id;
    private String patientId;
    private String doctorId;
    private String date;
    private String time;
    private String reason;
    private String status; // Scheduled, Completed, Cancelled
    private String notes;
    private String createdAt;

    // Constructor
    public Appointment(String id, String patientId, String doctorId, String date, String time, String reason) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.time = time;
        this.reason = reason;
        this.status = "Scheduled";
        this.notes = "";
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
    }

    // Getters
    public String getId() { return id; }
    public String getPatientId() { return patientId; }
    public String getDoctorId() { return doctorId; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public String getReason() { return reason; }
    public String getStatus() { return status; }
    public String getNotes() { return notes; }
    public String getCreatedAt() { return createdAt; }

    // Display appointment information
    public void displayInfo() {
        System.out.println("\n========== APPOINTMENT INFORMATION ==========");
        System.out.println("ID: " + id);
        System.out.println("Patient ID: " + patientId);
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
        System.out.println("Reason: " + reason);
        System.out.println("Status: " + status);
        if (!notes.isEmpty()) {
            System.out.println("Notes: " + notes);
        }
        System.out.println("=============================================\n");
    }

    // Update appointment status
    public boolean updateStatus(String status) {
        String[] validStatuses = {"Scheduled", "Completed", "Cancelled"};
        for (String validStatus : validStatuses) {
            if (validStatus.equals(status)) {
                this.status = status;
                return true;
            }
        }
        return false;
    }

    // Add notes to appointment
    public void addNotes(String notes) {
        this.notes = notes;
    }

    // Reschedule appointment
    public void reschedule(String newDate, String newTime) {
        this.date = newDate;
        this.time = newTime;
    }

    // toString
    @Override
    public String toString() {
        return "[" + id + "] Patient: " + patientId + " | Doctor: " + doctorId + 
               " | Date: " + date + " " + time + " | Status: " + status;
    }
}

