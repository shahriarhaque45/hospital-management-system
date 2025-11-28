// Abstract class acting as a base
public abstract class Person {
    
    //Encapsulation
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

    // Abstract method enforcing specific behavior in child classes
    public abstract void performRole();
    
    // Method Overriding - polymorphism
    @Override
    public String toString() {
        return "[" + id + "] " + name + " (" + age + " yrs)";
    }
}