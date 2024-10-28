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
import resources.TestDataBuild;
import resources.Utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

import static org.junit.Assert.*;

public class StepDefination extends Utils {

    RequestSpecification request;
    Response response;

    @Given("Add Place Payload with {string} {string} {string}")
    public void add_place_payload_with(String name, String language, String address) throws IOException {
        // Write code here that turns the phrase above into concrete actions
        TestDataBuild testDataBuild = new TestDataBuild();

        request = given().spec(requestSpecification()).body(testDataBuild.addPlacePayload(name, language, address));
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
