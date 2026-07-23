package command;

// Concrete command — library card request
public class LibraryCardRequest implements RequestCommand {

    private String studentName;

    public LibraryCardRequest(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public void execute() {
        System.out.println("Library Card request processed for: " + studentName);
    }

    @Override
    public String getDescription() {
        return "Library Card Request";
    }

    public String getStudentName() { return studentName; }
}
