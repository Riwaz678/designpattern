package admission;

import builder.Student;
import factory.Notification;
import factory.NotificationFactory;
import singleton.CollegeConfig;

public class StudentAdmissionModule {

    public void admitStudent(Student student, String notificationType) {
        CollegeConfig config = CollegeConfig.getInstance();

        System.out.println("=== Student Admission Module ===");
        System.out.println("College: " + config.getCollegeName());
        System.out.println("System Version: " + config.getSystemVersion());
        System.out.println();

        System.out.println("Student Profile Created:");
        System.out.println("  ID: " + student.getStudentId());
        System.out.println("  Name: " + student.getName());
        System.out.println("  Email: " + student.getEmail());
        System.out.println("  Phone: " + student.getPhoneNumber());
        System.out.println("  Department: " + student.getDepartment());
        System.out.println("  Semester: " + student.getSemester());
        System.out.println("  Address: " + student.getAddress());
        System.out.println("  Guardian: " + student.getGuardianName());
        System.out.println();

        Notification notification = NotificationFactory.createNotification(notificationType);
        String message = "Welcome to " + config.getCollegeName() + ", " + student.getName() + "!";
        notification.send(message);
    }
}
