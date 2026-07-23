package state;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// JUnit 5 tests to verify State pattern behavior
class StateTest {

    @Test
    void testInitialStateIsSubmitted() {
        AdmissionApplication app = new AdmissionApplication();
        assertEquals("SUBMITTED", app.getStatus());
    }

    @Test
    void testTransitionToVerified() {
        AdmissionApplication app = new AdmissionApplication();
        app.process();
        assertEquals("VERIFIED", app.getStatus());
    }

    @Test
    void testTransitionToApproved() {
        AdmissionApplication app = new AdmissionApplication();
        app.process();
        app.process();
        assertEquals("APPROVED", app.getStatus());
    }

    @Test
    void testTransitionToEnrolled() {
        AdmissionApplication app = new AdmissionApplication();
        app.process();
        app.process();
        app.process();
        assertEquals("ENROLLED", app.getStatus());
    }

    @Test
    void testStateObjectNotNull() {
        AdmissionState state = new SubmittedState();
        assertNotNull(state);
    }

    @Test
    void testRejectedState() {
        AdmissionApplication app = new AdmissionApplication();
        app.setState(new RejectedState());
        assertEquals("REJECTED", app.getStatus());
    }

    @Test
    void testRejectedStateHandle() {
        AdmissionApplication app = new AdmissionApplication();
        app.setState(new RejectedState());
        assertDoesNotThrow(app::process);
    }

    @Test
    void testEnrolledStateHandle() {
        AdmissionApplication app = new AdmissionApplication();
        app.setState(new EnrolledState());
        assertDoesNotThrow(app::process);
    }
}
