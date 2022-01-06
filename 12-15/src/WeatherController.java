import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public class WeatherController {
    WeatherModel weatherModel = new WeatherModel();

    public String checkWeather(int year, int beginDay, int endDay,boolean isWind){
        String url = "";
        for (String s :
                urls) {
            if (s.contains(year+"")){
                url = s;
                break;
            }
        }
        weatherModel.readYear(year,url);
        List<WeatherDay> dataList = weatherModel.weatherList.stream().filter(weatherDay ->
            weatherDay.getDay()>=beginDay&& weatherDay.getDay()<=endDay
        ).collect(Collectors.toList());
        if (dataList.size() == 0) {
            JOptionPane.showMessageDialog(null,"There is no suitable value!");
        }

        if (isWind){
            OptionalDouble max = dataList.stream().mapToDouble(WeatherDay::getMeanWind).max();
            OptionalDouble min = dataList.stream().mapToDouble(WeatherDay::getMeanWind).min();
            OptionalDouble mean = dataList.stream().mapToDouble(WeatherDay::getMeanWind).average();

            return "wind speed: maximum: "+(max.isPresent()?max.getAsDouble():0.0)
                    +", minimum: "+(min.isPresent()?min.getAsDouble():0.0)
                    +"mean: "+(mean.isPresent()?mean.getAsDouble():0.0);
        }else {
            OptionalDouble max = dataList.stream().mapToDouble(WeatherDay::getT1).max();
            OptionalDouble min = dataList.stream().mapToDouble(WeatherDay::getT1).min();
            OptionalDouble mean = dataList.stream().mapToDouble(WeatherDay::getT1).average();

            return "temperature: maximum: "+(max.isPresent()?max.getAsDouble():0.0)
                    +", minimum: "+(min.isPresent()?min.getAsDouble():0.0)
                    +"mean: "+(mean.isPresent()?mean.getAsDouble():0.0);
        }

    }

    private final String[] urls = {
            "https://cairngormweather.eps.hw.ac.uk/1990/data1990.txt",
            "https://cairngormweather.eps.hw.ac.uk/1991/data1991.txt",
            "https://cairngormweather.eps.hw.ac.uk/1992/data1992.txt",
            "https://cairngormweather.eps.hw.ac.uk/1993/data1993.txt",
            "https://cairngormweather.eps.hw.ac.uk/1994/data1994.txt",
            "https://cairngormweather.eps.hw.ac.uk/1995/data1995.txt",
            "https://cairngormweather.eps.hw.ac.uk/1996/data1996.txt",
            "https://cairngormweather.eps.hw.ac.uk/1997/data1997.txt",
            "https://cairngormweather.eps.hw.ac.uk/1998/data1998.txt",
            "https://cairngormweather.eps.hw.ac.uk/1999/data1999.txt",
            "https://cairngormweather.eps.hw.ac.uk/2000/data2000.txt",
            "https://cairngormweather.eps.hw.ac.uk/2001/data2001.txt",
            "https://cairngormweather.eps.hw.ac.uk/2002/data2002.txt",
            "https://cairngormweather.eps.hw.ac.uk/2003/data2003.txt",
            "https://cairngormweather.eps.hw.ac.uk/2004/data2004.txt",
            "https://cairngormweather.eps.hw.ac.uk/2005/data2005.txt",
            "https://cairngormweather.eps.hw.ac.uk/2006/YEARDATA2006.txt",
            "https://cairngormweather.eps.hw.ac.uk/2007/YEARDATA2007.txt",
            "https://cairngormweather.eps.hw.ac.uk/2008/YEARDATA2008.txt",
            "https://cairngormweather.eps.hw.ac.uk/2009/2009.txt",
            "https://cairngormweather.eps.hw.ac.uk/2010/2010%20Data.txt",
            "https://cairngormweather.eps.hw.ac.uk/2011/2011%20Data.txt",
            "https://cairngormweather.eps.hw.ac.uk/2012/Data%202012.txt",
            "https://cairngormweather.eps.hw.ac.uk/2013/CurrentYear%20(partial).txt",
            "https://cairngormweather.eps.hw.ac.uk/2014/YEARDATA2014.DAT",
            "https://cairngormweather.eps.hw.ac.uk/2015/YEARDATA2015.txt",
            "https://cairngormweather.eps.hw.ac.uk/2016/YEARDATA%202016.txt"
    };


    public static void main(String[] args) {
        WeatherView weatherView = new WeatherView();
    }
}
