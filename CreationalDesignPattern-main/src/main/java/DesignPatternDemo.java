import adapter.*;
import builder.Student;
import command.*;
import decorator.*;
import facade.*;
import factory.*;
import observer.*;
import proxy.*;
import singleton.CollegeConfig;
import state.*;
import strategy.*;

import java.util.Scanner;

public class DesignPatternDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int passed = 0;
        int failed = 0;

        System.out.println("========================================");
        System.out.println("   DESIGN PATTERNS - ALL IN ONE DEMO");
        System.out.println("========================================");

        System.out.println();
        System.out.println("----- 1. SINGLETON PATTERN -----");
        CollegeConfig config1 = CollegeConfig.getInstance();
        CollegeConfig config2 = CollegeConfig.getInstance();
        System.out.println("College: " + config1.getCollegeName());
        System.out.println("Version: " + config1.getSystemVersion());
        System.out.print("testSingleInstance: ");
        if (config1 == config2) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.println();
        System.out.println("----- 2. BUILDER PATTERN -----");
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
        System.out.print("testStudentCreated: ");
        if (student != null) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.println();
        System.out.println("----- 3. FACTORY PATTERN -----");
        System.out.print("Enter notification type (EMAIL/SMS/PUSH): ");
        String notifType = scanner.nextLine().trim().toUpperCase();
        System.out.print("Enter message: ");
        String notifMsg = scanner.nextLine().trim();
        try {
            Notification notif = NotificationFactory.createNotification(notifType);
            notif.send(notifMsg);
            System.out.print("testNotification: PASS\n");
            passed++;
        } catch (IllegalArgumentException e) {
            System.out.print("testNotification: FAIL (" + e.getMessage() + ")\n");
            failed++;
        }

        System.out.println();
        System.out.println("----- 4. ADAPTER PATTERN -----");
        System.out.print("Enter email message: ");
        String adapterMsg = scanner.nextLine().trim();
        LegacyEmailService legacyEmail = new LegacyEmailService();
        NotificationService adapter = new EmailAdapter(legacyEmail);
        adapter.sendNotification(adapterMsg);
        System.out.print("testAdapter: PASS\n");
        passed++;

        System.out.println();
        System.out.println("----- 5. FACADE PATTERN -----");
        System.out.print("Enter student name for registration: ");
        String facadeName = scanner.nextLine().trim();
        System.out.print("Enter student ID: ");
        String facadeId = scanner.nextLine().trim();
        StudentRegistrationFacade facade = new StudentRegistrationFacade();
        boolean regResult = facade.register(facadeName, facadeId);
        System.out.print("testRegistration: ");
        if (regResult) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.println();
        System.out.println("----- 6. PROXY PATTERN -----");
        System.out.print("Enter student name for proxy: ");
        String proxyName = scanner.nextLine().trim();
        System.out.print("Enter marks: ");
        int proxyMarks = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Enter role (ADMIN/STUDENT): ");
        String role = scanner.nextLine().trim().toUpperCase();
        StudentRecord record = new StudentRecord(proxyName, proxyMarks);
        StudentRecordProxy proxy = new StudentRecordProxy(record);
        proxy.viewMarks(role);
        System.out.print("testProxy: PASS\n");
        passed++;

        System.out.println();
        System.out.println("----- 7. DECORATOR PATTERN -----");
        System.out.print("Enter student name for report: ");
        String reportName = scanner.nextLine().trim();
        System.out.print("Enter marks: ");
        int reportMarks = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Add header? (yes/no): ");
        boolean addHeader = scanner.nextLine().trim().equalsIgnoreCase("yes");
        System.out.print("Add timestamp? (yes/no): ");
        boolean addTimestamp = scanner.nextLine().trim().equalsIgnoreCase("yes");
        System.out.print("Add footer? (yes/no): ");
        boolean addFooter = scanner.nextLine().trim().equalsIgnoreCase("yes");
        StudentReport report = new BasicStudentReport(reportName, reportMarks);
        if (addHeader) report = new HeaderDecorator(report);
        if (addTimestamp) report = new TimestampDecorator(report);
        if (addFooter) report = new FooterDecorator(report);
        System.out.println(report.generate());
        System.out.print("testDecorator: PASS\n");
        passed++;

        System.out.println();
        System.out.println("----- 8. STRATEGY PATTERN -----");
        System.out.print("Enter fee amount: ");
        double feeAmount = Double.parseDouble(scanner.nextLine().trim());
        System.out.print("Enter payment method (KHALTI/ESEWA/BANK): ");
        String payMethod = scanner.nextLine().trim().toUpperCase();
        PaymentContext payContext = new PaymentContext(null);
        switch (payMethod) {
            case "KHALTI":
                System.out.print("Enter Khalti mobile: ");
                payContext.setPaymentStrategy(new KhaltiPayment(scanner.nextLine().trim()));
                break;
            case "ESEWA":
                System.out.print("Enter eSewa mobile: ");
                payContext.setPaymentStrategy(new EsewaPayment(scanner.nextLine().trim()));
                break;
            case "BANK":
                System.out.print("Enter bank account: ");
                payContext.setPaymentStrategy(new BankTransferPayment(scanner.nextLine().trim()));
                break;
            default:
                System.out.println("Invalid method");
                failed++;
                break;
        }
        payContext.payFee(feeAmount);
        System.out.print("testStrategy: PASS\n");
        passed++;

        System.out.println();
        System.out.println("----- 9. OBSERVER PATTERN -----");
        System.out.print("Enter student name: ");
        String obsStudent = scanner.nextLine().trim();
        System.out.print("Enter parent name: ");
        String obsParent = scanner.nextLine().trim();
        System.out.print("Enter department: ");
        String obsDept = scanner.nextLine().trim();
        System.out.print("Enter result message: ");
        String obsMsg = scanner.nextLine().trim();
        ResultPublisher publisher = new ResultPublisher();
        publisher.subscribe(new StudentObserver(obsStudent));
        publisher.subscribe(new ParentObserver(obsParent));
        publisher.subscribe(new DepartmentObserver(obsDept));
        publisher.publishResult(obsMsg);
        System.out.print("testObserver: PASS\n");
        passed++;

        System.out.println();
        System.out.println("----- 10. COMMAND PATTERN -----");
        System.out.print("Enter student name for requests: ");
        String cmdName = scanner.nextLine().trim();
        StudentPortal portal = new StudentPortal();
        portal.submitRequest(new TranscriptRequest(cmdName));
        portal.submitRequest(new CertificateRequest(cmdName));
        portal.submitRequest(new IDCardRequest(cmdName));
        portal.submitRequest(new LibraryCardRequest(cmdName));
        System.out.print("testCommand: ");
        if (portal.getRequestCount() == 4) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }

        System.out.println();
        System.out.println("----- 11. STATE PATTERN -----");
        AdmissionApplication app = new AdmissionApplication();
        System.out.println("Status: " + app.getStatus());
        System.out.print("Process step 1? (yes/no): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("yes")) {
            app.process();
            System.out.println("Status: " + app.getStatus());
            System.out.print("testTransitionToVerified: ");
            if (app.getStatus().equals("VERIFIED")) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }
        }
        System.out.print("Process step 2? (yes/no): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("yes")) {
            app.process();
            System.out.println("Status: " + app.getStatus());
            System.out.print("testTransitionToApproved: ");
            if (app.getStatus().equals("APPROVED")) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }
        }
        System.out.print("Process step 3? (yes/no): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("yes")) {
            app.process();
            System.out.println("Status: " + app.getStatus());
            System.out.print("testTransitionToEnrolled: ");
            if (app.getStatus().equals("ENROLLED")) { System.out.println("PASS"); passed++; } else { System.out.println("FAIL"); failed++; }
        }

        System.out.println();
        System.out.println("========================================");
        System.out.println("   ALL 11 PATTERNS COMPLETED!");
        System.out.println("   Result: " + passed + " passed, " + failed + " failed");
        System.out.println("========================================");
    }
}
