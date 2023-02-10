package LibraryApp.steps.api;

import LibraryApp.utilities.APITestBase;
import LibraryApp.utilities.ConfigurationReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;

public class US2_Add_Book_By_API_in_database extends APITestBase {
    @When("POST request sent to {string} endpoint")
    public void post_request_sent_to_endpoint(String string) {
        given().accept(ContentType.JSON)
                .header("x-library-token", token).when().post(ConfigurationReader.getProperty("baseURI") +addBookEndpoint);
    }
    @Then("Status code should be {int}")
    public void status_code_should_be(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the new book should exist in the database")
    public void the_new_book_should_exist_in_the_database() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
