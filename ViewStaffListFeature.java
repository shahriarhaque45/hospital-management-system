import java.util.List;

public class ViewStaffListFeature implements Feature {
    private List<Person> staffList;

    public ViewStaffListFeature(List<Person> staffList) {
        this.staffList = staffList;
    }

    @Override
    public void execute() {
        SystemUtils.clearScreen();
        System.out.println("------ STAFF LIST ------\n\n");
        
        System.out.println("Doctors:");
        for (Person p : staffList) {
            if (p instanceof Doctor) System.out.println(p);
        }
        
        System.out.println("\nNurses:");
        for (Person p : staffList) {
            if (p instanceof Nurse) System.out.println(p);
        }
        SystemUtils.pause();
    }
}