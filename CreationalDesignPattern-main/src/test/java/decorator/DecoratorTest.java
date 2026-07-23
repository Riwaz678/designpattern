package decorator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// JUnit 5 tests to verify Decorator pattern behavior
class DecoratorTest {

    @Test
    void testBasicReportCreation() {
        StudentReport report = new BasicStudentReport("Ram", 95);
        assertNotNull(report);
    }

    @Test
    void testBasicReportContent() {
        StudentReport report = new BasicStudentReport("Ram", 95);
        String output = report.generate();
        assertTrue(output.contains("Ram"));
        assertTrue(output.contains("95"));
    }

    @Test
    void testHeaderDecorator() {
        StudentReport report = new BasicStudentReport("Ram", 95);
        report = new HeaderDecorator(report);
        assertTrue(report.generate().contains("STUDENT REPORT"));
    }

    @Test
    void testFooterDecorator() {
        StudentReport report = new BasicStudentReport("Ram", 95);
        report = new FooterDecorator(report);
        assertTrue(report.generate().contains("END OF REPORT"));
    }

    @Test
    void testTimestampDecorator() {
        StudentReport report = new BasicStudentReport("Ram", 95);
        report = new TimestampDecorator(report);
        assertTrue(report.generate().contains("Generated on"));
    }

    @Test
    void testMultipleDecorators() {
        StudentReport report = new BasicStudentReport("Ram", 95);
        report = new HeaderDecorator(report);
        report = new TimestampDecorator(report);
        report = new FooterDecorator(report);

        String output = report.generate();
        assertTrue(output.contains("STUDENT REPORT"));
        assertTrue(output.contains("Generated on"));
        assertTrue(output.contains("END OF REPORT"));
        assertTrue(output.contains("Ram"));
    }

    @Test
    void testDecoratorNotNull() {
        StudentReport report = new HeaderDecorator(new BasicStudentReport("Ram", 95));
        assertNotNull(report);
    }
}
