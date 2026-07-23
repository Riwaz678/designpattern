package state;

import java.util.Scanner;

public class StateManualTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int passed = 0;
        int failed = 0;

        System.out.println("=== State Pattern Manual Test ===");
        System.out.println("Admission flow: SUBMITTED -> VERIFIED -> APPROVED -> ENROLLED");
        System.out.print("Process all steps? (yes/no): ");
        String choice = scanner.nextLine().trim().toLowerCase();

        System.out.println();
        System.out.println("--- Running Tests ---");

        AdmissionApplication app = new AdmissionApplication();

        System.out.print("testInitialStateIsSubmitted: ");
        if (app.getStatus().equals("SUBMITTED")) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testStateObjectNotNull: ");
        AdmissionState state = new SubmittedState();
        if (state != null) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        if (choice.equals("yes")) {
            System.out.println();
            System.out.println("--- Processing Admission ---");

            System.out.println("Status: " + app.getStatus());
            app.process();

            System.out.print("testTransitionToVerified: ");
            if (app.getStatus().equals("VERIFIED")) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

            System.out.println("Status: " + app.getStatus());
            app.process();

            System.out.print("testTransitionToApproved: ");
            if (app.getStatus().equals("APPROVED")) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

            System.out.println("Status: " + app.getStatus());
            app.process();

            System.out.print("testTransitionToEnrolled: ");
            if (app.getStatus().equals("ENROLLED")) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

            System.out.println("Status: " + app.getStatus());
        } else {
            System.out.println();
            System.out.println("--- Testing Rejected State ---");
            app.setState(new RejectedState());

            System.out.print("testRejectedState: ");
            if (app.getStatus().equals("REJECTED")) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

            app.process();
        }

        System.out.println();
        System.out.println("Result: " + passed + " passed, " + failed + " failed");
    }
}
