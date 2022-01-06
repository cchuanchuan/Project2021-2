import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    static List<User> userList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static Education education = new Education();

    public static void main(String[] args) {
        showMenu1();

    }


    public static void showMenu1(){
        System.out.println("欢迎登陆本系统");
        System.out.println("1.登陆");
        System.out.println("2.注册");
        String line = sc.nextLine();
        switch (line.trim()){
            case "1":{
                System.out.println("请输入用户名：");
                String username = sc.nextLine();
                System.out.println("请输入密码：");
                String password = sc.nextLine();
                User user = login(username,password);
                if (user != null){
                    System.out.println("登陆成功！");
                    showMenu2();
                }else {
                    System.out.println("用户名或密码错误，请重试！");
                    showMenu1();
                }


                break;
            }
            case "2":{
                System.out.println("请输入用户名：");
                String username = sc.nextLine();
                System.out.println("请输入密码：");
                String password = sc.nextLine();
                register(username,password);
                System.out.println("注册成功！");
                showMenu1();
                break;
            }
            default:{
                System.out.println("输入错误，请重新输入！");
                showMenu1();
            }
        }

    }

    private static void showMenu2() {

        System.out.println("欢迎登陆");
        System.out.println("1.录入数据");
        System.out.println("2.查看数据");
        System.out.println("3.查询");
        System.out.println("4.退出");
        String line = sc.nextLine();
        switch (line.trim()){
            case "1":{
                System.out.println("请输入学生学号：");
                String id = sc.nextLine();
                System.out.println("请输入学生姓名：");
                String name = sc.nextLine();
                System.out.println("请输入学生成绩：");
                String scoreStr = sc.nextLine();
                double score = Double.parseDouble(scoreStr);
                Student student = new Student(id,name,score);
                education.addStudent(student);
                System.out.println("录入数据成功！");

                showMenu2();
                break;
            }
            case "2":{
                for (Student s :
                        Education.studentList) {
                    s.show();
                }
                showMenu2();
                break;
            }
            case "3":{
                System.out.println("请输入学生学号：");
                String id = sc.nextLine();
                Student student = education.searchStudent(id);
                if (student != null){
                    student.show();
                }else {
                    System.out.println("查询失败！");
                }
                showMenu2();
                break;
            }
            case "4":{
                System.out.println("欢迎再次登陆！");
                break;
            }
            default:{
                System.out.println("输入错误，请重新输入！");
                showMenu2();
            }
        }
    }


    public static User login(String username, String password){
        for (User u :
                userList) {
            if (u.getUsername().equals(username)
            && u.getPassword().equals(password)){
                return u;
            }
        }
        return null;
    }

    public static void register(String username, String password){
        User user = new User(username,password);
        userList.add(user);
    }

}
