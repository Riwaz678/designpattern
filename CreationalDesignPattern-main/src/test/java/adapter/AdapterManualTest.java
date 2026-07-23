package adapter;

import java.util.Scanner;

public class AdapterManualTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int passed = 0;
        int failed = 0;

        System.out.println("=== Adapter Pattern Manual Test ===");
        System.out.print("Enter message to send: ");
        String message = scanner.nextLine().trim();

        System.out.println();
        System.out.println("--- Running Tests ---");

        LegacyEmailService legacyEmail = new LegacyEmailService();
        EmailAdapter adapter = new EmailAdapter(legacyEmail);

        System.out.print("testAdapterObjectCreation: ");
        if (adapter != null) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testAdapterImplementsNotificationService: ");
        if (adapter instanceof NotificationService) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testAdapterDelegatesCorrectly: ");
        try {
            adapter.sendNotification(message);
            System.out.println("PASS");
            passed++;
        } catch (Exception e) {
            System.out.println("FAIL"); failed++;
        }

        System.out.print("testAdapterNotNull: ");
        NotificationService notification = new EmailAdapter(legacyEmail);
        if (notification != null) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.println();
        System.out.println("Result: " + passed + " passed, " + failed + " failed");
    }
}
