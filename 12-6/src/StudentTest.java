public class StudentTest {

    public static void main(String[] args) {
        Student student = new Student();
        student.setName("StudentName");
        student.setBirthdate("1999-01-02");
        student.setMajor("computer science");
        student.setGpa(99);
        System.out.println("Student Name:"+student.getName());
        System.out.println("Student BirthDate:"+student.getBirthdate());
        System.out.println("Student Major:"+student.getMajor());
        System.out.println("Student GPA:"+student.getGpa());
        System.out.println(student);
        System.out.println("Student GPA:"+student.convertGPA());
    }
}
