package LibraryApp.steps.ui;

import LibraryApp.pages.BooksPage;
import LibraryApp.pages.LoginPage;
import LibraryApp.utilities.BrowserUtils;
import LibraryApp.utilities.ConfigurationReader;
import LibraryApp.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class US1_2_Student_Search_Book {
    BooksPage booksPage = new BooksPage();
    String expectedBookTitle;
    String expectedAuthor;

    @Given("student is logged into library app")
    public void student_is_logged_into_library_app() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        LoginPage login = new LoginPage();
        login.uiLogin("student");
    }

    @Given("the student is on the Book Management page")
    public void the_student_is_on_the_book_management_page() {

        BrowserUtils.waitForVisibilityOf(booksPage.books);
        booksPage.books.click();
        Assertions.assertEquals(booksPage.pageTitle.getText(), "Book Management");


    }

    @When("student enters a {string} belonging to the library collection in the search bar")
    public void student_enters_a_belonging_to_the_library_collection_in_the_search_bar(String bookTitle) {
        booksPage.searchBar.sendKeys(bookTitle);
        expectedBookTitle = bookTitle;
    }

    @Then("the relevant title search results should be displayed")
    public void the_relevant_title_search_results_should_be_displayed() {
        BrowserUtils.sleep(5);//give browser time for results to be displayed

        //determine number of results
        List<WebElement> rows = Driver.getDriver().findElements(By.xpath("//tbody/tr"));

//assert that for each row in the results table, the book name matches the query
        for (int i = 1; i <= rows.size(); i++) {
            Map<String, Object> results = BooksPage.bookTableCellValidationAsMap(i);
            String actualBookTitle= (String) results.get("name");
            Assertions.assertTrue(Pattern.compile(Pattern.quote(expectedBookTitle), Pattern.CASE_INSENSITIVE).matcher(actualBookTitle).find());

        }
    }

    @When("student enters a {string} not belonging to the library collection in the search bar")
    public void studentEntersANotBelongingToTheLibraryCollectionInTheSearchBar(String bookTitle) {
        booksPage.searchBar.sendKeys(bookTitle);
        expectedBookTitle = bookTitle;

    }

    @Then("the results table should be empty")
    public void theResultsTableShouldBeEmpty() {
        BrowserUtils.sleep(5);//give browser time for results to be displayed

        //determine number of results
               List<WebElement> resultsRow =Driver.getDriver().findElements(By.xpath("//tbody/tr/td"));
               Assertions.assertEquals(resultsRow.size(), 1);
               String actualMessage=resultsRow.get(0).getText();
               String expectedMessage="No data available in table";
               Assertions.assertEquals(actualMessage, expectedMessage);

    }

    @When("student enters an {string} belonging to the library collection in the search bar")
    public void student_enters_an_belonging_to_the_library_collection_in_the_search_bar(String author) {

            booksPage.searchBar.sendKeys(author);
            expectedAuthor = author;

        }
    @Then("the relevant author search results should be displayed")
    public void the_relevant_author_search_results_should_be_displayed() {
        BrowserUtils.sleep(5);//give browser time for results to be displayed

        //determine number of results
        List<WebElement> rows = Driver.getDriver().findElements(By.xpath("//tbody/tr"));

//assert that for each row in the results table, the book name matches the query
        for (int i = 1; i <= rows.size(); i++) {
            Map<String, Object> results = BooksPage.bookTableCellValidationAsMap(i);
            String actualAuthor= (String) results.get("author");
            Assertions.assertTrue(Pattern.compile(Pattern.quote(expectedAuthor), Pattern.CASE_INSENSITIVE).matcher(actualAuthor).find());

        }
    }

    @When("student enters an {string} not belonging to the library collection in the search bar")
    public void student_enters_an_not_belonging_to_the_library_collection_in_the_search_bar(String author) {
        booksPage.searchBar.sendKeys(author);
        expectedAuthor = author;
    }
    @Then("the no author search results should be displayed")
    public void the_no_author_search_results_should_be_displayed() {
        BrowserUtils.sleep(5);//give browser time for results to be displayed

        //determine number of results
        List<WebElement> resultsRow =Driver.getDriver().findElements(By.xpath("//tbody/tr/td"));
        Assertions.assertEquals(resultsRow.size(), 1);
        String actualMessage=resultsRow.get(0).getText();
        String expectedMessage="No data available in table";
        Assertions.assertEquals(actualMessage, expectedMessage);
    }


}
