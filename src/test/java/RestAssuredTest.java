
// import io.restassured.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredTest {

    // HIT API
    @Test
    public static void GetPhoto() {
        // Define URL
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/photos";
        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET, "");
        System.out.println("Response: " + response.asPrettyString());
        System.out.println("Status Code: " + response.statusCode());

        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
