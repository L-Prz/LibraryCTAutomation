package LibraryApp.steps;

import LibraryApp.utilities.ConfigurationReader;
import LibraryApp.utilities.Driver;

public class Hooks {
    //@Before
    public void setupScenario(){
        System.out.println("Setting up browser using cucumber @Before each scenario");
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }

}
