package decorator;

// Adds a footer to the report
public class FooterDecorator extends ReportDecorator {

    public FooterDecorator(StudentReport decoratedReport) {
        super(decoratedReport);
    }

    @Override
    public String generate() {
        return super.generate() + "\n========== END OF REPORT ==========";
    }
}
