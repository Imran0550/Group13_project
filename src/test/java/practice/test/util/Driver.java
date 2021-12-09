package practice.test.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    // creating a private constructor, so it's not reachable from outside
    private Driver(){}

    //create a private and belong to class (it runs before anything in the class) driver, so it's  not reachable from outside thr class
    private static WebDriver driver;

    //create a reusable utility method, so we can call it anywhere

    public static WebDriver getDriver(){

        if(driver == null){



            String browser = ConfigurationReader.getProperty("browser");


            if(browser.equalsIgnoreCase("chrome")){
                WebDriverManager.chromedriver().setup();
                driver= new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
            }else if(browser.equalsIgnoreCase("firefox")){
                WebDriverManager.firefoxdriver().setup();
                driver= new FirefoxDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
            }

        }
        return driver;
    }


    public static void closeDriver(){
        if(driver !=null){
            driver.close();
            driver=null;
        }
    }
}
