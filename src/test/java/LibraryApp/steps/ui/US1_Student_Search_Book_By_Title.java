package LibraryApp.steps.ui;

import LibraryApp.pages.BasePage;
import LibraryApp.pages.BooksPage;
import LibraryApp.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class US1_Student_Search_Book_By_Title {
        @Given("student is logged into library app")
    public void student_is_logged_into_library_app() {
            LoginPage login=new LoginPage();
        login.uiLogin("student");
    }
    @Given("the student is on the Book Management page")
    public void the_student_is_on_the_book_management_page() {
        BooksPage booksPage=new BooksPage();
        booksPage.books.click();
        Assertions.assertEquals(booksPage.pageTitle, "Book Management");


    }
    @When("student enters a {string} belonging to the library collection in the search bar")
    public void student_enters_a_belonging_to_the_library_collection_in_the_search_bar(String string) {
        System.out.println("searching for "+ string);
    }
    @Then("the relevant search results should be displayed")
    public void the_relevant_search_results_should_be_displayed() {
        System.out.println("results displayed");
    }

}
