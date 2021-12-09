package practice.test.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties = new Properties();

    static {
        try {
            // open the file using input stream

            FileInputStream inputStream = new FileInputStream("configuration.properties");

            //load the file
            properties.load(inputStream);

        }catch (Exception e){
            e.getStackTrace();
            System.out.println("exception happened here");
        }

    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
