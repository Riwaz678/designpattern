package singleton;

import java.util.Scanner;

public class SingletonManualTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int passed = 0;
        int failed = 0;

        System.out.println("=== Singleton Pattern Manual Test ===");
        System.out.print("Enter expected College Name: ");
        String expectedName = scanner.nextLine().trim();
        System.out.print("Enter expected System Version: ");
        String expectedVersion = scanner.nextLine().trim();

        CollegeConfig config1 = CollegeConfig.getInstance();
        CollegeConfig config2 = CollegeConfig.getInstance();

        System.out.println();
        System.out.println("--- Running Tests ---");

        System.out.print("testInstanceNotNull: ");
        if (config1 != null) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testSingleInstance: ");
        if (config1 == config2) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testSameHashCode: ");
        if (config1.hashCode() == config2.hashCode()) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testCollegeName: ");
        if (config1.getCollegeName().equals(expectedName)) { System.out.println("PASS"); passed++; } else {
            System.out.println("FAIL (expected: " + expectedName + ", got: " + config1.getCollegeName() + ")"); failed++;
        }

        System.out.print("testSystemVersion: ");
        if (config1.getSystemVersion().equals(expectedVersion)) { System.out.println("PASS"); passed++; } else {
            System.out.println("FAIL (expected: " + expectedVersion + ", got: " + config1.getSystemVersion() + ")"); failed++;
        }

        System.out.println();
        System.out.println("Result: " + passed + " passed, " + failed + " failed");
    }
}
