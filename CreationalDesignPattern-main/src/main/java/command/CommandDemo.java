package command;

// Good demo: each request is a command object — flexible and extensible
public class CommandDemo {

    public static void main(String[] args) {
        StudentPortal portal = new StudentPortal();

        portal.submitRequest(new TranscriptRequest("Ram"));
        portal.submitRequest(new CertificateRequest("Ram"));
        portal.submitRequest(new IDCardRequest("Ram"));
        portal.submitRequest(new LibraryCardRequest("Ram"));
    }
}
