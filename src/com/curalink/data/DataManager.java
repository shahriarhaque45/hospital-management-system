package com.curalink.data;

import com.curalink.models.Doctor;
import com.curalink.models.Nurse;
import com.curalink.models.Patient;
import com.curalink.models.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataManager {
    private static final String DB_DIR = "database";
    private static final String SAVE_FILE = DB_DIR + "/curalink.dat";
    private static final String DEFAULT_FILE = DB_DIR + "/default.dat";

    public static void saveData(List<Person> staffList, List<Patient> patientList) {
        Map<String, List<?>> data = new HashMap<>();
        data.put("staff", staffList);
        data.put("patients", patientList);
        saveDataObject(data, SAVE_FILE);
        System.out.println("Data saved successfully to " + SAVE_FILE);
    }

    public static Map<String, List<?>> loadPrimaryData() {
        File saveFile = new File(SAVE_FILE);
        if (saveFile.exists()) {
            System.out.println("Loading data from " + SAVE_FILE);
            return loadDataObject(SAVE_FILE);
        } else {
            System.out.println("No primary save file found. Starting with empty lists.");
            Map<String, List<?>> emptyData = new HashMap<>();
            emptyData.put("staff", new ArrayList<Person>());
            emptyData.put("patients", new ArrayList<Patient>());
            return emptyData;
        }
    }

    public static Map<String, List<?>> loadDefaultData() {
        File defaultFile = new File(DEFAULT_FILE);
        if (defaultFile.exists()) {
            System.out.println("Loading default data from " + DEFAULT_FILE);
            return loadDataObject(DEFAULT_FILE);
        } else {
            System.out.println("No default data file found. Creating and loading default data.");
            Map<String, List<?>> defaultData = createDefaultData();
            saveDataObject(defaultData, DEFAULT_FILE);
            return defaultData;
        }
    }

    private static Map<String, List<?>> createDefaultData() {
        Map<String, List<?>> data = new HashMap<>();
        List<Person> staffList = new ArrayList<>();
        List<Patient> patientList = new ArrayList<>();

        staffList.add(new Doctor("D001", "Dr. Anisur Rahman", 45, "Cardiology"));
        staffList.add(new Doctor("D002", "Dr. Fatema Begum", 50, "Neurology"));
        staffList.add(new Nurse("N001", "Shirin Akter", 29, "Night"));
        staffList.add(new Nurse("N002", "Rahim Uddin", 32, "Day"));
        
        patientList.add(new Patient("P001", "Rafiqul Islam", 30, "Chest Pain"));
        patientList.add(new Patient("P002", "Karim Ahmed", 45, "High Fever"));

        data.put("staff", staffList);
        data.put("patients", patientList);
        return data;
    }

    private static void saveDataObject(Map<String, List<?>> data, String filename) {
        try {
            File dbDirectory = new File(DB_DIR);
            if (!dbDirectory.exists()) {
                dbDirectory.mkdirs();
            }
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(data);
            oos.close();
        } catch (IOException e) {
            System.err.println("Error saving data to " + filename + ": " + e.getMessage());
        }
    }

    private static Map<String, List<?>> loadDataObject(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            @SuppressWarnings("unchecked")
            Map<String, List<?>> data = (Map<String, List<?>>) ois.readObject();
            return data;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading data from " + filename + ": " + e.getMessage());
            Map<String, List<?>> emptyData = new HashMap<>();
            emptyData.put("staff", new ArrayList<Person>());
            emptyData.put("patients", new ArrayList<Patient>());
            return emptyData;
        }
    }
}
