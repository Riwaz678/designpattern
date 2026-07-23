package command;

// Concrete command — certificate request
public class CertificateRequest implements RequestCommand {

    private String studentName;

    public CertificateRequest(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public void execute() {
        System.out.println("Certificate request processed for: " + studentName);
    }

    @Override
    public String getDescription() {
        return "Certificate Request";
    }

    public String getStudentName() { return studentName; }
}
