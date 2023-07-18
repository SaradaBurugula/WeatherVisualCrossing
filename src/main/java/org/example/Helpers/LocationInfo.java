package org.example.Helpers;

import io.restassured.response.Response;
import org.example.apipath.APIPath;
import org.example.models.BaseRest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class LocationInfo extends BaseRest {
    public static Response weatherLocInfo(String locName, String key) throws IOException {
        HashMap<String, Object> queryParamMap = new HashMap<String, Object>();
        queryParamMap.clear();
        queryParamMap.put("unitGroup", "metric");
        queryParamMap.put("key", key);
        queryParamMap.put("contentType", "json");
        String url = APIPath.weatherLocation(locName);
        return given().spec(requestSpec).queryParams(queryParamMap).when().get(url).then().extract().response();
    }
}
