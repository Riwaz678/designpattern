package observer;

// Bad design: directly calls each notification class — tight coupling, adding new observer requires modifying this class
public class ResultServiceBad {

    public void publishResult(String result, StudentObserver student, ParentObserver parent, DepartmentObserver department) {
        System.out.println("Result published: " + result);
        student.update(result);
        parent.update(result);
        department.update(result);
    }
}
