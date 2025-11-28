import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

// MedicalRecord class for tracking patient medical records
public class MedicalRecord {
    private String id;
    private String patientId;
    private String doctorId;
    private String patientName;
    private String doctorName;
    private String date;
    private String symptoms;
    private String diagnosis;
    private List<Medication> prescribedMedications;
    private String treatmentPlan;
    private VitalSigns vitalSigns;
    private List<LabTest> labTests;
    private String notes;
    private String followUpDate;
    private String recordType; // General, Emergency, Surgery, etc.

    // Inner class for Medication
    public static class Medication {
        private String name;
        private String dosage;
        private String frequency;
        private String duration;

        public Medication(String name, String dosage, String frequency, String duration) {
            this.name = name;
            this.dosage = dosage;
            this.frequency = frequency;
            this.duration = duration;
        }

        public String getName() { return name; }
        public String getDosage() { return dosage; }
        public String getFrequency() { return frequency; }
        public String getDuration() { return duration; }
    }

    // Inner class for Vital Signs
    public static class VitalSigns {
        private String bloodPressure;
        private String temperature;
        private String heartRate;
        private String weight;
        private String height;

        public VitalSigns() {
            this.bloodPressure = "";
            this.temperature = "";
            this.heartRate = "";
            this.weight = "";
            this.height = "";
        }

        public void setBloodPressure(String bp) { this.bloodPressure = bp; }
        public void setTemperature(String temp) { this.temperature = temp; }
        public void setHeartRate(String hr) { this.heartRate = hr; }
        public void setWeight(String weight) { this.weight = weight; }
        public void setHeight(String height) { this.height = height; }

        public String getBloodPressure() { return bloodPressure; }
        public String getTemperature() { return temperature; }
        public String getHeartRate() { return heartRate; }
        public String getWeight() { return weight; }
        public String getHeight() { return height; }

        public boolean hasVitals() {
            return !bloodPressure.isEmpty() || !temperature.isEmpty() || 
                   !heartRate.isEmpty() || !weight.isEmpty() || !height.isEmpty();
        }
    }

    // Inner class for Lab Test
    public static class LabTest {
        private String name;
        private String result;
        private String date;

        public LabTest(String name, String result, String date) {
            this.name = name;
            this.result = result;
            this.date = date;
        }

        public String getName() { return name; }
        public String getResult() { return result; }
        public String getDate() { return date; }
    }

