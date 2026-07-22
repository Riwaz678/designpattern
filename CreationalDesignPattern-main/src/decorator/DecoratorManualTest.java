package decorator;

import java.util.Scanner;

public class DecoratorManualTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int passed = 0;
        int failed = 0;

        System.out.println("=== Decorator Pattern Manual Test ===");
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter Marks: ");
        int marks = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Add Header? (yes/no): ");
        boolean addHeader = scanner.nextLine().trim().equalsIgnoreCase("yes");
        System.out.print("Add Timestamp? (yes/no): ");
        boolean addTimestamp = scanner.nextLine().trim().equalsIgnoreCase("yes");
        System.out.print("Add Footer? (yes/no): ");
        boolean addFooter = scanner.nextLine().trim().equalsIgnoreCase("yes");

        StudentReport report = new BasicStudentReport(name, marks);
        if (addHeader) report = new HeaderDecorator(report);
        if (addTimestamp) report = new TimestampDecorator(report);
        if (addFooter) report = new FooterDecorator(report);

        System.out.println();
        System.out.println("--- Running Tests ---");

        StudentReport basic = new BasicStudentReport(name, marks);
        System.out.print("testBasicReportCreation: ");
        if (basic != null) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testBasicReportContent: ");
        if (basic.generate().contains(name) && basic.generate().contains(String.valueOf(marks))) {
            System.out.println("PASS"); passed++;
        } else { System.out.println("FAIL"); failed++; }

        System.out.print("testHeaderDecorator: ");
        StudentReport withHeader = new HeaderDecorator(new BasicStudentReport(name, marks));
        if (withHeader.generate().contains("STUDENT REPORT")) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testFooterDecorator: ");
        StudentReport withFooter = new FooterDecorator(new BasicStudentReport(name, marks));
        if (withFooter.generate().contains("END OF REPORT")) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testTimestampDecorator: ");
        StudentReport withTimestamp = new TimestampDecorator(new BasicStudentReport(name, marks));
        if (withTimestamp.generate().contains("Generated on")) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testDecoratorNotNull: ");
        StudentReport decorated = new HeaderDecorator(new BasicStudentReport(name, marks));
        if (decorated != null) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.println();
        System.out.println("--- Your Custom Report ---");
        System.out.println(report.generate());

        System.out.println();
        System.out.println("Result: " + passed + " passed, " + failed + " failed");
    }
}
