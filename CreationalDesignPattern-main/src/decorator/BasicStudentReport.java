package decorator;

// Concrete component — generates a basic student report
public class BasicStudentReport implements StudentReport {

    private String studentName;
    private int marks;

    public BasicStudentReport(String studentName, int marks) {
        this.studentName = studentName;
        this.marks = marks;
    }

    @Override
    public String generate() {
        return "Student: " + studentName + "\nMarks: " + marks;
    }

    public String getStudentName() { return studentName; }
    public int getMarks() { return marks; }
}
