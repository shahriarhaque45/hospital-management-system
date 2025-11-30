# CuraLink Hospital Management System

## Description

CuraLink is a simple, command-line based hospital management system written in Java. It provides basic functionalities for managing staff, patients, and hospital utilities. The system is designed with a modular structure, separating concerns into different packages for models, features, and data management.

## Features

- **Staff Management**:
  - Add new staff members (Doctors, Nurses).
  - View a formatted list of all staff.
  - View the current activity of all staff members.

- **Patient Management**:
  - Register new patients.
  - View a list of all admitted patients.
  - View the current status of all patients.
  - Discharge a patient and generate a final bill.

- **Utility Management**:
  - View general hospital statistics (staff/patient counts, ratios).
  - Check bed availability.
  - Perform a global search for any person (staff or patient) by ID or by name/age.

- **Data Persistence**:
  - The application state (staff and patient lists) is automatically saved to `database/curalink.dat` upon exit.
  - On startup, the application loads data from the save file if it exists.

## Project Structure

The project is organized into several packages to maintain a clean and modular architecture:

- `com.curalink.management`: Contains the main application entry point (`CuraLink.java`).
- `com.curalink.models`: Defines the core data models (`Person`, `Patient`, `Doctor`, `Nurse`).
- `com.curalink.features`: Each class represents a specific user-selectable feature (e.g., `RegisterPatientFeature`).
- `com.curalink.managers`: Contains classes that manage the different UI panels (Staff, Patient, Utility).
- `com.curalink.data`: Handles all data persistence, including saving and loading the application state.
- `com.curalink.utils`: Includes utility classes, such as `SystemUtils` for console I/O.

## How to Run

### Using the Script (for Linux/macOS)

A shell script `run.sh` is provided to compile and run the project automatically.

1.  **Make the script executable (if it's not already):**
    ```bash
    chmod +x run.sh
    ```

2.  **Run the script:**
    ```bash
    ./run.sh
    ```

### Using the Script (for Windows)

A batch script `run.bat` is provided to compile and run the project automatically. Simply navigate to the project's root directory and execute the script.

1.  **Run from Command Prompt:**
    ```batch
    run.bat
    ```

2.  **Or, run by double-clicking the `run.bat` file in File Explorer.**

### Manual Compilation and Execution

If you prefer to compile and run the project manually, you can use the following commands from the project's root directory.

1.  **Compile the source code:**
    ```bash
    javac -d bin --source-path src src/com/curalink/management/CuraLink.java
    ```

2.  **Run the application:**
    ```bash
    java -cp bin com.curalink.management.CuraLink
    ```

## Data Storage

The application stores its data in the `database` directory:

- `database/curalink.dat`: This is the primary save file where all current staff and patient data is stored when you exit the application.
