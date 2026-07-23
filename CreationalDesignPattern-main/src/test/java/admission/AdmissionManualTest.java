package admission;

import builder.Student;
import factory.Notification;
import factory.NotificationFactory;
import singleton.CollegeConfig;

import java.util.Scanner;

public class AdmissionManualTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int passed = 0;
        int failed = 0;

        System.out.println("=== Student Admission Manual Test ===");

        System.out.print("Enter College Name: ");
        String collegeName = scanner.nextLine().trim();
        System.out.print("Enter System Version: ");
        String version = scanner.nextLine().trim();
        System.out.print("Enter Student ID: ");
        int id = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter Student Email: ");
        String email = scanner.nextLine().trim();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine().trim();
        System.out.print("Enter Department: ");
        String dept = scanner.nextLine().trim();
        System.out.print("Enter Semester: ");
        int sem = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Enter Address: ");
        String addr = scanner.nextLine().trim();
        System.out.print("Enter Guardian Name: ");
        String guardian = scanner.nextLine().trim();
        System.out.print("Enter Notification Type (EMAIL/SMS/PUSH): ");
        String notifType = scanner.nextLine().trim().toUpperCase();
        System.out.print("Enter Welcome Message: ");
        String message = scanner.nextLine().trim();

        System.out.println();
        System.out.println("--- Running Tests ---");

        CollegeConfig config = CollegeConfig.getInstance();
        System.out.print("testSingletonNotNull: ");
        if (config != null) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testCollegeName: ");
        if (config.getCollegeName().equals(collegeName)) { System.out.println("PASS"); passed++; } else {
            System.out.println("FAIL (expected: " + collegeName + ", got: " + config.getCollegeName() + ")"); failed++;
        }

        System.out.print("testSystemVersion: ");
        if (config.getSystemVersion().equals(version)) { System.out.println("PASS"); passed++; } else {
            System.out.println("FAIL (expected: " + version + ", got: " + config.getSystemVersion() + ")"); failed++;
        }

        Student student = new Student.Builder()
                .studentId(id)
                .name(name)
                .email(email)
                .phoneNumber(phone)
                .department(dept)
                .semester(sem)
                .address(addr)
                .guardianName(guardian)
                .build();

        System.out.print("testStudentNotNull: ");
        if (student != null) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testStudentId: ");
        if (student.getStudentId() == id) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testStudentName: ");
        if (student.getName().equals(name)) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testStudentEmail: ");
        if (student.getEmail().equals(email)) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testStudentDepartment: ");
        if (student.getDepartment().equals(dept)) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testStudentSemester: ");
        if (student.getSemester() == sem) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testNotificationCreation: ");
        try {
            Notification notification = NotificationFactory.createNotification(notifType);
            if (notification != null) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }
        } catch (IllegalArgumentException e) {
            System.out.println("FAIL (Invalid type: " + notifType + ")"); failed++;
        }

        System.out.print("testAdmissionModule: ");
        StudentAdmissionModule module = new StudentAdmissionModule();
        if (module != null) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.println();
        System.out.println("--- Admission Output ---");
        module.admitStudent(student, notifType);

        System.out.println();
        System.out.println("Result: " + passed + " passed, " + failed + " failed");
    }
}
