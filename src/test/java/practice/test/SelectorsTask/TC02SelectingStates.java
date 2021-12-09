package practice.test.SelectorsTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import practice.test.util.WebFactory;

import java.util.concurrent.TimeUnit;

public class TC02SelectingStates {

    String url = "http://practice.cybertekschool.com/dropdown";
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }
    @Test
    public void Test01() throws InterruptedException{

        Select state = new Select(driver.findElement(By.id("state")));
        state.selectByValue("IL");
        Thread.sleep(1000);
        state.selectByVisibleText("Virginia");
        Thread.sleep(1000);
        state.selectByValue("CA");

       String text = state.getFirstSelectedOption().getText();

       Assert.assertEquals(text, "California");

    }
}
