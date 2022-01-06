import java.util.ArrayList;
import java.util.List;

public class Education {

    static List<Student> studentList = new ArrayList<>();

    //    有学生信息添加方法:
    public void addStudent(Student stu) {
        studentList.add(stu);
    }

    //    学生信息修改方法:
    public void modyStudent(Student stu) {
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            if (student.getId().equals(stu.getId())){
                student.setScore(stu.getScore());
                student.setName(stu.getName());
            }
        }
    }

    //    学生信息删除方法:
    public void removeStudent(String id) {
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            if (student.getId().equals(id)){
                studentList.remove(student);
                break;
            }
        }
    }

    //    学生信息查询方法:
    public Student searchStudent(String id) {
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            if (student.getId().equals(id)){
                return student;
            }
        }
        return null;
    }
}
