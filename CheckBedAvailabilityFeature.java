import java.util.List;

public class CheckBedAvailabilityFeature implements Feature {
    private List<Patient> patientList;
    private int maxBeds;

    public CheckBedAvailabilityFeature(List<Patient> patientList, int maxBeds) {
        this.patientList = patientList;
        this.maxBeds = maxBeds;
    }

    @Override
    public void execute() {
        SystemUtils.clearScreen();
        System.out.println("------ BED AVAILABILITY ------\n\n");
        int occupied = patientList.size();
        int available = maxBeds - occupied;
        
        System.out.println("Max Capacity : " + maxBeds);
        System.out.println("Occupied     : " + occupied);
        System.out.println("Available    : " + available);
        
        if (available == 0) {
            System.out.println("\nWARNING: No beds available!");
        } else if (available < 5) {
            System.out.println("\nALERT: Hospital is reaching capacity.");
        } else {
            System.out.println("\nStatus: Normal capacity.");
        }
        SystemUtils.pause();
    }
}