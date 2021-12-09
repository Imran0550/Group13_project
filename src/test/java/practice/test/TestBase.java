package practice.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import practice.test.util.Driver;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
   protected WebDriver driver;
    @BeforeMethod
    public void setUp(){

        driver = Driver.getDriver();

    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
