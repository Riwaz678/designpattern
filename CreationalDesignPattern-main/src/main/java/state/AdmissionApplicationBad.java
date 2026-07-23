package state;

// Bad design: complex if-else based on status string — hard to maintain and extend
public class AdmissionApplicationBad {

    private String status = "SUBMITTED";

    public void process() {
        if (status.equals("SUBMITTED")) {
            System.out.println("Application submitted. Verifying documents...");
            status = "VERIFIED";
        } else if (status.equals("VERIFIED")) {
            System.out.println("Documents verified. Approving admission...");
            status = "APPROVED";
        } else if (status.equals("APPROVED")) {
            System.out.println("Admission approved. Enrolling student...");
            status = "ENROLLED";
        } else if (status.equals("ENROLLED")) {
            System.out.println("Student enrolled successfully!");
        } else if (status.equals("REJECTED")) {
            System.out.println("Admission rejected.");
        } else {
            throw new IllegalArgumentException("Invalid status: " + status);
        }
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
