import java.util.Scanner;

public class Student extends Person{
	private String major;
	private float gpa;

	@Override
	public String toString() {
		return super.toString()+":"+major+","+gpa;
	}

	public String convertGPA(){
		return gpa+"";
	}
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}
}
//
//public class Main {
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		System.out.println("Input number of students:");
//		int n = Integer.parseInt(in.nextLine().trim());
//		System.out.println("Input Student major:");
//        String major = in.nextLine();
//        System.out.print("Please enter date of birth (YYYY-MM-DD): ");
//        String input = in.nextLine();
//        System.out.print("What's your first name；");
//        String fN = in.nextLine();
//		Student stu = new Student();
//		for (int i = 0; i < n; i ++) {
//			stu.name = in.next();
//			stu.student_major = in.next();
//			stu.gpa = in.nextInt();
//			if (stu.gpa == 4.00) {
//				stu.gpa = "A";
//			}
//			if (stu.gpa >=3.00 && stu.gpa < 4.00) {
//				stu.gpa = "B";
//			}
//            if(stu.gpa>=2.00 && stu.gpa< 3.00){
//                stu.gpa = "C";
//            }
//            if(stu.gpa>=1.00 && stu.gpa <2.00){
//                stu.gpa = "D";
//            }
//            else{
//                stu.gpa = "F";
//            }
//		}
//		System.out.println(fN+"("+input+")"+major+" GPA: "+stu.gpa);
//		in.close();
//	}
//}