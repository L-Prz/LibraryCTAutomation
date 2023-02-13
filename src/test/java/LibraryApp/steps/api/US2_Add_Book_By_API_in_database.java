package LibraryApp.steps.api;

import LibraryApp.pojo.Book;
import LibraryApp.utilities.APITestBase;
import LibraryApp.utilities.ConfigurationReader;
import LibraryApp.utilities.DB_Utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import okhttp3.RequestBody;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.json.Json;

import java.time.Year;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class US2_Add_Book_By_API_in_database extends APITestBase {
    Response response;
    int bookId;
    Book requestBody = new Book();

    @When("POST request sent to {string} endpoint")
    public void post_request_sent_to_endpoint(String string) {
        Faker faker = new Faker();

        requestBody.setName(faker.book().title());
        requestBody.setIsbn(faker.code().isbn10());
        requestBody.setYear(faker.number().numberBetween(1900, 2023));
        requestBody.setAuthor(faker.book().author());
        requestBody.setBook_category_id(faker.number().numberBetween(1, 20));
        requestBody.setDescription("Everything you could ever want to know about Wooden Spoons.");

//        requestBody.setName("bookTitle");
//        requestBody.setIsbn("978999098");
//        requestBody.setYear(2022);
//        requestBody.setAuthor("Fake Aurhor");
//        requestBody.setBook_category_id(2);
//        requestBody.setDescription("A test book from API");
//TODO: Complete this user story. Figure out why requestBody was not working in request, but jsonString (mapped using Object Mapper) is working- did not have to use this approach with Spartans. Is there a more elegant way to accomplish this? '  Also, clean up the database from created books with the title "bookTitle". One id is 8767.
        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonString = mapper.writeValueAsString(requestBody);
            System.out.println("jsonString = " + jsonString);
            response = given().accept(ContentType.JSON).header("x-library-token", token).log().body().contentType(ContentType.JSON)
                    .body(jsonString).when().post(ConfigurationReader.getProperty("baseURI") + addBookEndpoint).prettyPeek();
            String expectedMessage = "The book has been created.";
            Assertions.assertEquals(response.path("message"), expectedMessage);
            requestBody.setBookId(Integer.parseInt(response.path("book_id")));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }

    @Then("Status code should be {int}")
    public void status_code_should_be(Integer int1) {
        System.out.println("response.statusCode() = " + response.statusCode());
        Assertions.assertEquals(int1, response.statusCode());
    }

    @Then("the new book should exist in the database")
    public void the_new_book_should_exist_in_the_database() {
        DB_Utils.runQuery("select * from books where id=" + requestBody.getBookId());
        Map<String, String> actualBook = DB_Utils.getRowMap(1);
        actualBook.remove("added_date");
        System.out.println("actualBook = " + actualBook);
        Map<String, String> expectedBook = requestBody.getBookAsMap();
        Assertions.assertEquals(expectedBook, actualBook);

    }
}
