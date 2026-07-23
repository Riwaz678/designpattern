package builder;

import java.util.Scanner;

public class BuilderManualTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int passed = 0;
        int failed = 0;

        System.out.println("=== Builder Pattern Manual Test ===");
        System.out.print("Enter Student ID: ");
        int id = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Enter Name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter Email: ");
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

        System.out.println();
        System.out.println("--- Running Tests ---");

        System.out.print("testStudentNotNull: ");
        if (student != null) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testStudentId: ");
        if (student.getStudentId() == id) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testStudentName: ");
        if (student.getName().equals(name)) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testStudentEmail: ");
        if (student.getEmail().equals(email)) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testStudentPhone: ");
        if (student.getPhoneNumber().equals(phone)) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testStudentDepartment: ");
        if (student.getDepartment().equals(dept)) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testStudentSemester: ");
        if (student.getSemester() == sem) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testStudentAddress: ");
        if (student.getAddress().equals(addr)) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testStudentGuardian: ");
        if (student.getGuardianName().equals(guardian)) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.println();
        System.out.println("Result: " + passed + " passed, " + failed + " failed");
    }
}
