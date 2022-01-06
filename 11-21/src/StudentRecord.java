import javax.swing.*;
import java.awt.event.ActionEvent;

public class StudentRecord extends JFrame {
    Student[] studentArray;

    private JPanel panel1,panel2,panel3;
    private JButton button1,button2,button3;
    private JTextField textField1,textField2;
    private JTextArea textArea;

    public StudentRecord(){
        super("Student Searcher and Sorter");
        this.setSize(650,700);

        panel1 = new JPanel();
        panel1.add(button1 = new JButton("Load Data"));
        panel1.add(button2 = new JButton("Sort Records"));
        panel1.add(button3 = new JButton("Find Student by ID"));
        panel1.add(textField1 = new JTextField(15));
        panel1.setBorder(BorderFactory.createTitledBorder("Control Panel"));
        add(panel1,"North");

        panel2 = new JPanel();
        panel2.add(textField2 = new JTextField(50));
        textField2.setEditable(false);
        panel2.setBorder(BorderFactory.createTitledBorder("Invidiual Student Record"));
        add(panel2,"Center");

        panel3 = new JPanel();
        textArea = new JTextArea(31,50);
        panel3.add(new JScrollPane(textArea));
        textArea.setEditable(false);
        panel3.setBorder(BorderFactory.createTitledBorder("All Student Records"));
        add(panel3,"South");

        button1.addActionListener((ActionEvent event)->{
            studentArray = Student.readFromFile("MOCK_DATA.csv");
            displayAllRecords();
        });

        button2.addActionListener((ActionEvent event) ->{
            Student.sort(studentArray);
            displayAllRecords();
        });

        button3.addActionListener((ActionEvent event) -> {
            Student student = new Student(Integer.parseInt(textField1.getText()),"","",0);
            int i = Student.search(studentArray,student);
            if (i != -1){
                this.textField2.setText(studentArray[i].toString());
            }
        });


        this.setVisible(true);






    }

    private void displayAllRecords(){
        StringBuilder sb = new StringBuilder();

        for (Student s :
                studentArray) {
            sb.append(s.toString() + "\n");
        }
        this.textArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        new StudentRecord();
    }
}
