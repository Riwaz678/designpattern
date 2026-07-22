package decorator;

// Adds a timestamp to the report
public class TimestampDecorator extends ReportDecorator {

    public TimestampDecorator(StudentReport decoratedReport) {
        super(decoratedReport);
    }

    @Override
    public String generate() {
        return super.generate() + "\nGenerated on: " + java.time.LocalDateTime.now();
    }
}
