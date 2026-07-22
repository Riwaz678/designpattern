package decorator;

// Bad demo: only one rigid combination — can't mix and match features
public class DecoratorBadDemo {

    public static void main(String[] args) {
        FullReport report = new FullReport("Ram", 95);
        System.out.println(report.generate());
    }
}
