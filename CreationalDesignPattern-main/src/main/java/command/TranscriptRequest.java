package command;

// Concrete command — transcript request
public class TranscriptRequest implements RequestCommand {

    private String studentName;

    public TranscriptRequest(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public void execute() {
        System.out.println("Transcript request processed for: " + studentName);
    }

    @Override
    public String getDescription() {
        return "Transcript Request";
    }

    public String getStudentName() { return studentName; }
}
