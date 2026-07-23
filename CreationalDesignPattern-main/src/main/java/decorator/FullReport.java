package decorator;

// Bad design: subclass explosion — need a new class for every combination
public class FullReport extends BasicStudentReport {

    public FullReport(String studentName, int marks) {
        super(studentName, marks);
    }

    @Override
    public String generate() {
        return "========== STUDENT REPORT ==========\n"
                + "Student: " + getStudentName() + "\n"
                + "Marks: " + getMarks() + "\n"
                + "Generated on: " + java.time.LocalDateTime.now() + "\n"
                + "========== END OF REPORT ==========";
    }
}
