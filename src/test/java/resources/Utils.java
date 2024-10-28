package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Utils {


    public RequestSpecification requestSpecification() throws FileNotFoundException {

        PrintStream printStream = new PrintStream( new FileOutputStream("log.txt"));

        RequestSpecification requestSpecification = new RequestSpecBuilder().addQueryParam("key","qaclick123").
                setBaseUri("https://rahulshettyacademy.com").
                addFilter(RequestLoggingFilter.logRequestTo(printStream)). //logging externally
                addFilter(ResponseLoggingFilter.logResponseTo(printStream)).
                setContentType( ContentType.JSON).build();

        return requestSpecification;

    }
}
