package decorator;

// Good demo: decorators can be stacked in any combination
public class DecoratorDemo {

    public static void main(String[] args) {
        StudentReport report = new BasicStudentReport("Ram", 95);

        report = new HeaderDecorator(report);
        report = new TimestampDecorator(report);
        report = new FooterDecorator(report);

        System.out.println(report.generate());
    }
}
