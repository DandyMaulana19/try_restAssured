package scenario;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import example.StaticProvider;
import io.restassured.RestAssured;
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

        System.out.println("Status code : " + response.getStatusCode());
        System.out.println("Fetch result : " + response.asPrettyString());

    }

    @Test(dataProvider = "AddObject", dataProviderClass = StaticProvider.class)
    public void AddObject(String name, int year, int price, String cpuModel, String hardDiskSize) {
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
        System.out.println("Status code : " + response.getStatusCode());
        System.out.println("Add Result : " + response.asPrettyString());

        JSONObject jsonResponse = new JSONObject(response.asString());

        Assert.assertNotNull(jsonResponse.getString("id"));
        Assert.assertEquals(jsonResponse.getJSONObject("data").getInt("year"), year);
        Assert.assertEquals(jsonResponse.getJSONObject("data").getString("CPU model"), cpuModel);
        Assert.assertEquals(jsonResponse.getJSONObject("data").getInt("price"), price);
        Assert.assertEquals(jsonResponse.getJSONObject("data").getString("Hard disk size"), hardDiskSize);

        idObject = jsonResponse.getString("id");

    }

    @Test(dataProvider = "UpdateObject", dataProviderClass = StaticProvider.class, dependsOnMethods = {
            "AddObject" }, priority = 1)
    public void UpdateObject(String name, int year, int price, String cpuModel, String hardDiskSize) {
        RestAssured.baseURI = "https://api.restful-api.dev/objects/" + idObject;
        RequestSpecification requestSpecification = RestAssured.given();

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
                .put();
        System.out.println("Status code : " + response.getStatusCode());
        System.out.println("Update Result : " + response.asPrettyString());

        JSONObject jsonResponse = new JSONObject(response.asString());

        Assert.assertNotNull(jsonObject, "id");
        Assert.assertEquals(jsonResponse.getJSONObject("data").getInt("year"), year);
        Assert.assertEquals(jsonResponse.getJSONObject("data").getInt("price"), price);
        Assert.assertEquals(jsonResponse.getJSONObject("data").getString("CPU model"), cpuModel);
        Assert.assertEquals(jsonResponse.getJSONObject("data").getString("Hard disk size"), hardDiskSize);
    }

    @Test(dependsOnMethods = { "AddObject" }, priority = 2)
    public void DeleteObject() {
        Response response = requestSpecification
                .pathParam("id", idObject)
                .contentType("Application/json")
                .delete("{id}");

        System.out.println("Status code : " + response.statusCode());
        System.out.println("Response : " + response.asPrettyString());

        JSONObject jsonResponse = new JSONObject(response.asString());

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals("Object with id = " + idObject + " has been deleted.", jsonResponse.getString("message"));
    }

    @Test(dependsOnMethods = { "DeleteObject" }, priority = 3)
    public void GetObjectById() {
        Response response = requestSpecification
                .pathParam("id", idObject)
                .get("{id}");

        System.out.println("Status Code : " + response.getStatusCode());
        System.out.println("Responnya adalah : " + response.asPrettyString());

        JSONObject jsonResponse = new JSONObject(response.asString());

        Assert.assertEquals(response.getStatusCode(), 404);
        Assert.assertEquals("Oject with id=" + idObject + " was not found.", jsonResponse.getString("error"));

    }

}
