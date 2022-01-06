import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Student implements Comparable<Student>{

    private int id;
    private String firstName;
    private String lastName;
    private int grade;

    public Student(int id, String firstName, String lastName, int grade) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public static void main(String[] args) {
        readFromFile("MOCK_DATA.csv");
    }

    public static Student[] readFromFile(String filePath){
        try {
            List<String> list = Files.readAllLines(Paths.get(filePath));
            Student[] students = new Student[list.size()];

            int count = 0;
            for (String s :
                    list) {
                String strs[] = s.split(",");
                Student student = new Student(Integer.parseInt(strs[0]),
                        strs[1],strs[2],Integer.parseInt(strs[3]));
                students[count++] = student;
            }

            return students;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }


    @Override
    public int compareTo(Student s) {
        return grade-s.grade;
    }

    public String toString(){
        return id+","+firstName+","+lastName+","+grade;
    }
    
    public static void sort(Student[] students){
        for (int i = 0; i < students.length-1; i++) {
            for (int j = 0; j < students.length - i - 1; j++) {
                Student tmp = students[j];
                if (tmp.compareTo(students[j+1]) > 0){
                    students[j] = students[j+1];
                    students[j+1] = tmp;
                }
            }
        }
    }

    public static int search(Student[] students, Student s){
//        int left = 0,right = students.length-1;
//        while (left<right){
//            int mid = left+right/2;
//            if (students[mid].compareTo(s) == 0){
//                return mid;
//            }else if (students[mid].compareTo(s) > 0){
//                right = mid;
//            }else {
//                left = mid;
//            }
//        }
//        return -1;

        for (int i = 0; i < students.length; i++) {
            if (students[i].id == s.id){
                return i;
            }
        }
        return -1;
    }
}
