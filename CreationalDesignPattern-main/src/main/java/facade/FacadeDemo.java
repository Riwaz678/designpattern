package facade;

// Good demo: facade hides complexity behind one simple method call
public class FacadeDemo {

    public static void main(String[] args) {
        StudentRegistrationFacade facade = new StudentRegistrationFacade();
        facade.register("Ram", "S101");
    }
}
