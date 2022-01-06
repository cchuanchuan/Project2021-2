public class Student extends People{

    private double score;

    public Student(String id, String name, double score) {
        super(id, name);
        this.score = score;
    }

    @Override
    public void show() {
        System.out.println("我是学生，我的学号是："+id+", 我的名字是： "+name+", 我的成绩: "+score);

    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
