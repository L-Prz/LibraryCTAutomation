package LibraryApp.steps.api;

import LibraryApp.utilities.APITestBase;
import LibraryApp.utilities.ConfigurationReader;
import LibraryApp.utilities.DB_Utils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;


import java.util.List;

import static io.restassured.RestAssured.given;

public class US1_Book_Categories_Match_API_And_Database extends APITestBase {

    List<String> expectedBookCategories;
    @When("GET request sent to {string} endpoint")
    public void get_request_sent_to_endpoint(String string) {
        given().accept(ContentType.JSON)
                .header("x-library-token", token).when().get(ConfigurationReader.getProperty("baseURI") +getBookCategoriesEndpoint);

    }
    @When("api returns book categories")
    public void api_returns_book_categories() {
        JsonPath jsonPath = given().accept(ContentType.JSON).header("x-library-token", token).when().get(ConfigurationReader.getProperty("baseURI")+getBookCategoriesEndpoint)
                .then().statusCode(200)
                .extract().jsonPath();

        expectedBookCategories=jsonPath.getList("name");

    }

    @Then("the api book categories should match those in the database")
    public void the_api_book_categories_should_match_those_in_the_database() {
        DB_Utils.runQuery("select name from book_categories");
        List<String> actualBookCategories=DB_Utils.getColumnDataAsList("name");
        Assertions.assertEquals(expectedBookCategories, actualBookCategories);
    }

}
