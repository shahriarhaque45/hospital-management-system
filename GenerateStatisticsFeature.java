import java.util.List;

public class GenerateStatisticsFeature implements Feature {
    private List<Person> staffList;
    private List<Patient> patientList;

    public GenerateStatisticsFeature(List<Person> staffList, List<Patient> patientList) {
        this.staffList = staffList;
        this.patientList = patientList;
    }

    @Override
    public void execute() {
        SystemUtils.clearScreen();
        System.out.println("------ HOSPITAL STATISTICS ------\n\n");
        
        int doctorCount = 0;
        int nurseCount = 0;
        
        for (Person p : staffList) {
            if (p instanceof Doctor) doctorCount++;
            else if (p instanceof Nurse) nurseCount++;
        }
        
        int patientCount = patientList.size();
        
        System.out.println("Total Doctors   : " + doctorCount);
        System.out.println("Total Nurses    : " + nurseCount);
        System.out.println("Total Patients  : " + patientCount);
        System.out.println("-------------------------");
        System.out.println("Total People    : " + (doctorCount + nurseCount + patientCount));
        
        if (patientCount > 0 && doctorCount > 0) {
            float ratio = (float)patientCount / doctorCount;
            if (ratio == (int)ratio) {
                System.out.println("Doctor/Patient Ratio: 1:" + (int)ratio);
            } else {
                System.out.printf("Doctor/Patient Ratio: 1:%.1f\n", ratio);
            }
        } else {
            System.out.println("Doctor/Patient Ratio: N/A (Insufficient Data)");
        }
        SystemUtils.pause();
    }
}