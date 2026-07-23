package observer;

// Concrete observer — student receives notification
public class StudentObserver implements ResultObserver {

    private String name;

    public StudentObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Student " + name + " received: " + message);
    }

    public String getName() { return name; }
}
