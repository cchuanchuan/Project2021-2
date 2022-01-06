import javax.swing.*;
import java.awt.*;

public class WeatherView extends JFrame {

    JPanel menuPanel, resultPanel;
    JTextArea textArea;
    JButton buttonCheck;
    JComboBox<Integer> yearBox, beginDayBox, endDayBox;
    JComboBox<String> observationBox;
    WeatherController weatherController = new WeatherController();

    public WeatherView() {
        super("WeatherView");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        add(menuPanel = new JPanel(), "North");
        add(resultPanel = new JPanel(), "Center");
        resultPanel.setLayout(new GridLayout(1, 1));
        resultPanel.add(textArea = new JTextArea());
        menuPanel.add(yearBox = new JComboBox<>());
        menuPanel.add(beginDayBox = new JComboBox<>());
        menuPanel.add(endDayBox = new JComboBox<>());
        menuPanel.add(observationBox = new JComboBox<>());
        for (int i = 1999; i < 2007; i++) {
            yearBox.addItem(i);
        }
        for (int i = 1; i <= 365; i++) {
            beginDayBox.addItem(i);
            endDayBox.addItem(i);
        }
        observationBox.addItem("temperature");
        observationBox.addItem("wind speed");

        menuPanel.add(buttonCheck = new JButton("Check"));
        buttonCheck.addActionListener(e -> {

            JOptionPane.showMessageDialog(null, "Please wait the program read data from remote,this may need some time!");

            String res = weatherController.checkWeather((Integer) yearBox.getSelectedItem(),
                    (Integer) beginDayBox.getSelectedItem(),
                    (Integer) endDayBox.getSelectedItem(),
                    observationBox.getSelectedIndex() == 1);
            textArea.append(res + "\n");
        });

        setVisible(true);
    }

}
