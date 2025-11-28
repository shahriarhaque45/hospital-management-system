# 🏥 Hospital Management System

A comprehensive console-based Hospital Management System built with JavaScript using Object-Oriented Programming principles.

## 📋 Features

### Core Modules

1. **Patient Management**
   - Register new patients
   - View all patients
   - Search patients by ID
   - Update patient information
   - View medical history

2. **Doctor Management**
   - Add new doctors
   - View all doctors
   - Search doctors by specialization
   - Update doctor availability
   - Track doctor appointments

3. **Nurse Management**
   - Add new nurses
   - View nurses by shift (Morning/Evening/Night)
   - Assign patients to nurses
   - Update nurse availability
   - Track assigned patients

4. **Department Management**
   - Create departments
   - View department details
   - Track doctors per department
   - Manage department capacity

5. **Appointment Management**
   - Schedule appointments
   - View appointments by patient/doctor
   - Update appointment status
   - Track appointment history

6. **Ambulance & Emergency Services** 🚑
   - Add ambulances to fleet
   - Create emergency calls
   - Dispatch ambulances to emergencies
   - Track ambulance status and location
   - Priority-based emergency handling

7. **Billing Management**
   - Create patient bills
   - Add items to bills
   - Process payments (Cash/Card/Insurance)
   - View payment history
   - Track outstanding balances

8. **Medical Records Management** 📋
   - Create comprehensive medical records
   - Record symptoms and diagnosis
   - Prescribe medications with dosage
   - Track vital signs (BP, temperature, heart rate, etc.)
   - Add lab test results
   - Set treatment plans and follow-ups
   - View records by patient or doctor

9. **Reports & Statistics**
   - Patient statistics
   - Staff statistics
   - Appointment tracking
   - Emergency call metrics
   - Financial summaries

## 🎓 OOP Concepts Demonstrated

- **Inheritance**: `Patient`, `Doctor`, and `Nurse` classes inherit from `Person` base class
- **Encapsulation**: Data and methods are encapsulated within classes
- **Abstraction**: Complex hospital operations are abstracted into simple methods
- **Polymorphism**: Method overriding (e.g., `displayInfo()` in derived classes)

## 🏗️ Project Structure

```
hospital-management-system/
├── Person.js           # Base class for all people
├── Patient.js          # Patient class (inherits from Person)
├── Doctor.js           # Doctor class (inherits from Person)
├── Nurse.js            # Nurse class (inherits from Person)
├── Department.js       # Department management
├── Appointment.js      # Appointment handling
├── Ambulance.js        # Ambulance & Emergency Call classes
├── Billing.js          # Billing and payment management
├── MedicalRecord.js    # Medical records and patient history
├── HospitalSystem.js   # Main system manager
├── index.js            # Console interface & main entry point
├── package.json        # Project configuration
└── hospital_data.json  # Data persistence (auto-generated)
```

## 🚀 Installation & Setup

1. Make sure you have Node.js installed (version 14 or higher)
2. Navigate to the project directory
3. Run the application:

```bash
npm start
```

Or directly:

```bash
node index.js
```

## 💾 Data Persistence

All data is automatically saved to `hospital_data.json` file, ensuring your data persists between sessions.

## 🎯 Key Classes

### Person (Base Class)
- Properties: id, name, age, gender, phoneNumber, address
- Methods: displayInfo(), updateContactInfo()

### Patient (extends Person)
- Additional: bloodType, medicalHistory, appointments
- Methods: addMedicalHistory(), displayMedicalHistory()

### Doctor (extends Person)
- Additional: specialization, licenseNumber, departmentId
- Methods: updateAvailability(), setExperience()

### Nurse (extends Person)
- Additional: shift, assignedPatients
- Methods: assignPatient(), changeShift()

### Ambulance
- Properties: vehicleNumber, driverName, status, location
- Methods: updateStatus(), updateLocation(), assignParamedic()

### EmergencyCall
- Properties: callerName, location, emergencyType, priority
- Methods: assignAmbulance(), updateStatus(), setPriority()

### Billing
- Properties: patientId, items, totalAmount, paidAmount
- Methods: addItem(), makePayment(), getBalance()

### MedicalRecord
- Properties: patientId, doctorId, symptoms, diagnosis, medications
- Additional: vitalSigns, labTests, treatmentPlan, followUpDate
- Methods: setDiagnosis(), addMedication(), updateVitalSigns(), addLabTest()

## 📱 Usage Example

1. Start the application
2. Create departments first
3. Add doctors and nurses to departments
4. Register patients
5. Schedule appointments
6. Create medical records with diagnoses
7. Handle emergency calls
8. Manage billing

## 🆘 Emergency Services

The system includes a comprehensive emergency management system:
- Create emergency calls with priority levels
- View pending emergencies
- Dispatch available ambulances
- Track ambulance status in real-time
- Record response times

## 💰 Billing System

Complete financial management:
- Create itemized bills
- Multiple payment methods
- Payment history tracking
- Outstanding balance monitoring
- Financial reporting

## 👨‍💻 For Students

This project demonstrates key OOP concepts required for academic courses:
- **Class Design**: Well-structured classes with clear responsibilities
- **Inheritance Hierarchy**: Person → Patient/Doctor/Nurse
- **Encapsulation**: Private data with public methods
- **Data Management**: CRUD operations for all entities
- **Console UI**: User-friendly menu-driven interface

## 📝 License

MIT License - Feel free to use for educational purposes.

## 🤝 Contributing

This is an educational project. Feel free to fork and enhance it with additional features!

