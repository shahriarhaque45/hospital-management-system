public class Patient extends Person {
    private String illness;
    
    public Patient(String id, String name, int age, String illness) {
        super(id, name, age);
        this.illness = illness;
    }
    
    @Override
    public void performRole() {
        System.out.println("                     > Patient " + getName() + " is recovering from " + illness);
    }
    
    @Override
    public String toString() {
        return super.toString() + " - Complaint: " + illness;
    }
}