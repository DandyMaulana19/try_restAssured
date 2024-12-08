package apiengine;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Endpoints {
    public static final String BASE_URL = "https://api.restful-api.dev/objects";
    public static RequestSpecification requestSpecification;

    public static Response getAllItems() {
        RestAssured.baseURI = BASE_URL;
        requestSpecification = RestAssured.given();
        Response response = requestSpecification.get();

        return response;
    }

    public static Response addItem(String json) {
        Response response = requestSpecification
                .body(json)
                .contentType("Application/json")
                .post();

        return response;
    }

    public static Response getItemById(String idObject) {
        Response response = requestSpecification
                .queryParam("id", idObject)
                .get();

        return response;
    }

    public static Response updateItem(String payload, String idObject) {
        RestAssured.baseURI = BASE_URL + "/" + idObject;

        Response response = requestSpecification
                .body(payload)
                .contentType("Application/json")
                .put();

        return response;
    }

    public static Response deleteItem(String idObject) {
        Response response = requestSpecification
                .pathParam("id", idObject)
                .contentType("Application/json")
                .delete("{id}");

        return response;
    }

}
