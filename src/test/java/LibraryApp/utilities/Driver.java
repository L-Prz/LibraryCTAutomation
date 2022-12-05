package LibraryApp.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {

    //Private constructor to close access to the object of this class from any outside classes.
    private Driver(){

    }

    //declare Driver Instance; Private so it is not reachable from any outside class. Static so it runs first, and usable w/ static methods.
    private static WebDriver driver;

    /**
     * Driver- Singleton Design Pattern. Creates a utility method that will return the same driver instance every time it is called.
     */

    public static WebDriver getDriver() {
        if (driver == null) { //if driver was never opened
            String browserType = ConfigurationReader.getProperty("browser");

            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    break;

                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    driver.manage().window().maximize();
                    break;
            }

        }//the same driver instance will be returned every time we call Driver.getDriver().
        return driver;

    }

    //utility method to close driver
    public static void closeDriver(){
        if(driver!=null){
            driver.quit(); //this will kill the session
            driver=null; //reset value to null
        }
    }
}
