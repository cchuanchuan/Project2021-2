
import java.time.LocalDate;

public class Person {
    private String name;
    private String birthdate;

    @Override
    public String toString() {
        return name + "(" + birthdate + ")";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public int calculateAge(){
        int nowYear = LocalDate.now().getYear();
        int birthYear = Integer.parseInt(birthdate.split("-")[0]);

        return nowYear-birthYear+1;
    }
}
//class Main {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//
//        System.out.println("Please enter your name: ");
//        String firstN = scan.nextLine();
//        System.out.print("Please enter date of birth（YYYY-MM-DD）: ");
//        String input = scan.nextLine();
//        LocalDate dob = LocalDate.parse(input);
//        Person p = new Person(firtN,dob);
//        p.getAge(dob);
//        //System.out.println(firstN+" ("+") "+ "Age is:" + getAge(dob));
//    }
//
//    public static int getAge(LocalDate dob) {
//        //write current date, current year and compare them to count the age.
//            //int year = LocalDate.now().getYear();
//            LocalDate curDate = LocalDate.now();
//            return Period.between(dob, curDate).getYears();
//
//
//    }
//
//}

