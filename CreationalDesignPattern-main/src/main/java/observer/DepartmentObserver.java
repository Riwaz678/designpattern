package observer;

// Concrete observer — department receives notification
public class DepartmentObserver implements ResultObserver {

    private String departmentName;

    public DepartmentObserver(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public void update(String message) {
        System.out.println("Department " + departmentName + " received: " + message);
    }

    public String getDepartmentName() { return departmentName; }
}
