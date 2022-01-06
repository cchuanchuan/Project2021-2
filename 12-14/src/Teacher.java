public class Teacher extends People {


    public Teacher(String id, String name) {
        super(id, name);
    }


    @Override
    public void show() {
        System.out.println("我是老师，我的工号是： "+id+", 我的名字是: "+name);
    }

    public void setStudentScore(String id, double score) {
        Education education = new Education();
        Student student = education.searchStudent(id);
        if (student != null){
            student.setScore(score);
        }

    }

    //    学生成绩修改方法:
    public void modyStudentScore(String id, double score) {
        Education education = new Education();
        Student student = education.searchStudent(id);
        if (student != null){
            student.setScore(score);
        }

    }

    //    学生成绩查询方法:
    public void searchStudentScore(String id) {
        Education education = new Education();
        Student student = education.searchStudent(id);
        if (student != null){
            System.out.println("成绩为："+ id);
        }else {
            System.out.println("未查询到该学生！");
        }
    }
}
