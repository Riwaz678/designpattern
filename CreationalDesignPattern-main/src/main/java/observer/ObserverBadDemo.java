package observer;

// Bad demo: tightly coupled — can't add/remove observers dynamically
public class ObserverBadDemo {

    public static void main(String[] args) {
        ResultServiceBad service = new ResultServiceBad();
        StudentObserver student = new StudentObserver("Ram");
        ParentObserver parent = new ParentObserver("Hari");
        DepartmentObserver department = new DepartmentObserver("BCA");

        service.publishResult("Semester 5 results published", student, parent, department);
    }
}
