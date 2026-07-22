package facade;

public class StudentValidator {
    public boolean validate(String name, String id) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Validation failed: Name is empty");
            return false;
        }
        if (id == null || id.trim().isEmpty()) {
            System.out.println("Validation failed: ID is empty");
            return false;
        }
        System.out.println("Student validated: " + name);
        return true;
    }
}
