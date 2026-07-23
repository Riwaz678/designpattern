package observer;

// Good demo: observers subscribe/unsubscribe dynamically — loosely coupled
public class ObserverDemo {

    public static void main(String[] args) {
        ResultPublisher publisher = new ResultPublisher();

        StudentObserver student = new StudentObserver("Ram");
        ParentObserver parent = new ParentObserver("Hari");
        DepartmentObserver department = new DepartmentObserver("BCA");

        publisher.subscribe(student);
        publisher.subscribe(parent);
        publisher.subscribe(department);

        publisher.publishResult("Semester 5 results published");

        System.out.println();

        publisher.unsubscribe(department);
        publisher.publishResult("Re-evaluation results published");
    }
}
