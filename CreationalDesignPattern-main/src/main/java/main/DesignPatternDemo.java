package main;

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

public class DesignPatternDemo {

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   DESIGN PATTERNS - ALL IN ONE DEMO");
        System.out.println("========================================");

        System.out.println();
        System.out.println("----- 1. SINGLETON PATTERN -----");
        CollegeConfig config1 = CollegeConfig.getInstance();
        CollegeConfig config2 = CollegeConfig.getInstance();
        System.out.println("College: " + config1.getCollegeName());
        System.out.println("Version: " + config1.getSystemVersion());
        System.out.println("Same instance: " + (config1 == config2));

        System.out.println();
        System.out.println("----- 2. BUILDER PATTERN -----");
        Student student = new Student.Builder()
                .studentId(101)
                .name("Ram")
                .email("ram@gmail.com")
                .phoneNumber("9800000000")
                .department("BCA")
                .semester(5)
                .address("Kathmandu")
                .guardianName("Hari")
                .build();
        System.out.println("Student: " + student.getName() + " (ID: " + student.getStudentId() + ")");
        System.out.println("Dept: " + student.getDepartment() + ", Semester: " + student.getSemester());

        System.out.println();
        System.out.println("----- 3. FACTORY PATTERN -----");
        Notification email = NotificationFactory.createNotification("EMAIL");
        Notification sms = NotificationFactory.createNotification("SMS");
        Notification push = NotificationFactory.createNotification("PUSH");
        email.send("Assignment uploaded");
        sms.send("Exam starts tomorrow");
        push.send("New notice published");

        System.out.println();
        System.out.println("----- 4. ADAPTER PATTERN -----");
        LegacyEmailService legacyEmail = new LegacyEmailService();
        NotificationService adapter = new EmailAdapter(legacyEmail);
        adapter.sendNotification("Welcome to PCPS College!");

        System.out.println();
        System.out.println("----- 5. FACADE PATTERN -----");
        StudentRegistrationFacade facade = new StudentRegistrationFacade();
        facade.register("Sita", "S102");

        System.out.println();
        System.out.println("----- 6. PROXY PATTERN -----");
        StudentRecord record = new StudentRecord("Ram", 95);
        StudentRecordProxy proxy = new StudentRecordProxy(record);
        proxy.viewMarks("ADMIN");
        proxy.viewMarks("STUDENT");

        System.out.println();
        System.out.println("----- 7. DECORATOR PATTERN -----");
        StudentReport report = new BasicStudentReport("Ram", 95);
        report = new HeaderDecorator(report);
        report = new TimestampDecorator(report);
        report = new FooterDecorator(report);
        System.out.println(report.generate());

        System.out.println();
        System.out.println("----- 8. STRATEGY PATTERN -----");
        PaymentContext payContext = new PaymentContext(new KhaltiPayment("9800000000"));
        payContext.payFee(5000);
        payContext.setPaymentStrategy(new EsewaPayment("9811111111"));
        payContext.payFee(3000);
        payContext.setPaymentStrategy(new BankTransferPayment("NRB001234"));
        payContext.payFee(10000);

        System.out.println();
        System.out.println("----- 9. OBSERVER PATTERN -----");
        ResultPublisher publisher = new ResultPublisher();
        publisher.subscribe(new StudentObserver("Ram"));
        publisher.subscribe(new ParentObserver("Hari"));
        publisher.subscribe(new DepartmentObserver("BCA"));
        publisher.publishResult("Semester 5 results published");

        System.out.println();
        System.out.println("----- 10. COMMAND PATTERN -----");
        StudentPortal portal = new StudentPortal();
        portal.submitRequest(new TranscriptRequest("Ram"));
        portal.submitRequest(new CertificateRequest("Ram"));
        portal.submitRequest(new IDCardRequest("Ram"));
        portal.submitRequest(new LibraryCardRequest("Ram"));

        System.out.println();
        System.out.println("----- 11. STATE PATTERN -----");
        AdmissionApplication app = new AdmissionApplication();
        System.out.println("Status: " + app.getStatus());
        app.process();
        System.out.println("Status: " + app.getStatus());
        app.process();
        System.out.println("Status: " + app.getStatus());
        app.process();
        System.out.println("Status: " + app.getStatus());
        app.process();
        System.out.println("Status: " + app.getStatus());

        System.out.println();
        System.out.println("========================================");
        System.out.println("   ALL 11 PATTERNS COMPLETED!");
        System.out.println("========================================");
    }
}
