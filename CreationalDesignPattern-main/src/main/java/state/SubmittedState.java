package state;

// Initial state — application submitted, moves to Verified
public class SubmittedState implements AdmissionState {

    @Override
    public void handle(AdmissionApplication application) {
        System.out.println("Application submitted. Verifying documents...");
        application.setState(new VerifiedState());
    }

    @Override
    public String getStatus() {
        return "SUBMITTED";
    }
}
