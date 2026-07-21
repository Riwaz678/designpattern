package admission;

import static org.junit.jupiter.api.Assertions.*;

import builder.Student;
import factory.NotificationFactory;
import singleton.CollegeConfig;

import org.junit.jupiter.api.Test;

class StudentAdmissionTest {

    @Test
    void testAdmissionUsesSingletonConfig() {
        CollegeConfig config = CollegeConfig.getInstance();
        assertEquals("ABC College", config.getCollegeName());
        assertEquals("1.0", config.getSystemVersion());
    }

    @Test
    void testAdmissionCreatesStudentViaBuilder() {
        Student student = new Student.Builder()
                .studentId(201)
                .name("Sita")
                .email("sita@gmail.com")
                .department("BCA")
                .semester(3)
                .build();

        assertEquals(201, student.getStudentId());
        assertEquals("Sita", student.getName());
        assertEquals("sita@gmail.com", student.getEmail());
        assertEquals("BCA", student.getDepartment());
        assertEquals(3, student.getSemester());
    }

    @Test
    void testAdmissionSendsNotificationViaFactory() {
        assertDoesNotThrow(() -> NotificationFactory.createNotification("EMAIL"));
        assertDoesNotThrow(() -> NotificationFactory.createNotification("SMS"));
        assertDoesNotThrow(() -> NotificationFactory.createNotification("PUSH"));
    }

    @Test
    void testAdmissionModuleInstantiation() {
        StudentAdmissionModule module = new StudentAdmissionModule();
        assertNotNull(module);
    }
}
