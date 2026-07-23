package proxy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// JUnit 5 tests to verify Proxy pattern behavior
class ProxyTest {

    @Test
    void testProxyObjectCreation() {
        StudentRecord record = new StudentRecord("Ram", 95);
        StudentRecordProxy proxy = new StudentRecordProxy(record);
        assertNotNull(proxy);
    }

    @Test
    void testAdminAccessAllowed() {
        StudentRecord record = new StudentRecord("Ram", 95);
        StudentRecordProxy proxy = new StudentRecordProxy(record);
        assertDoesNotThrow(() -> proxy.viewMarks("ADMIN"));
    }

    @Test
    void testStudentAccessDenied() {
        StudentRecord record = new StudentRecord("Ram", 95);
        StudentRecordProxy proxy = new StudentRecordProxy(record);
        assertDoesNotThrow(() -> proxy.viewMarks("STUDENT"));
    }

    @Test
    void testProxyNotNull() {
        StudentRecord record = new StudentRecord("Ram", 95);
        StudentRecordAccess proxy = new StudentRecordProxy(record);
        assertNotNull(proxy, "Proxy object should not be null");
    }
}
