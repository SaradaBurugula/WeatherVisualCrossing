package org.example.apipath;

import io.restassured.RestAssured;

public class APIPath {

    public static final String CONTENT_TYPE = "application/json";
       public static final String weatherLocation(String locId) {
        return "/services/timeline/"+locId;
    }
}
