package LibraryApp.steps.db;

import LibraryApp.pages.BooksPage;
import LibraryApp.pages.LoginPage;
import LibraryApp.utilities.BrowserUtils;
import LibraryApp.utilities.ConfigurationReader;
import LibraryApp.utilities.DB_Utils;
import LibraryApp.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class US2_Librarian_Borrowed_Books_Number {
    BooksPage booksPage = new BooksPage();
    String expectedBorrowedBooks;

    @Given("the user is logged in as a librarian")
    public void the_user_is_logged_in_as_a_librarian() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        LoginPage login = new LoginPage();
        login.uiLogin("librarian");
    }

    @When("the user accesses the borrowed books number")
    public void the_user_accesses_the_borrowed_books_number() {
        BrowserUtils.waitForVisibilityOf(booksPage.dashboard);
        booksPage.dashboard.click();
        expectedBorrowedBooks = booksPage.borrowedBooks.getText();
    }

    @Then("the borrowed books number should match with the database")
    public void the_borrowed_books_number_should_match_with_the_database() {
        String query = "select count(*) from book_borrow where is_returned=0";
        DB_Utils.runQuery(query);
        String actualBorrowedBooks=DB_Utils.getCellValue(1,1);
        Assertions.assertEquals(expectedBorrowedBooks, actualBorrowedBooks);

    }
}
