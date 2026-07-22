package proxy;

// Proxy: controls access — only ADMIN can view marks
public class StudentRecordProxy implements StudentRecordAccess {

    private StudentRecord realRecord;

    public StudentRecordProxy(StudentRecord realRecord) {
        this.realRecord = realRecord;
    }

    @Override
    public void viewMarks(String role) {
        if (role.equals("ADMIN")) {
            realRecord.viewMarks(role);
        } else {
            System.out.println("Access denied: " + role + " cannot view marks");
        }
    }
}
