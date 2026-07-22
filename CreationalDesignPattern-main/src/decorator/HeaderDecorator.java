package decorator;

// Adds a header to the report
public class HeaderDecorator extends ReportDecorator {

    public HeaderDecorator(StudentReport decoratedReport) {
        super(decoratedReport);
    }

    @Override
    public String generate() {
        return "========== STUDENT REPORT ==========\n" + super.generate();
    }
}
