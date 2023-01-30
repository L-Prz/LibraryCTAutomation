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
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class US3_Book_Categories_Match_In_UI_And_DB {
    BooksPage booksPage = new BooksPage();

    List<String> expectedBookCategories;


    @Given("the user is logged in as {string}")
    public void the_user_is_logged_in_as(String userType) {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        LoginPage login = new LoginPage();
        login.uiLogin(userType);
        System.out.println("Logging in as a "+userType);
    }
    @When("the user navigates to the {string} page")
    public void the_user_navigates_to_the_page(String page) {
booksPage.navigateToModule(page);
    }
    @When("views all book categories")
    public void views_all_book_categories() {
      BrowserUtils.waitForVisibilityOf(booksPage.bookCategoryDropdown);
        expectedBookCategories= BrowserUtils.dropdownOptionsAsString(booksPage.bookCategoryDropdown);
expectedBookCategories.remove(0);
    }
    @Then("the book categories should match those in the database")
    public void the_book_categories_should_match_those_in_the_database() {
        DB_Utils.runQuery("select name from book_categories");
        List<String> actualBookCategories=DB_Utils.getColumnDataAsList("name");
        Assertions.assertEquals(expectedBookCategories, actualBookCategories);
    }


}
