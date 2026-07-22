package facade;

public class StudentRepository {
    public void save(String name, String id, String rollNumber) {
        System.out.println("Student saved: " + name + " (ID: " + id + ", Roll: " + rollNumber + ")");
    }
}
