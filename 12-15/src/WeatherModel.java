import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class WeatherModel {

    List<WeatherDay> weatherList;

    public WeatherModel(){
        weatherList = new ArrayList<>();
    }

    public void readYear(int year, String url) {
        try {

            URL WeatherURL = new URL(url);
            URLConnection weatherConnection = WeatherURL.openConnection();
            InputStreamReader weatherReader = new InputStreamReader(weatherConnection.getInputStream());
            BufferedReader weatherBuffer = new BufferedReader(weatherReader);

            String line = "";

            while ((line = weatherBuffer.readLine()) != null) {
                String[] dataString = line.split(",");
                WeatherDay weatherDay = new WeatherDay();
                weatherDay.setYear(year);

                try {
                    if (year <= 2006) {
                        weatherDay.setDay(Integer.parseInt(dataString[1].trim()));
                        weatherDay.setTime(dataString[2].trim());
                        weatherDay.setMeanWind(Double.parseDouble(dataString[3].trim()));
                        weatherDay.setT1(Double.parseDouble(dataString[8].trim()));
                        weatherDay.setT2(Double.parseDouble(dataString[9].trim()));

                    } else {
                        weatherDay.setDay(Integer.parseInt(dataString[0].trim()));
                        weatherDay.setTime(dataString[1].trim());
                        weatherDay.setMeanWind(Double.parseDouble(dataString[2].trim()));
                        weatherDay.setT1(Double.parseDouble(dataString[7].trim()));
                        weatherDay.setT2(Double.parseDouble(dataString[8].trim()));
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error data: " + line);
                    e.printStackTrace();
                    continue;
                }catch (Exception e){
                    System.out.println(line);
                    e.printStackTrace();
                    continue;
                }
                weatherList.add(weatherDay);
                System.out.println("Data read from URL: " + line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Success read data!");

    }


}

class WeatherDay {

    private int year;
    private int day;
    private String time;
    private Double meanWind = 0.0;
    private Double t1 = 0.0;
    private Double t2 = 0.0;

    public WeatherDay() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getMeanWind() {
        return meanWind;
    }

    public void setMeanWind(Double meanWind) {
        this.meanWind = meanWind;
    }

    public Double getT1() {
        return t1;
    }

    public void setT1(Double t1) {
        this.t1 = t1;
    }

    public Double getT2() {
        return t2;
    }

    public void setT2(Double t2) {
        this.t2 = t2;
    }
}
