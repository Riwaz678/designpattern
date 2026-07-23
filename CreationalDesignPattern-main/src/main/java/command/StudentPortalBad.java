package command;

// Bad design: hardcoded request handling in if-else — adding a new request requires modifying this class
public class StudentPortalBad {

    public void processRequest(String type, String studentName) {
        if (type.equalsIgnoreCase("TRANSCRIPT")) {
            System.out.println("Transcript request processed for: " + studentName);
        } else if (type.equalsIgnoreCase("CERTIFICATE")) {
            System.out.println("Certificate request processed for: " + studentName);
        } else if (type.equalsIgnoreCase("IDCARD")) {
            System.out.println("ID Card request processed for: " + studentName);
        } else if (type.equalsIgnoreCase("LIBRARY")) {
            System.out.println("Library Card request processed for: " + studentName);
        } else {
            throw new IllegalArgumentException("Invalid request type: " + type);
        }
    }
}
