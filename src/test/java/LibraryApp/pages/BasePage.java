package LibraryApp.pages;

import LibraryApp.utilities.Driver;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//a[@href='#books']")
    public WebElement books;

    @FindBy (xpath = "//span[@class='title'][.='Borrowing Books']")
    public WebElement borrowingBooks;

    @FindBy(css="a#navbarDropdown")
    public WebElement navbarDropdown;

    @FindBy(xpath = "//a[@class='dropdown-item'][.='Log Out']")
    public WebElement logout;



}
