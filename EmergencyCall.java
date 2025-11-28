import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

// EmergencyCall class
public class EmergencyCall {
    private String id;
    private String callerName;
    private String callerPhone;
    private String location;
    private String emergencyType; // Accident, Heart Attack, etc.
    private String description;
    private String status; // Pending, Dispatched, Completed, Cancelled
    private String assignedAmbulanceId;
    private String callTime;
    private Integer responseTime; // in minutes
    private String priority; // High, Medium, Low

    // Constructor
    public EmergencyCall(String id, String callerName, String callerPhone, String location, 
                         String emergencyType, String description) {
        this.id = id;
        this.callerName = callerName;
        this.callerPhone = callerPhone;
        this.location = location;
        this.emergencyType = emergencyType;
        this.description = description;
        this.status = "Pending";
        this.assignedAmbulanceId = null;
        this.callTime = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
        this.responseTime = null;
        this.priority = "High";
    }

    // Getters
    public String getId() { return id; }
    public String getCallerName() { return callerName; }
    public String getCallerPhone() { return callerPhone; }
    public String getLocation() { return location; }
    public String getEmergencyType() { return emergencyType; }
    public String getDescription() { return description; }
    public String getStatus() { return status; }
    public String getAssignedAmbulanceId() { return assignedAmbulanceId; }
    public String getCallTime() { return callTime; }
    public Integer getResponseTime() { return responseTime; }
    public String getPriority() { return priority; }

    // Display emergency call information
    public void displayInfo() {
        System.out.println("\n========== EMERGENCY CALL INFORMATION ==========");
        System.out.println("ID: " + id);
        System.out.println("Caller: " + callerName);
        System.out.println("Phone: " + callerPhone);
        System.out.println("Location: " + location);
        System.out.println("Emergency Type: " + emergencyType);
        System.out.println("Description: " + description);
        System.out.println("Priority: " + priority);
        System.out.println("Status: " + status);
        System.out.println("Call Time: " + callTime);
        if (assignedAmbulanceId != null) {
            System.out.println("Assigned Ambulance: " + assignedAmbulanceId);
        }
        if (responseTime != null) {
            System.out.println("Response Time: " + responseTime + " minutes");
        }
        System.out.println("================================================\n");
    }

    // Assign ambulance to emergency call
    public void assignAmbulance(String ambulanceId) {
        this.assignedAmbulanceId = ambulanceId;
        this.status = "Dispatched";
    }

    // Update call status
    public boolean updateStatus(String status) {
        String[] validStatuses = {"Pending", "Dispatched", "Completed", "Cancelled"};
        for (String validStatus : validStatuses) {
            if (validStatus.equals(status)) {
                this.status = status;
                return true;
            }
        }
        return false;
    }

    // Set priority level
    public boolean setPriority(String priority) {
        String[] validPriorities = {"High", "Medium", "Low"};
        for (String validPriority : validPriorities) {
            if (validPriority.equals(priority)) {
                this.priority = priority;
                return true;
            }
        }
        return false;
    }

    // Calculate and set response time
    public void setResponseTime() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime callDateTime = LocalDateTime.parse(callTime, DateTimeFormatter.ISO_DATE_TIME);
        this.responseTime = (int) Duration.between(callDateTime, now).toMinutes();
    }

    // toString
    @Override
    public String toString() {
        String amb = (assignedAmbulanceId == null) ? "None" : assignedAmbulanceId;
        return "[" + id + "] " + emergencyType + " at " + location + 
               " | Caller: " + callerName + " | Status: " + status + " | Ambulance: " + amb;
    }
}

