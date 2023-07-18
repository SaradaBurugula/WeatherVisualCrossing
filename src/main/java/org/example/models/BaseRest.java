package org.example.models;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.example.apipath.APIPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;

import static com.sun.activation.registries.LogSupport.log;
import static io.restassured.RestAssured.given;

public class BaseRest{
    public static RequestSpecification requestSpec;
    public PropertyLoader testData;


    public void setupServiceRequestSpecBuilder() throws IOException {
        testData = new PropertyLoader();
        RestAssured.baseURI = testData.getProperty("api.url");
        requestSpec = new RequestSpecBuilder().setContentType(APIPath.CONTENT_TYPE)
                .addFilter(new ResponseLoggingFilter()).addFilter(new RequestLoggingFilter()).build();
    }

}
