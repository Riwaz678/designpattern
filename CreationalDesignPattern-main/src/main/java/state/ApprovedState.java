package state;

// Admission approved, moves to Enrolled
public class ApprovedState implements AdmissionState {

    @Override
    public void handle(AdmissionApplication application) {
        System.out.println("Admission approved. Enrolling student...");
        application.setState(new EnrolledState());
    }

    @Override
    public String getStatus() {
        return "APPROVED";
    }
}
