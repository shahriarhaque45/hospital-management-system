import java.util.List;

public class ViewStaffActivityFeature implements Feature {
    private List<Person> staffList;

    public ViewStaffActivityFeature(List<Person> staffList) {
        this.staffList = staffList;
    }

    @Override
    public void execute() {
        SystemUtils.clearScreen();
        System.out.println("                                        ------ STAFF ACTIVITY ------\n\n");
        
        for (Person p : staffList) {
            if (p instanceof Doctor) {
                p.performRole();
            }
        }
        System.out.println(); 
        for (Person p : staffList) {
            if (p instanceof Nurse) {
                p.performRole();
            }
        }
        SystemUtils.pause();
    }
}