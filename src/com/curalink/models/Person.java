package com.curalink.models;

public abstract class Person {
    private String id;
    private String name;
    private int age;

    public Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getId() { return id; }

    public abstract void performRole();
    
    @Override
    public String toString() {
        return "[" + id + "] " + name + " (" + age + " yrs)";
    }
}
