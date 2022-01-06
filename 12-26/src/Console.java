import java.util.Scanner;

public class Console {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Exercises exercises = new Exercises();
        while (exercises.hasNext()){
            System.out.println(exercises.getEquation().getExpress() + " = ");
            int ans = Integer.parseInt(sc.nextLine());
            if (ans == exercises.getResult()){
                System.out.println("回答正确！");
            }else {
                System.out.println("回答错误，答案："+exercises.getResult());
            }
            exercises.nextEquation();
        }
    }
}
