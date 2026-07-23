package command;

// Concrete command — ID card request
public class IDCardRequest implements RequestCommand {

    private String studentName;

    public IDCardRequest(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public void execute() {
        System.out.println("ID Card request processed for: " + studentName);
    }

    @Override
    public String getDescription() {
        return "ID Card Request";
    }

    public String getStudentName() { return studentName; }
}
