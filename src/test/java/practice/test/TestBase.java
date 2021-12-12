package practice.test;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import practice.test.util.Driver;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
   protected WebDriver driver;
   protected Faker faker;
   protected Actions actions = new Actions(Driver.getDriver());
    @BeforeMethod
    public void setUp(){

        driver = Driver.getDriver();
        faker = new Faker();

    }

    @AfterMethod
    public void tearDown(){
      //  Driver.closeDriver();
    }
}
