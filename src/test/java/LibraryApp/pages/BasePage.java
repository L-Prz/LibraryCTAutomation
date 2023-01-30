package LibraryApp.pages;

import LibraryApp.utilities.BrowserUtils;
import LibraryApp.utilities.Driver;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
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

    @FindBy (xpath = "//a[@href='#dashboard']")
    public WebElement dashboard;

    @FindBy (xpath = "//a[@href='#borrowing-books']")
    public WebElement borrowingBooks;

    @FindBy (xpath = "//a[@href='#users']")
    public WebElement users;

    @FindBy(css="a#navbarDropdown")
    public WebElement navbarDropdown;

    @FindBy(xpath = "//a[@class='dropdown-item'][.='Log Out']")
    public WebElement logout;

public void navigateToModule(String module){
BrowserUtils.sleep(5);
    WebElement myModule=Driver.getDriver().findElement(By.xpath("//a[@href='#"+module+"']"));
    BrowserUtils.waitForVisibilityOf(myModule);
    myModule.click();
}

}
