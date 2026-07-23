package command;

import java.util.Scanner;

public class CommandManualTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int passed = 0;
        int failed = 0;

        System.out.println("=== Command Pattern Manual Test ===");
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine().trim();

        System.out.println();
        System.out.println("--- Running Tests ---");

        System.out.print("testTranscriptRequest: ");
        TranscriptRequest transcript = new TranscriptRequest(name);
        if (transcript != null) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testCertificateRequest: ");
        CertificateRequest cert = new CertificateRequest(name);
        if (cert != null) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testIDCardRequest: ");
        IDCardRequest id = new IDCardRequest(name);
        if (id != null) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testLibraryCardRequest: ");
        LibraryCardRequest lib = new LibraryCardRequest(name);
        if (lib != null) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.print("testCommandDescription: ");
        if (transcript.getDescription().equals("Transcript Request")) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.println();
        System.out.println("--- Submitting Requests ---");
        StudentPortal portal = new StudentPortal();
        portal.submitRequest(transcript);
        portal.submitRequest(cert);
        portal.submitRequest(id);
        portal.submitRequest(lib);

        System.out.print("testPortalRequestCount: ");
        if (portal.getRequestCount() == 4) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.println();
        System.out.println("Result: " + passed + " passed, " + failed + " failed");
    }
}
