package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {


    public RequestSpecification requestSpecification() throws IOException {

        PrintStream printStream = new PrintStream( new FileOutputStream("log.txt"));

        RequestSpecification requestSpecification = new RequestSpecBuilder().addQueryParam("key","qaclick123").
                setBaseUri(getGlobalValues("baseUrl")).
                addFilter(RequestLoggingFilter.logRequestTo(printStream)). //logging externally
                addFilter(ResponseLoggingFilter.logResponseTo(printStream)).
                setContentType( ContentType.JSON).build();

        return requestSpecification;

    }

    public String getGlobalValues(String key) throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("E:\\Stuff\\Study\\API Testing\\AddLocationCucumber\\src\\test\\java\\resources\\global.properties");
        properties.load(fileInputStream);


        return (properties.getProperty(key));
    }
}
