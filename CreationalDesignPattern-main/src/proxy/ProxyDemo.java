package proxy;

// Good demo: proxy controls who can view marks
public class ProxyDemo {

    public static void main(String[] args) {
        StudentRecord record = new StudentRecord("Ram", 95);
        StudentRecordProxy proxy = new StudentRecordProxy(record);

        proxy.viewMarks("ADMIN");
        proxy.viewMarks("STUDENT");
    }
}
