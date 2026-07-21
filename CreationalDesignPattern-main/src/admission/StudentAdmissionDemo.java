package admission;

import builder.Student;

public class StudentAdmissionDemo {

    public static void main(String[] args) {
        StudentAdmissionModule module = new StudentAdmissionModule();

        Student student = new Student.Builder()
                .studentId(101)
                .name("Ashim")
                .email("ashim@gmail.com")
                .phoneNumber("9800000000")
                .department("software engineering")
                .semester(5)
                .address("Balkumari")
                .guardianName("angela")
                .build();

        module.admitStudent(student, "EMAIL");
    }
}
