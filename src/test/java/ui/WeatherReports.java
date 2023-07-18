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
}
