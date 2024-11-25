package scenario;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredTest {

    private static String idObject = "ff808181932badb601936263ba870d72";

    public static void main(String[] args) {
        // AddObject();
        UpdateObject();
    }

    // url = https://restful-api.dev/objects
    public static void GetAllObjects() {
        RestAssured.baseURI = "https://restful-api.dev";
        RequestSpecification requestSpecification = RestAssured.given();

        Response response = requestSpecification.get();

        System.out.println("Status Code : " + response.getStatusCode());
        System.out.println("Responnya adalah : " + response.asPrettyString());

    }

    public static void GetObjectById() {
        RestAssured.baseURI = "https://restful-api.dev/objects/3";
        RequestSpecification requestSpecification = RestAssured.given();

        // Response response = requestSpecification.get("/objects/1");
        Response response = requestSpecification
                .queryParam("id", 3)
                .queryParam("id", 10)
                .queryParam("id", 4)
                .get();

        System.out.println("Status Code : " + response.getStatusCode());
        System.out.println("Responnya adalah : " + response.asPrettyString());

        // convert to json format
        JsonPath JsonPath = response.jsonPath();

        System.out.println("Id:" + JsonPath.getString("id"));
        System.out.println("Name: " + JsonPath.getString("name"));
        System.out.println("Data: " + JsonPath.getString("data"));
    }

    // Deserialize

    /*
     * Class object{
     * int id;
     * String name;
     * Data data;
     * 
     * 
     * Object object = new Object();
     * id = object.id;
     * name = object.name;
     * data = object.data;
     * color = object.data.color;
     * capacity = object.data.capacity
     * 
     * {
     * "id": 1,
     * "name": "Object 1",
     * "data": {
     * "color": "value1",
     * "capacity": "value2"
     * }
     * }
     * }
     */

    public static void AddObject() {
        RestAssured.baseURI = "https://api.restful-api.dev/objects";
        RequestSpecification requestSpecification = RestAssured.given();

        String json = "{\n" + //
                "   \"name\": \"Apple MacBook Pro 16\",\n" + //
                "   \"data\": {\n" + //
                "      \"year\": 2019,\n" + //
                "      \"price\": 20000,\n" + //
                "      \"CPU model\": \"Intel Core i9\",\n" + //
                "      \"Hard disk size\": \"1 TB\"\n" + //
                "   }\n" + //
                "}";

        Response response = requestSpecification
                .body(json)
                .contentType("Application/json")
                .post();
        System.out.println("Status codenya adalah : " + response.getStatusCode());
        System.out.println("Responnya adalah : " + response.asPrettyString());

    }

    // update 1 data
    public static void UpdateObject() {
        RestAssured.baseURI = "https://api.restful-api.dev/objects/" + idObject;
        RequestSpecification requestSpecification = RestAssured.given();

        String json = "{\n" + //
                "   \"name\": \"Apple MacBook Pro 20\",\n" + //
                "   \"data\": {\n" + //
                "      \"year\": 2019,\n" + //
                "      \"price\": 20000,\n" + //
                "      \"CPU model\": \"Intel Core i9\",\n" + //
                "      \"Hard disk size\": \"1 TB\"\n" + //
                "   }\n" + //
                "}";

        Response response = requestSpecification
                .body(json)
                .contentType("Application/json")
                .put();
        System.out.println("Status codenya adalah : " + response.getStatusCode());
        System.out.println("Responnya adalah : " + response.asPrettyString());
    }

    // update bagian dari 1 data/partially
    public static void UpdatePartObject() {
        RestAssured.baseURI = "https://api.restful-api.dev/objects/" + idObject;
        RequestSpecification requestSpecification = RestAssured.given();

    }

    public static void DeleteObject() {
        RestAssured.baseURI = "https://api.restful-api.dev/objects/7";
        RequestSpecification requestSpecification = RestAssured.given();

        Response response = requestSpecification
                .pathParam("id", idObject)
                .contentType("Application/json")
                .delete();
    }

}
