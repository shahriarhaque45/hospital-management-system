package com.curalink.models;

public class Patient extends Person implements java.io.Serializable {
    private String illness;
    
    public Patient(String id, String name, int age, String illness) {
        super(id, name, age);
        this.illness = illness;
    }
    
    @Override
    public void performRole() {
        System.out.println("\t\t     > Patient " + getName() + " is recovering from " + illness);
    }
    
    @Override
    public String toString() {
        return super.toString() + " - Complaint: " + illness;
    }
}
