package LibraryApp.pages;

import LibraryApp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BooksPage extends BasePage {

    @FindBy(css = "#book_categories")
    public WebElement bookCategoryDropdown;

    @FindBy(xpath = "//select[@name='tbl_books_length']")
    public WebElement showNumberOfEntriesDropdown;

    @FindBy(xpath = "//input[@type='search']")
    public  WebElement searchBar;
    @FindBy(xpath = "//tbody/tr/td/a")
    public WebElement borrowBookButton;
    @FindBy(tagName = "h3")
    public WebElement pageTitle;


    public static Map<String, Object> bookTableCellValidationAsMap(int rowNum) {
        Map<String, Object> tableRowData = new HashMap<>();
        List<String> cellData = new ArrayList<>();

        for (int i = 2; i < 8; i++) {
            cellData.add(Driver.getDriver().findElement(By.xpath("//tbody/tr[" + rowNum + "]/td[" + i + "]")).getText());
        }
        tableRowData.put("isbn", cellData.get(0));
        tableRowData.put("name", cellData.get(1));
        tableRowData.put("author", cellData.get(2));
        tableRowData.put("category", cellData.get(3));
        tableRowData.put("year", cellData.get(4));
        tableRowData.put("borrowed_by", cellData.get(5));

        return tableRowData;

    }

    public static List<String> bookTableCellValidationAsList(int rowNum) {
        List<String> cellData = new ArrayList<>();

        for (int i = 2; i < 8; i++) {
            cellData.add(Driver.getDriver().findElement(By.xpath("//tbody/tr[" + rowNum + "]/td[" + i + "]")).getText());
        }
        return cellData;
    }

}
