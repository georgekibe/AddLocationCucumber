package endpoints;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;
import pojo.serialization.Location;
import pojo.serialization.LocationDetails;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

/*

Adding location and using serialization using POJO classes to insert REST request Payload
This is the main classes

 */
public class AddLocationMain {


    @Test
    public void addingLocation() {

        // initialize the payload parameters using the pojo serialization
        LocationDetails locationDetails = new LocationDetails();

        Location location = new Location();
        location.setLat(-31.48488);
        location.setLng(75.51515);
        locationDetails.setLocation(location);

        locationDetails.setAccuracy(50);
        locationDetails.setName("Nairobi Kenya");
        locationDetails.setPhone_number("+254728852318");
        locationDetails.setAddress("Parklands, Nairobi");
        locationDetails.setWebsite("https://google.com");
        locationDetails.setLanguage("Kiswahili");

        List types = new ArrayList();
        types.add("shoe park");
        types.add("shop");
        locationDetails.setTypes(types);


        // request payload
        String addLocationResponse = given().log().all().queryParam("key", "qaclick123")
                .body(locationDetails)
                .when().post("https://rahulshettyacademy.com/maps/api/place/add/json")
                .then().assertThat().statusCode(200).extract().asString();
        System.out.println("The Response: " + addLocationResponse);


        // below using spec builder

        RequestSpecification requestSpecification = given().log().all().queryParam("key", "qaclick123")
                .body(locationDetails);
        ResponseSpecification  responseSpecification = (ResponseSpecification) (ResponseSpecification) requestSpecification.when().post("https://rahulshettyacademy.com/maps/api/place/add/json")
                .then().assertThat().statusCode(200).extract().response();

    }


}
