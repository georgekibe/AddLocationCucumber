package stepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.serialization.Location;
import pojo.serialization.LocationDetails;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

import static org.junit.Assert.*;

public class StepDefination {

    RequestSpecification request;
    Response response;

    @Given("Add Place Payload")
    public void add_place_payload() {
        // Write code here that turns the phrase above into concrete actions
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

        RequestSpecification requestSpecification = new RequestSpecBuilder().addQueryParam("key","qaclick123").
                setBaseUri("https://rahulshettyacademy.com").
                setContentType( ContentType.JSON).build();

         request = given().log(). all().spec(requestSpecification).body(locationDetails);


    }
    @When("User Calls the AddPlace with http request")
    public void user_calls_the_add_place_with_http_request() {
        // Write code here that turns the phrase above into concrete actions
        response = request.when().post("/maps/api/place/add/json").
                then().assertThat().statusCode(200).extract().response();
    }
    @Then("the API call got success with status code {int}")
    public void the_api_call_got_success_with_status_code(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
       assertEquals(response.getStatusCode(), 200);
    }
    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyValue, String expectedValue) {
        // Write code here that turns the phrase above into concrete actions
        String res = response.asString();
        JsonPath js = new JsonPath(res);

        assertEquals (js.getString(keyValue), expectedValue);
    }
}
