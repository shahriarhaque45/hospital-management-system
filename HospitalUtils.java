import java.util.List;

public class HospitalUtils {
    public static Person findPerson(List<Person> people, String id) {
        for (Person p : people) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }

    public static Person findPerson(List<Person> people, String name, int age) {
        for (Person p : people) {
            if (p.getName().equalsIgnoreCase(name) && p.getAge() == age) {
                return p;
            }
        }
        return null;
    }
}