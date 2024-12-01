package scenario;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import example.StaticProvider;
import io.restassured.RestAssured;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiTestE2E {

    private String idObject = "ff808181932badb60193811fc2fa5d1c";

    RequestSpecification requestSpecification;

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://api.restful-api.dev/objects";
        requestSpecification = RestAssured.given();
    }

    @Test
    public void GetAllObjects() {
        Response response = requestSpecification.get();

        System.out.println("Status Code : " + response.getStatusCode());
        System.out.println("Responnya adalah : " + response.asPrettyString());

    }

    @Test(dataProvider = "addObject", dataProviderClass = StaticProvider.class)
    public void AddObject(String name, int year, int price, String cpuModel, String hardDiskSize) {
        // String json = "{\n" + //
        // " \"name\": \"Apple MacBook Pro 16\",\n" + //
        // " \"data\": {\n" + //
        // " \"year\": 2019,\n" + //
        // " \"price\": 20000,\n" + //
        // " \"CPU model\": \"Intel Core i9\",\n" + //
        // " \"Hard disk size\": \"1 TB\"\n" + //
        // " }\n" + //
        // "}";

        JSONObject jsonObject = new JSONObject();
        JSONObject jsonData = new JSONObject();

        jsonObject.put("name", name);
        jsonData.put("year", year);
        jsonData.put("price", price);
        jsonData.put("CPU model", cpuModel);
        jsonData.put("Hard disk size", hardDiskSize);

        jsonObject.put("data", jsonData);

        Response response = requestSpecification
                .body(jsonObject.toString())
                .contentType("Application/json")
                .post();
        System.out.println("Status codenya adalah : " + response.getStatusCode());
        System.out.println("Responnya adalah : " + response.asPrettyString());

        JSONObject jsonResponse = new JSONObject(response.asString());

        Assert.assertNotNull(jsonResponse.getString("id"));
        Assert.assertEquals(jsonResponse.getJSONObject("data").getInt("year"), year);
        Assert.assertEquals(jsonResponse.getJSONObject("data").getString("CPU model"), cpuModel);
        Assert.assertEquals(jsonResponse.getJSONObject("data").getInt("price"), price);
        Assert.assertEquals(jsonResponse.getJSONObject("data").getString("Hard disk size"), hardDiskSize);

    }

    // public void main(String[] args) {
    // GetAllObjects();
    // GetObjectById();
    // AddObject();
    // UpdateObject();
    // DeleteObject();
    // }

    public void GetObjectById() {
        RestAssured.baseURI = "https://api.restful-api.dev/objects/3";
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

    // update 1 data
    public void UpdateObject() {
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

    public void DeleteObject() {
        RestAssured.baseURI = "https://api.restful-api.dev/objects/";
        RequestSpecification requestSpecification = RestAssured.given();

        Response response = requestSpecification
                .pathParam("id", idObject)
                .contentType("Application/json")
                .delete("{id}");

        System.out.println("Status code : " + response.statusCode());
        System.out.println("Response : " + response.asPrettyString());
    }

}
