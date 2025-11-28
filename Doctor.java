// Inheritance
public class Doctor extends Person {
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