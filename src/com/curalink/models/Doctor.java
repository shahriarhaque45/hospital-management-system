package com.curalink.models;

public class Doctor extends Person {
    private String specialization;

    public Doctor(String id, String name, int age, String specialization) {
        super(id, name, age);
        this.specialization = specialization;
    }
   
    @Override
    public void performRole() {
        System.out.println("                     > Doctor " + getName() + " (" + specialization + ") is seeing patients.");
    }

    @Override
    public String toString() {
        return super.toString() + " - [Doctor: " + specialization + "]";
    }
}
