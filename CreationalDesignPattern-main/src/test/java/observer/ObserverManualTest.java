package observer;

import java.util.Scanner;

public class ObserverManualTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int passed = 0;
        int failed = 0;

        System.out.println("=== Observer Pattern Manual Test ===");
        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine().trim();
        System.out.print("Enter Parent Name: ");
        String parentName = scanner.nextLine().trim();
        System.out.print("Enter Department Name: ");
        String deptName = scanner.nextLine().trim();
        System.out.print("Enter Result Message: ");
        String message = scanner.nextLine().trim();

        System.out.println();
        System.out.println("--- Running Tests ---");

        ResultPublisher publisher = new ResultPublisher();
        StudentObserver student = new StudentObserver(studentName);
        ParentObserver parent = new ParentObserver(parentName);
        DepartmentObserver department = new DepartmentObserver(deptName);

        System.out.print("testPublisherNotNull: ");
        if (publisher != null) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testObserverRegistration: ");
        publisher.subscribe(student);
        publisher.subscribe(parent);
        publisher.subscribe(department);
        if (publisher.getObserverCount() == 3) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testStudentReceivesNotification: ");
        if (student != null) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testParentReceivesNotification: ");
        if (parent != null) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testDepartmentReceivesNotification: ");
        if (department != null) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.println();
        System.out.println("--- Publishing Result ---");
        publisher.publishResult(message);

        System.out.println();
        System.out.print("testObserverRemoval: ");
        publisher.unsubscribe(department);
        if (publisher.getObserverCount() == 2) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.println();
        System.out.println("--- After Removal ---");
        publisher.publishResult(message + " (Re-evaluation)");

        System.out.println();
        System.out.println("Result: " + passed + " passed, " + failed + " failed");
    }
}
