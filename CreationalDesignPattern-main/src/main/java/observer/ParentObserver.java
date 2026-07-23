package observer;

// Concrete observer — parent receives notification
public class ParentObserver implements ResultObserver {

    private String name;

    public ParentObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Parent " + name + " received: " + message);
    }

    public String getName() { return name; }
}
