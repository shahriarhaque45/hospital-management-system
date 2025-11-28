// Inheritance
public class Patient extends Person {
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