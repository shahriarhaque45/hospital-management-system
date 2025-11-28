import java.util.ArrayList;
import java.util.List;

// Department class
public class Department {
    private String id;
    private String name;
    private String description;
    private String location;
    private List<String> doctors;
    private int capacity;

    // Constructor
    public Department(String id, String name, String description, String location) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.doctors = new ArrayList<>();
        this.capacity = 0;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getLocation() { return location; }
    public List<String> getDoctors() { return doctors; }
    public int getCapacity() { return capacity; }

    // Display department information
    public void displayInfo() {
        System.out.println("\n========== DEPARTMENT INFORMATION ==========");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Description: " + description);
        System.out.println("Location: " + location);
        System.out.println("Number of Doctors: " + doctors.size());
        System.out.println("Capacity: " + capacity);
        System.out.println("==========================================\n");
    }

    // Add a doctor to the department
    public boolean addDoctor(String doctorId) {
        if (!doctors.contains(doctorId)) {
            doctors.add(doctorId);
            return true;
        }
        return false;
    }

    // Remove a doctor from the department
    public boolean removeDoctor(String doctorId) {
        return doctors.remove(doctorId);
    }

    // Set department capacity
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // toString
    @Override
    public String toString() {
        return "[" + id + "] " + name + " - Location: " + location;
    }
}

