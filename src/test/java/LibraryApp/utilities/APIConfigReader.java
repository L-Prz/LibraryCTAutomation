package LibraryApp.utilities;


import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class APIConfigReader {

    private static EnvironmentVariables environmentVariables ;
    static {
        environmentVariables =
                SystemEnvironmentVariables.createEnvironmentVariables();
    }

    public static String getProperty(String propertyName){

        return EnvironmentSpecificConfiguration
                .from(environmentVariables)
                .getProperty(propertyName);

    }

}
