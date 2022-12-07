package LibraryApp.pages;

import LibraryApp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//span[@class='title'][.='Books']")
    WebElement books;

    @FindBy (xpath = "//span[@class='title'][.='Borrowing Books']")
    WebElement borrowingBooks;

    @FindBy(css="a#navbarDropdown")
    WebElement navbarDropdown;

    @FindBy(xpath = "//a[@class='dropdown-item'][.='Log Out']")
    WebElement logout;



}
