/******************************************
 A Java program to demonstrate data 
 retrieval from a URL.
 
 Written by: Richard Clayton
 Version 1.0
 Date November 2021
 
 Note that this code uses a try-catch block.
 You can read more about these at:
 https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html
*******************************************/


// import libraries for IO and URL handling
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLtest{
    public static void main(String[] args){



        try{
            URL WeatherURL = new URL("https://cairngormweather.eps.hw.ac.uk/2002/data2002.txt");
            URLConnection weatherConnection = WeatherURL.openConnection();
            InputStreamReader weatherReader = new InputStreamReader(weatherConnection.getInputStream());
            BufferedReader weatherBuffer = new BufferedReader(weatherReader);

            String line = "";

            while ((line = weatherBuffer.readLine()) != null) {
                String[] dataString = line.split(",");
                System.out.println("Data read from URL: "+ line);
                
                for (int i = 0; i < dataString.length; i++) {
                    System.out.println("Field: "+ i +" contains: "+ dataString[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
