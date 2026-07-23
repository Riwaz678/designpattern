package facade;

import java.util.Scanner;

public class FacadeManualTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int passed = 0;
        int failed = 0;

        System.out.println("=== Facade Pattern Manual Test ===");
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine().trim();

        System.out.println();
        System.out.println("--- Running Tests ---");

        StudentRegistrationFacade facade = new StudentRegistrationFacade();

        System.out.print("testFacadeObjectCreation: ");
        if (facade != null) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testRegistrationSuccess: ");
        boolean result = facade.register(name, id);
        if (result) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testRegistrationFailsWithEmptyName: ");
        boolean emptyName = facade.register("", id);
        if (!emptyName) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testRegistrationFailsWithEmptyId: ");
        boolean emptyId = facade.register(name, "");
        if (!emptyId) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.println();
        System.out.println("Result: " + passed + " passed, " + failed + " failed");
    }
}
