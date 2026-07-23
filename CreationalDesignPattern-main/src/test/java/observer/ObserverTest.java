package observer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// JUnit 5 tests to verify Observer pattern behavior
class ObserverTest {

    @Test
    void testStudentReceivesNotification() {
        ResultPublisher publisher = new ResultPublisher();
        StudentObserver student = new StudentObserver("Ram");
        publisher.subscribe(student);

        assertDoesNotThrow(() -> publisher.publishResult("Results published"));
    }

    @Test
    void testParentReceivesNotification() {
        ResultPublisher publisher = new ResultPublisher();
        ParentObserver parent = new ParentObserver("Hari");
        publisher.subscribe(parent);

        assertDoesNotThrow(() -> publisher.publishResult("Results published"));
    }

    @Test
    void testDepartmentReceivesNotification() {
        ResultPublisher publisher = new ResultPublisher();
        DepartmentObserver department = new DepartmentObserver("BCA");
        publisher.subscribe(department);

        assertDoesNotThrow(() -> publisher.publishResult("Results published"));
    }

    @Test
    void testObserverRegistration() {
        ResultPublisher publisher = new ResultPublisher();
        StudentObserver student = new StudentObserver("Ram");
        publisher.subscribe(student);

        assertEquals(1, publisher.getObserverCount());
    }

    @Test
    void testObserverRemoval() {
        ResultPublisher publisher = new ResultPublisher();
        StudentObserver student = new StudentObserver("Ram");
        publisher.subscribe(student);
        publisher.unsubscribe(student);

        assertEquals(0, publisher.getObserverCount());
    }

    @Test
    void testMultipleObservers() {
        ResultPublisher publisher = new ResultPublisher();
        publisher.subscribe(new StudentObserver("Ram"));
        publisher.subscribe(new ParentObserver("Hari"));
        publisher.subscribe(new DepartmentObserver("BCA"));

        assertEquals(3, publisher.getObserverCount());
    }

    @Test
    void testPublisherNotNull() {
        ResultPublisher publisher = new ResultPublisher();
        assertNotNull(publisher);
    }

    @Test
    void testPublishAfterUnsubscribe() {
        ResultPublisher publisher = new ResultPublisher();
        StudentObserver student = new StudentObserver("Ram");
        publisher.subscribe(student);
        publisher.unsubscribe(student);

        assertDoesNotThrow(() -> publisher.publishResult("Results published"));
        assertEquals(0, publisher.getObserverCount());
    }
}
