package proxy;

// Bad design: no access control — anyone can view marks
public class ProxyBadDemo {

    public static void main(String[] args) {
        StudentRecord record = new StudentRecord("Ram", 95);

        record.viewMarks("ADMIN");
        record.viewMarks("STUDENT");
    }
}
