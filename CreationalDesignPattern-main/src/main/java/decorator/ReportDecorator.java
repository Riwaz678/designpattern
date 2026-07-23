package decorator;

// Decorator base — wraps a report and adds behavior dynamically
public abstract class ReportDecorator implements StudentReport {

    protected StudentReport decoratedReport;

    public ReportDecorator(StudentReport decoratedReport) {
        this.decoratedReport = decoratedReport;
    }

    @Override
    public String generate() {
        return decoratedReport.generate();
    }
}
