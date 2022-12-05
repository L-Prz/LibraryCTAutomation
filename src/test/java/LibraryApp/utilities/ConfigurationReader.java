package LibraryApp.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    /**
     * create a private static Properties object from the java.util Properties class;
     * Static so that it can be used with static methods.
     * Private in order to block access to the properties object from any other class.
     */

    private static Properties properties = new Properties();

    static { //static block: will load the properties object once before everything else in the class.
        try {
            FileInputStream file = new FileInputStream("configuration.properties");
            properties.load(file);

            file.close();//to save memory once the file is loaded.
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading properties.");
        }

    }

    /**
     * This method is used to read a value from the configuration.propreties file.
     * @param keyword--> key name in properties file
     * @return --> value for the key. Returns null if key is not found.
     * how to call: driver.get(ConfigurationReader.getProperty(env));
     */

    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }


}
