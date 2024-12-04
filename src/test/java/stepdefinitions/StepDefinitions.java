package stepdefinitions;

import org.json.JSONObject;
import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDefinitions {

    RequestSpecification requestSpecification;

    String idObject;

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://api.restful-api.dev/objects";
        requestSpecification = RestAssured.given();
    }

    @Given("A list of item are available")
    public void a_list_of_item_are_available() {
        Response response = requestSpecification.get();

        System.out.println("Status code : " + response.getStatusCode());
        System.out.println("Fetch result : " + response.asPrettyString());

        throw new io.cucumber.java.PendingException();
    }

    @When("I add item to list")
    public void i_add_item_to_list() {

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
                .body(json.toString())
                .contentType("Application/json")
                .post();

        JSONObject jsonResponse = new JSONObject(response.asString());

        Assert.assertNotNull(jsonResponse.getString("id"));
        Assert.assertEquals(jsonResponse.getJSONObject("data").getInt("year"), 2019);
        Assert.assertEquals(jsonResponse.getJSONObject("data").getString("CPU model"), "Intel Core i9");
        Assert.assertEquals(jsonResponse.getJSONObject("data").getInt("price"), 20000);
        Assert.assertEquals(jsonResponse.getJSONObject("data").getString("Hard disk size"), "1 TB");

        throw new io.cucumber.java.PendingException();
    }

    @When("The item is available")
    public void the_item_is_available() {
        Response response = requestSpecification.get();

        System.out.println("Status code : " + response.getStatusCode());
        System.out.println("Fetch result : " + response.asPrettyString());

        JSONObject jsonResponse = new JSONObject(response.asString());

        Assert.assertEquals(response.getStatusCode(), 404);
        Assert.assertEquals("Object with id=" + idObject + " was not found.", jsonResponse.getString("error"));

        throw new io.cucumber.java.PendingException();
    }

    @Then("I can update that item")
    public void i_can_update_that_item() {
        RestAssured.baseURI = "https://api.restful-api.dev/objects/" + idObject;
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
                .body(json.toString())
                .contentType("Application/json")
                .put();
        System.out.println("Status code : " + response.getStatusCode());
        System.out.println("Update Result : " + response.asPrettyString());

        JSONObject jsonResponse = new JSONObject(response.asString());

        Assert.assertNotNull(jsonResponse.getString("id"));
        Assert.assertEquals(jsonResponse.getJSONObject("data").getInt("year"), 2019);
        Assert.assertEquals(jsonResponse.getJSONObject("data").getInt("price"), 20000);
        Assert.assertEquals(jsonResponse.getJSONObject("data").getString("CPU model"), "Intel Core i9");
        Assert.assertEquals(jsonResponse.getJSONObject("data").getString("Hard disk size"), "1 TB");

        throw new io.cucumber.java.PendingException();
    }

    @When("I delete that item")
    public void i_delete_that_item() {
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

    @Then("The item isn't available")
    public void the_item_isn_t_available() {

        Response response = requestSpecification
                .pathParam("id", idObject)
                .get("{id}");

        System.out.println("Status Code : " + response.getStatusCode());
        System.out.println("Responnya adalah : " + response.asPrettyString());

        JSONObject jsonResponse = new JSONObject(response.asString());

        Assert.assertEquals(response.getStatusCode(), 404);
        Assert.assertEquals("Oject with id=" + idObject + " was not found.", jsonResponse.getString("error"));

        throw new io.cucumber.java.PendingException();
    }
}
