package state;

// Documents verified, moves to Approved
public class VerifiedState implements AdmissionState {

    @Override
    public void handle(AdmissionApplication application) {
        System.out.println("Documents verified. Approving admission...");
        application.setState(new ApprovedState());
    }

    @Override
    public String getStatus() {
        return "VERIFIED";
    }
}
