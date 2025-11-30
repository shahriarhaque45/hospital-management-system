package com.curalink.features;

import com.curalink.models.Patient;
import com.curalink.utils.SystemUtils;
import java.util.List;

public class ViewAllPatientsFeature implements Feature {
    private List<Patient> patientList;

    public ViewAllPatientsFeature(List<Patient> patientList) {
        this.patientList = patientList;
    }

    @Override
    public void execute() {
        SystemUtils.clearScreen();
        System.out.println("                                        ------ PATIENT LIST ------\n\n");
        for (Patient p : patientList) System.out.println("\n                    " + p);
        SystemUtils.pause();
    }
}
