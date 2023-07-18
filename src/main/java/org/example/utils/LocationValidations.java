package org.example.utils;

import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;

import static org.testng.Reporter.log;

public class LocationValidations {
    public static void verifyLocationWeather(Response locResponse, String locname ) {

           String locationName = locResponse.jsonPath().get("address");
           String resolvedAddress=locResponse.jsonPath().get("resolvedAddress");
            if (locationName.equals(locname) && resolvedAddress.contains(locname))
                log(locationName+" is matched with response");
            else
                log(locationName+" is not matched with response");
       }

}
