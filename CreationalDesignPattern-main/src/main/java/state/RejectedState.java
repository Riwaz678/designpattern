package state;

// Rejected state — admission rejected
public class RejectedState implements AdmissionState {

    @Override
    public void handle(AdmissionApplication application) {
        System.out.println("Admission rejected.");
    }

    @Override
    public String getStatus() {
        return "REJECTED";
    }
}
