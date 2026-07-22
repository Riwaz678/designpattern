package facade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// JUnit 5 tests to verify Facade pattern behavior
class FacadeTest {

    @Test
    void testFacadeObjectCreation() {
        StudentRegistrationFacade facade = new StudentRegistrationFacade();
        assertNotNull(facade);
    }

    @Test
    void testRegistrationSuccess() {
        StudentRegistrationFacade facade = new StudentRegistrationFacade();
        boolean result = facade.register("Ram", "S101");
        assertTrue(result);
    }

    @Test
    void testRegistrationFailsWithEmptyName() {
        StudentRegistrationFacade facade = new StudentRegistrationFacade();
        boolean result = facade.register("", "S101");
        assertFalse(result);
    }

    @Test
    void testRegistrationFailsWithEmptyId() {
        StudentRegistrationFacade facade = new StudentRegistrationFacade();
        boolean result = facade.register("Ram", "");
        assertFalse(result);
    }
}
