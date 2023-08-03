package ui;

import org.example.objectmaps.WeatherLocationPage;
import org.testng.annotations.Test;


public class WeatherReports {
     @Test
    public void weatherDataValidations() throws Exception {
        WeatherLocationPage.launchUrl();
        WeatherLocationPage.loginWeatherData();
        WeatherLocationPage.weatherReport();
        WeatherLocationPage.locationMapValidation();
        WeatherLocationPage.closeDriver();
    }

    @Test
    public void countZeros()
    {
        // 10,20,30,...110
        int i=0;
        int count=0;
        while(i<=110)
        {
            if (i==0)
                count=0;
            else if(i%10==0)
            count++;
            i+=10;
        }
        System.out.println("counting 0: " + count);

    }
}
