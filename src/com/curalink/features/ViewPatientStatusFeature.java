package com.curalink.features;

import com.curalink.models.Patient;
import com.curalink.utils.SystemUtils;
import java.util.List;

public class ViewPatientStatusFeature implements Feature {
    private List<Patient> patientList;

    public ViewPatientStatusFeature(List<Patient> patientList) {
        this.patientList = patientList;
    }

    @Override
    public void execute() {
        SystemUtils.clearScreen();
        System.out.println("\t\t\t\t\t------ PATIENT STATUS ------\n\n");
        for (Patient p : patientList) {
            p.performRole();
        }
        SystemUtils.pause();
    }
}
