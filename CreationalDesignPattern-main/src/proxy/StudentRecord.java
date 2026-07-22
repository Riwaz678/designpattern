package proxy;

// Real subject — actually accesses the student marks
public class StudentRecord implements StudentRecordAccess {

    private String studentName;
    private int marks;

    public StudentRecord(String studentName, int marks) {
        this.studentName = studentName;
        this.marks = marks;
    }

    @Override
    public void viewMarks(String role) {
        System.out.println("Student: " + studentName + ", Marks: " + marks);
    }

    public String getStudentName() { return studentName; }
    public int getMarks() { return marks; }
}
