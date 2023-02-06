package LibraryApp.steps.api;

import LibraryApp.utilities.APITestBase;
import LibraryApp.utilities.ConfigurationReader;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.util.List;

public class US1_Book_Categories_Match_API_And_Database extends APITestBase {

    List<String> expectedBookCategories;
    @When("GET request sent to {string} endpoint")
    public void get_request_sent_to_endpoint(String string) {
        RestAssured.given().accept(ContentType.JSON)
                .header("x-library-token", token).when().get(ConfigurationReader.getProperty("baseURI") +getBookCategoriesEndpoint).prettyPeek();

    }
    @When("api returns book categories")
    public void api_returns_book_categories() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
