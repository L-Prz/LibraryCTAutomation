package LibraryApp.pages;

import LibraryApp.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

@FindBy (css="#inputEmail")
    WebElement emailInput;


@FindBy (css="#inputPassword")
    WebElement passwordInput;

@FindBy (css = "button.btn")
    WebElement signInButton;

public void uiLogin(String userType){
    String email= ConfigurationReader.getProperty(userType+"_email");
    String password= ConfigurationReader.getProperty(userType+"_password");
    emailInput.sendKeys(email);
    passwordInput.sendKeys(password);
    signInButton.click();
}
}
