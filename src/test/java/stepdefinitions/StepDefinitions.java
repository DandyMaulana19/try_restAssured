package stepdefinitions;

import org.json.JSONObject;
import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import apiengine.Endpoints;
// import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.request.AddItem;
import model.response.ResponseItem;

public class StepDefinitions {

    RequestSpecification requestSpecification;
    String idObject;
    private AddItem addItem;
    private ResponseItem responseItem;

    // @Before
    // public void setUp() {
    // RestAssured.baseURI = "https://api.restful-api.dev/objects";
    // requestSpecification = RestAssured.given();
    // }

    @Given("A list of item are available")
    public void a_list_of_item_are_available() {
        // Initialize response using deserialize/reusable code
        Response response = Endpoints.getAllItems();

        System.out.println("Status code : " + response.getStatusCode());
        System.out.println("Fetch result : " + response.asPrettyString());

    }

    @When("I add item to list")
    public void i_add_item_to_list() throws JsonMappingException, JsonProcessingException {

        String json = "{\n" + //
                "   \"name\": \"Apple MacBook Pro 16\",\n" + //
                "   \"data\": {\n" + //
                "      \"year\": 2019,\n" + //
                "      \"price\": 20000,\n" + //
                "      \"CPU model\": \"Intel Core i9\",\n" + //
                "      \"Hard disk size\": \"1 TB\"\n" + //
                "   }\n" + //
                "}";

        // Using deserialize
        ObjectMapper objectMapper = new ObjectMapper();

        // Request using deserialize
        addItem = objectMapper.readValue(json, AddItem.class);

        // Initialize response manually
        // Response response = requestSpecification
        // .body(json)
        // .contentType("Application/json")
        // .post();

        // Initialize response using deserialize/reusable code
        Response response = Endpoints.addItem(json);

        // Response using deserialize
        JsonPath jsonPath = response.jsonPath();
        responseItem = jsonPath.getObject("", ResponseItem.class);

        // Assertion using deserialize
        Assert.assertNotNull(responseItem.id);
        Assert.assertEquals(responseItem.data.year, addItem.data.year);
        Assert.assertEquals(responseItem.data.cpuModel, addItem.data.cpuModel);
        Assert.assertEquals(responseItem.data.price, addItem.data.price);
        Assert.assertEquals(responseItem.data.hardDiskSize, addItem.data.hardDiskSize);

        idObject = responseItem.id;

        // Without deserialize / Manual
        // Its become redundant
        // JSONObject jsonResponse = new JSONObject(response.asString());
        // Assert.assertNotNull(jsonResponse.getString("id"));
        // Assert.assertEquals(jsonResponse.getJSONObject("data").getInt("year"), 2019);
        // Assert.assertEquals(jsonResponse.getJSONObject("data").getString("CPU
        // model"), "Intel Core i9");
        // Assert.assertEquals(jsonResponse.getJSONObject("data").getInt("price"),
        // 20000);
        // Assert.assertEquals(jsonResponse.getJSONObject("data").getString("Hard disk
        // size"), "1 TB");

        // idObject = jsonResponse.getString("id");

    }

    @When("The item is available")
    public void the_item_is_available() {
        // Inititalize response manually
        // Response response = requestSpecification.get();

        // Initialize response using deserialize/reusable code
        Response response = Endpoints.getItemById(idObject);

        System.out.println("Status code : " + response.getStatusCode());
        System.out.println("Fetch result : " + response.asPrettyString());

        // JSONObject jsonResponse = new JSONObject(response.asString());

        // Assert.assertEquals(response.getStatusCode(), 404);
        // Assert.assertEquals("Object with id=" + idObject + " was not found.",
        // jsonResponse.getString("error"));

    }

    @Then("I can update that item")
    public void i_can_update_that_item() {
        // Initialize endpoint manually
        // RestAssured.baseURI = "https://api.restful-api.dev/objects/" + idObject;
        // RequestSpecification requestSpecification = RestAssured.given();

        String json = "{\n" + //
                "   \"name\": \"Apple MacBook Pro 16\",\n" + //
                "   \"data\": {\n" + //
                "      \"year\": 2019,\n" + //
                "      \"price\": 20000,\n" + //
                "      \"CPU model\": \"Intel Core i9\",\n" + //
                "      \"Hard disk size\": \"1 TB\"\n" + //
                "   }\n" + //
                "}";

        // Initialize response manually
        // Response response = requestSpecification
        // .body(json)
        // .contentType("Application/json")
        // .put();

        Response response = Endpoints.updateItem(json, idObject);

        System.out.println("Status code : " + response.getStatusCode());
        System.out.println("Update Result : " + response.asPrettyString());

        JSONObject jsonResponse = new JSONObject(response.asString());

        Assert.assertNotNull(jsonResponse.getString("id"));
        Assert.assertEquals(jsonResponse.getJSONObject("data").getInt("year"), 2019);
        Assert.assertEquals(jsonResponse.getJSONObject("data").getInt("price"), 20000);
        Assert.assertEquals(jsonResponse.getJSONObject("data").getString("CPU model"), "Intel Core i9");
        Assert.assertEquals(jsonResponse.getJSONObject("data").getString("Hard disk size"), "1 TB");

    }

    @When("I delete that item")
    public void i_delete_that_item() {
        // Initialize response manually
        // Response response = requestSpecification
        // .pathParam("id", idObject)
        // .contentType("Application/json")
        // .delete("{id}");

        // Initialize response using deserialize/reusable code
        Response response = Endpoints.deleteItem(idObject);

        System.out.println("Status code : " + response.statusCode());
        System.out.println("Response : " + response.asPrettyString());

        JSONObject jsonResponse = new JSONObject(response.asString());

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals("Object with id = " + idObject + " has been deleted.", jsonResponse.getString("message"));
    }

    @Then("The item is not available")
    public void the_item_is_not_available() {

        // Initialize response manually
        // Response response = requestSpecification
        // .pathParam("id", idObject)
        // .get("{id}");

        Response response = Endpoints.getItemById(idObject);

        System.out.println("Status Code : " + response.getStatusCode());
        System.out.println("Responnya adalah : " + response.asPrettyString());

        JSONObject jsonResponse = new JSONObject(response.asString());

        Assert.assertEquals(response.getStatusCode(), 404);
        Assert.assertEquals("Oject with id=" + idObject + " was not found.", jsonResponse.getString("error"));

    }
}
