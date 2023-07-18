package org.example.objectmaps;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.models.PropertyLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Reporter.log;

public class WeatherLocationPage {
    static PropertyLoader testData;
    static ChromeDriver driver = new ChromeDriver();
    private static WebElement acceptCookieButton;
    private static WebElement signInButton;
    private static WebElement exampleInputEmail1;
    private static WebElement exampleInputPassword1;
    private static WebElement signInButtonmodel;
    private static WebElement weatherOption;
    private static WebElement weatherLoc;
    private static WebElement weatherLocSearch;
    private static WebElement locationValue;
    private static List<WebElement> locationList;

    public static void launchUrl() throws IOException, InterruptedException {
        testData = new PropertyLoader();
        WebDriverManager.chromedriver().setup();
        driver.get(testData.getProperty("weather.url"));
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        acceptCookieButton = driver.findElement(By.xpath("//button[text()='Accept all cookies']"));
        wait.until(ExpectedConditions.visibilityOf(acceptCookieButton));
        acceptCookieButton.click();
    }

    public static void loginWeatherData() throws IOException {
        System.out.println("Login Initiated");
        testData = new PropertyLoader();
        signInButton = driver.findElement(By.xpath("//span[normalize-space(text())='Sign in']"));
        signInButton.click();
        exampleInputEmail1 = driver.findElement(By.id("exampleInputEmail1"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOf(exampleInputEmail1));
        exampleInputEmail1.sendKeys(testData.getProperty("user.email"));
        exampleInputPassword1 = driver.findElement(By.id("exampleInputPassword1"));
        exampleInputPassword1.sendKeys(testData.getProperty("user.password"));
        signInButtonmodel = driver.findElement(By.xpath("//button[normalize-space(text())='Sign in']"));
        signInButtonmodel.click();
        System.out.println("Login Successful");
    }

    public static void weatherReport() throws IOException {
        testData = new PropertyLoader();
        String locName = testData.getProperty("api.location.name1");
        weatherOption = driver.findElement(By.xpath("//li[@class='nav-item']/a[text()='Weather Data']"));
        weatherOption.click();
        weatherLoc = driver.findElement(By.xpath("//input[@id='wxlocation']"));
        weatherLoc.sendKeys(locName);
        weatherLocSearch = driver.findElement(By.xpath("//button[text()='Search']"));
        weatherLocSearch.click();
        locationValue = driver.findElement(By.id("locationDropdownMenuButton"));
        if (locName.equals(locationValue.getText())) {
            System.out.println("location name is matched with " + locName);
        } else {
            System.out.println("location name is not matched with " + locName);
        }
    }

    public static void locationMapValidation() throws IOException, InterruptedException {
        System.out.println("Location and station map");
        testData = new PropertyLoader();
        Thread.sleep(1000);
        locationList = driver.findElements(By.xpath("//div[@class='widget twocols']//td"));
        ArrayList<String> locationMapValues = new ArrayList<>();
        locationMapValues.clear();
        locationMapValues.add(testData.getProperty("hyd.location.name1"));
        locationMapValues.add(testData.getProperty("hyd.location.name2"));
        locationMapValues.add(testData.getProperty("hyd.location.name3"));
        locationMapValues.add(testData.getProperty("hyd.location.name4"));
        locationMapValues.add(testData.getProperty("hyd.location.name5"));
        for (String locationMapValueEle : locationMapValues) {
            for (WebElement locElement : locationList) {
                if (locationMapValueEle.equals(locElement.getText()))
                    System.out.println("location name is matched with " + locElement.getText());
            }
        }
    }

    public static void closeDriver() {
        driver.quit();
    }
}
