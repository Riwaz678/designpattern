package proxy;

import java.util.Scanner;

public class ProxyManualTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int passed = 0;
        int failed = 0;

        System.out.println("=== Proxy Pattern Manual Test ===");
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter Marks: ");
        int marks = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Enter Role (ADMIN/STUDENT): ");
        String role = scanner.nextLine().trim().toUpperCase();

        System.out.println();
        System.out.println("--- Running Tests ---");

        StudentRecord record = new StudentRecord(name, marks);
        StudentRecordProxy proxy = new StudentRecordProxy(record);

        System.out.print("testProxyObjectCreation: ");
        if (proxy != null) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testAdminAccessAllowed: ");
        try {
            proxy.viewMarks("ADMIN");
            System.out.println("PASS");
            passed++;
        } catch (Exception e) {
            System.out.println("FAIL"); failed++;
        }

        System.out.print("testStudentAccessDenied: ");
        try {
            proxy.viewMarks("STUDENT");
            System.out.println("PASS");
            passed++;
        } catch (Exception e) {
            System.out.println("FAIL"); failed++;
        }

        System.out.print("testProxyNotNull: ");
        StudentRecordAccess proxyAccess = new StudentRecordProxy(record);
        if (proxyAccess != null) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.println();
        System.out.println("--- Access Test with role: " + role + " ---");
        proxy.viewMarks(role);

        System.out.println();
        System.out.println("Result: " + passed + " passed, " + failed + " failed");
    }
}
