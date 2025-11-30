package com.curalink.features;

import com.curalink.models.Doctor;
import com.curalink.models.Nurse;
import com.curalink.models.Patient;
import com.curalink.models.Person;
import com.curalink.utils.SystemUtils;
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
        System.out.println("\t\t\t\t\t------ HOSPITAL STATISTICS ------\n\n");
        
        int doctorCount = 0;
        int nurseCount = 0;
        
        for (Person p : staffList) {
            if (p instanceof Doctor) doctorCount++;
            else if (p instanceof Nurse) nurseCount++;
        }
        
        int patientCount = patientList.size();
        
        System.out.println("\t\t\t\t\tTotal Doctors   : " + doctorCount);
        System.out.println("\t\t\t\t\tTotal Nurses    : " + nurseCount);
        System.out.println("\t\t\t\t\tTotal Patients  : " + patientCount);
        System.out.println("\t\t\t\t\t-------------------------");
        System.out.println("\t\t\t\t\tTotal People    : " + (doctorCount + nurseCount + patientCount));
        
        if (patientCount > 0 && doctorCount > 0) {
            float ratio = (float)patientCount / doctorCount;
            if (ratio == (int)ratio) {
                System.out.println("\t\t\t\t\tDoctor/Patient Ratio: 1:" + (int)ratio);
            } else {
                System.out.printf("\t\t\t\t\tDoctor/Patient Ratio: 1:%.1f\n", ratio);
            }
        } else {
            System.out.println("\t\t\t\t\tDoctor/Patient Ratio: N/A (Insufficient Data)");
        }
        SystemUtils.pause();
    }
}
