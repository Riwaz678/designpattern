package command;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// JUnit 5 tests to verify Command pattern behavior
class CommandTest {

    @Test
    void testTranscriptRequest() {
        TranscriptRequest request = new TranscriptRequest("Ram");
        assertDoesNotThrow(request::execute);
    }

    @Test
    void testCertificateRequest() {
        CertificateRequest request = new CertificateRequest("Ram");
        assertDoesNotThrow(request::execute);
    }

    @Test
    void testIDCardRequest() {
        IDCardRequest request = new IDCardRequest("Ram");
        assertDoesNotThrow(request::execute);
    }

    @Test
    void testLibraryCardRequest() {
        LibraryCardRequest request = new LibraryCardRequest("Ram");
        assertDoesNotThrow(request::execute);
    }

    @Test
    void testCommandNotNull() {
        RequestCommand command = new TranscriptRequest("Ram");
        assertNotNull(command);
    }

    @Test
    void testPortalRequestCount() {
        StudentPortal portal = new StudentPortal();
        portal.submitRequest(new TranscriptRequest("Ram"));
        portal.submitRequest(new CertificateRequest("Ram"));
        assertEquals(2, portal.getRequestCount());
    }

    @Test
    void testCommandDescription() {
        TranscriptRequest transcript = new TranscriptRequest("Ram");
        assertEquals("Transcript Request", transcript.getDescription());

        CertificateRequest cert = new CertificateRequest("Ram");
        assertEquals("Certificate Request", cert.getDescription());

        IDCardRequest id = new IDCardRequest("Ram");
        assertEquals("ID Card Request", id.getDescription());

        LibraryCardRequest lib = new LibraryCardRequest("Ram");
        assertEquals("Library Card Request", lib.getDescription());
    }

    @Test
    void testPortalNotNull() {
        StudentPortal portal = new StudentPortal();
        assertNotNull(portal);
    }
}
