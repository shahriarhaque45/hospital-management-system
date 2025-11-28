import java.util.ArrayList;
import java.util.List;

// Ambulance class for emergency services
public class Ambulance {
    private String id;
    private String vehicleNumber;
    private String driverName;
    private String driverPhone;
    private String status; // Available, On Route, Busy
    private String currentLocation;
    private List<String> assignedParamedics;
    private List<String> emergencyCalls;

    // Constructor
    public Ambulance(String id, String vehicleNumber, String driverName, String driverPhone) {
        this.id = id;
        this.vehicleNumber = vehicleNumber;
        this.driverName = driverName;
        this.driverPhone = driverPhone;
        this.status = "Available";
        this.currentLocation = "Hospital";
        this.assignedParamedics = new ArrayList<>();
        this.emergencyCalls = new ArrayList<>();
    }

    // Getters
    public String getId() { return id; }
    public String getVehicleNumber() { return vehicleNumber; }
    public String getDriverName() { return driverName; }
    public String getDriverPhone() { return driverPhone; }
    public String getStatus() { return status; }
    public String getCurrentLocation() { return currentLocation; }
    public List<String> getAssignedParamedics() { return assignedParamedics; }
    public List<String> getEmergencyCalls() { return emergencyCalls; }

    // Display ambulance information
    public void displayInfo() {
        System.out.println("\n========== AMBULANCE INFORMATION ==========");
        System.out.println("ID: " + id);
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Driver: " + driverName);
        System.out.println("Driver Phone: " + driverPhone);
        System.out.println("Status: " + status);
        System.out.println("Current Location: " + currentLocation);
        System.out.println("Assigned Paramedics: " + assignedParamedics.size());
        System.out.println("Emergency Calls: " + emergencyCalls.size());
        System.out.println("===========================================\n");
    }

    // Update ambulance status
    public boolean updateStatus(String status) {
        String[] validStatuses = {"Available", "On Route", "Busy"};
        for (String validStatus : validStatuses) {
            if (validStatus.equals(status)) {
                this.status = status;
                return true;
            }
        }
        return false;
    }

    // Update current location
    public void updateLocation(String location) {
        this.currentLocation = location;
    }

    // Assign paramedic to ambulance
    public boolean assignParamedic(String paramedicName) {
        if (!assignedParamedics.contains(paramedicName)) {
            assignedParamedics.add(paramedicName);
            return true;
        }
        return false;
    }

    // Add emergency call record
    public void addEmergencyCall(String callDetails) {
        emergencyCalls.add(callDetails);
    }

    // toString
    @Override
    public String toString() {
        return "[" + id + "] Vehicle: " + vehicleNumber + " | Driver: " + driverName + 
               " | Status: " + status;
    }
}

