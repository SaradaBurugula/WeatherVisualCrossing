package apis;

import io.restassured.response.Response;
import org.example.Helpers.LocationInfo;
import org.example.apipath.APIPath;
import org.example.models.BaseRest;
import org.example.utils.LocationValidations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Reporter.log;

public class WeatherInformationByLocationTest extends BaseRest {
    String locationName, key;
    @BeforeClass()
    public void setBaseUri() throws Exception {
        setupServiceRequestSpecBuilder();
    }

    @DataProvider(name = "locationsData")
    public Object[][] locationsData() throws Exception {
        return new Object[][] { { testData.getProperty("api.location.name1").trim() },
                { testData.getProperty("api.location.name2").trim() }, { testData.getProperty("api.location.name3").trim() }};
    }
    @Test(priority = 1, dataProvider = "locationsData")
    public void weatherInfoByLoc( String locationName) throws IOException {
        //locationName=testData.getProperty("api.location.name");
        key=testData.getProperty("api.key");
        Response locResponse= LocationInfo.weatherLocInfo(locationName, key);
        if(locResponse.getStatusCode()==200)
        {
            log("Valid status code, got the response");
        }
        else
            log("Invalid status code");
        log("Validating response");
        LocationValidations.verifyLocationWeather(locResponse,locationName);
    }
}
