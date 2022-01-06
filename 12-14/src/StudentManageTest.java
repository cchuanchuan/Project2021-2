public class StudentManageTest {


    public static void main(String[] args) {
        Student student1 = new Student("s001","student1",96);
        Student student2 = new Student("s002","student2",70);
        Student student3 = new Student("s003","student3",98);
        Student student4 = new Student("s004","student4",80);
        Education education = new Education();
        // 学生信息添加
        education.addStudent(student1);
        education.addStudent(student2);
        education.addStudent(student3);
        education.addStudent(student4);
        System.out.println("当前学生信息：");
        for (Student s :
                Education.studentList) {
            s.show();
        }

        // 学生信息修改
        Student updateStudent = new Student("s001","sss",100);
        education.modyStudent(updateStudent);
        System.out.println("当前学生信息：");
        for (Student s :
                Education.studentList) {
            s.show();
        }

        // 学生信息删除
        education.removeStudent("s004");
        System.out.println("当前学生信息：");
        for (Student s :
                Education.studentList) {
            s.show();
        }

        // 学生信息查询
        Student student = education.searchStudent("s001");
        student.show();

        // 教师修改学生信息
        Teacher teacher = new Teacher("t001","teacher1");
        teacher.modyStudentScore("s001",10);

        // 教师查询学生成绩
        teacher.searchStudentScore("s001");

        // 教师设置学生信息
        teacher.setStudentScore("s001",50);

        // 教师查询学生成绩
        teacher.searchStudentScore("s001");


    }
}
