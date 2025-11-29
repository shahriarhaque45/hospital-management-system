public class Nurse extends Person {
    private String shift;

    public Nurse(String id, String name, int age, String shift) {
        super(id, name, age);
        this.shift = shift;
    }
    
    @Override
    public void performRole() {
        System.out.println("                     > Nurse " + getName() + " is on " + shift + " shift checking vitals.");
    }

    @Override
    public String toString() {
        return super.toString() + " - [Nurse: " + shift + " Shift]";
    }
}