package LibraryApp.steps.ui;

import LibraryApp.pages.BooksPage;
import LibraryApp.utilities.BrowserUtils;
import LibraryApp.utilities.Driver;
import com.assertthat.selenium_shutterbug.utils.web.Browser;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class US2_Book_Category_Filter {
List<String> bookCategories;

BooksPage booksPage=new BooksPage();
    @When("selects a book category from the dropdown")
    public void selects_a_book_category_from_the_dropdown() {
       bookCategories= BrowserUtils.dropdownOptionsAsString(booksPage.bookCategoryDropdown);
       bookCategories.remove(0);

    }
    @Then("the results table should display only books from that genre.")
    public void the_results_table_should_display_only_books_from_that_genre() {
        Select select=new Select(booksPage.bookCategoryDropdown);
        for(String eachCategory:bookCategories){
            System.out.println(eachCategory);
            select.selectByVisibleText(eachCategory);
            booksPage.changeNumberOfResultsDropdown(booksPage.countResults()); //TODO: Fantasy column is failing.
            int tableLength= booksPage.countResults();
            if (booksPage.countResults()>500){
                tableLength=500;
            }


            for(int i=1; i<tableLength-1; i++){
                BrowserUtils.waitForVisibilityOf(Driver.getDriver().findElement(By.xpath("//tbody/tr["+i+"]/td[5]")));
                String actualCategory= Driver.getDriver().findElement(By.xpath("//tbody/tr["+i+"]/td[5]")).getText();
                Assert.assertEquals(actualCategory, eachCategory);
            }

        }
    }
}
