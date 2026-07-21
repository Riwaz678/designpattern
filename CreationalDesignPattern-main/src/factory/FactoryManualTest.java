package factory;

import java.util.Scanner;

public class FactoryManualTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int passed = 0;
        int failed = 0;

        System.out.println("=== Factory Pattern Manual Test ===");
        System.out.print("Enter notification type (EMAIL/SMS/PUSH): ");
        String type = scanner.nextLine().trim().toUpperCase();
        System.out.print("Enter message to send: ");
        String message = scanner.nextLine().trim();

        System.out.println();
        System.out.println("--- Running Tests ---");

        System.out.print("testNotificationNotNull: ");
        try {
            Notification notification = NotificationFactory.createNotification(type);
            if (notification != null) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

            System.out.print("testNotificationType: ");
            boolean correctType = false;
            if (type.equals("EMAIL") && notification instanceof EmailNotification) correctType = true;
            if (type.equals("SMS") && notification instanceof SmsNotification) correctType = true;
            if (type.equals("PUSH") && notification instanceof PushNotification) correctType = true;
            if (correctType) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

            System.out.print("testSendMessage: ");
            System.out.print(" -> ");
            notification.send(message);
            System.out.println("PASS");
            passed++;
        } catch (IllegalArgumentException e) {
            System.out.println("testNotificationNotNull: FAIL (Invalid type: " + type + ")");
            failed++;
        }

        System.out.print("testInvalidTypeThrowsException: ");
        try {
            NotificationFactory.createNotification("FAX");
            System.out.println("FAIL (no exception thrown)"); failed++;
        } catch (IllegalArgumentException e) {
            System.out.println("PASS"); passed++;
        }

        System.out.println();
        System.out.println("Result: " + passed + " passed, " + failed + " failed");
    }
}