    // Constructor
    public MedicalRecord(String id, String patientId, String doctorId, String patientName, String doctorName) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.date = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
        this.symptoms = "";
        this.diagnosis = "";
        this.prescribedMedications = new ArrayList<>();
        this.treatmentPlan = "";
        this.vitalSigns = new VitalSigns();
        this.labTests = new ArrayList<>();
        this.notes = "";
        this.followUpDate = "";
        this.recordType = "General";
    }

    // Getters
    public String getId() { return id; }
    public String getPatientId() { return patientId; }
    public String getDoctorId() { return doctorId; }
    public String getPatientName() { return patientName; }
    public String getDoctorName() { return doctorName; }
    public String getDate() { return date; }
    public String getSymptoms() { return symptoms; }
    public String getDiagnosis() { return diagnosis; }
    public String getRecordType() { return recordType; }

    // Display medical record information
    public void displayInfo() {
        System.out.println("\n╔═══════════════════════════════════════════════════════╗");
        System.out.println("║           MEDICAL RECORD                              ║");
        System.out.println("╚═══════════════════════════════════════════════════════╝");
        System.out.println("Record ID: " + id);
        System.out.println("Patient: " + patientName + " (" + patientId + ")");
        System.out.println("Doctor: " + doctorName + " (" + doctorId + ")");
        System.out.println("Date: " + date.substring(0, 10));
        System.out.println("Record Type: " + recordType);
        
        if (!symptoms.isEmpty()) {
            System.out.println("\n--- Symptoms ---");
            System.out.println(symptoms);
        }
        
        if (!diagnosis.isEmpty()) {
            System.out.println("\n--- Diagnosis ---");
            System.out.println(diagnosis);
        }
        
        if (!prescribedMedications.isEmpty()) {
            System.out.println("\n--- Prescribed Medications ---");
            for (int i = 0; i < prescribedMedications.size(); i++) {
                Medication med = prescribedMedications.get(i);
                System.out.println((i + 1) + ". " + med.getName() + " - " + med.getDosage() + " (" + med.getFrequency() + ")");
                if (!med.getDuration().isEmpty()) {
                    System.out.println("   Duration: " + med.getDuration());
                }
            }
        }
        
        if (!treatmentPlan.isEmpty()) {
            System.out.println("\n--- Treatment Plan ---");
            System.out.println(treatmentPlan);
        }
        
        if (vitalSigns.hasVitals()) {
            System.out.println("\n--- Vital Signs ---");
            if (!vitalSigns.getBloodPressure().isEmpty()) 
                System.out.println("Blood Pressure: " + vitalSigns.getBloodPressure());
            if (!vitalSigns.getTemperature().isEmpty()) 
                System.out.println("Temperature: " + vitalSigns.getTemperature());
            if (!vitalSigns.getHeartRate().isEmpty()) 
                System.out.println("Heart Rate: " + vitalSigns.getHeartRate());
            if (!vitalSigns.getWeight().isEmpty()) 
                System.out.println("Weight: " + vitalSigns.getWeight());
            if (!vitalSigns.getHeight().isEmpty()) 
                System.out.println("Height: " + vitalSigns.getHeight());
        }
        
        if (!labTests.isEmpty()) {
            System.out.println("\n--- Lab Tests ---");
            for (int i = 0; i < labTests.size(); i++) {
                LabTest test = labTests.get(i);
                System.out.println((i + 1) + ". " + test.getName() + " - Result: " + test.getResult());
            }
        }
        
        if (!notes.isEmpty()) {
            System.out.println("\n--- Additional Notes ---");
            System.out.println(notes);
        }
        
        if (!followUpDate.isEmpty()) {
            System.out.println("\n--- Follow-up ---");
            System.out.println("Follow-up Date: " + followUpDate);
        }
        
        System.out.println("═══════════════════════════════════════════════════════\n");
    }

    // Set symptoms
    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    // Set diagnosis
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    // Add medication to prescription
    public void addMedication(String name, String dosage, String frequency, String duration) {
        prescribedMedications.add(new Medication(name, dosage, frequency, duration));
    }

    // Set treatment plan
    public void setTreatmentPlan(String plan) {
        this.treatmentPlan = plan;
    }

    // Update vital signs
    public void updateVitalSigns(String bloodPressure, String temperature, String heartRate, 
                                 String weight, String height) {
        if (bloodPressure != null && !bloodPressure.isEmpty()) 
            vitalSigns.setBloodPressure(bloodPressure);
        if (temperature != null && !temperature.isEmpty()) 
            vitalSigns.setTemperature(temperature);
        if (heartRate != null && !heartRate.isEmpty()) 
            vitalSigns.setHeartRate(heartRate);
        if (weight != null && !weight.isEmpty()) 
            vitalSigns.setWeight(weight);
        if (height != null && !height.isEmpty()) 
            vitalSigns.setHeight(height);
    }

    // Add lab test result
    public void addLabTest(String testName, String result, String testDate) {
        String date = (testDate == null || testDate.isEmpty()) ? 
                      LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME) : testDate;
        labTests.add(new LabTest(testName, result, date));
    }

    // Add notes
    public void addNotes(String notes) {
        this.notes = notes;
    }

    // Set follow-up date
    public void setFollowUpDate(String date) {
        this.followUpDate = date;
    }

    // Set record type
    public boolean setRecordType(String type) {
        String[] validTypes = {"General", "Emergency", "Surgery", "Consultation", "Follow-up", "Checkup"};
        for (String validType : validTypes) {
            if (validType.equals(type)) {
                this.recordType = type;
                return true;
            }
        }
        return false;
    }

    // Get summary
    public Map<String, String> getSummary() {
        Map<String, String> summary = new HashMap<>();
        summary.put("id", id);
        summary.put("patient", patientName);
        summary.put("doctor", doctorName);
        summary.put("date", date.substring(0, 10));
        summary.put("diagnosis", diagnosis.isEmpty() ? "Not specified" : diagnosis);
        summary.put("recordType", recordType);
        return summary;
    }

    // toString
    @Override
    public String toString() {
        return "[" + id + "] Patient: " + patientName + " | Doctor: " + doctorName + 
               " | Date: " + date.substring(0, 10) + " | Type: " + recordType;
    }
}

