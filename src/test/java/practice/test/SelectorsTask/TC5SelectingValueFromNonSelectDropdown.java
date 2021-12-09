package practice.test.SelectorsTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import practice.test.util.WebFactory;

import java.util.concurrent.TimeUnit;

public class TC5SelectingValueFromNonSelectDropdown {

    String url = "http://practice.cybertekschool.com/dropdown";
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }
    @Test
    public void TC1() throws InterruptedException{

        Select day = new Select(driver.findElement(By.id("day")));
        day.selectByVisibleText("1");

        Assert.assertEquals(day.getFirstSelectedOption().getText(),"1");

        Thread.sleep(2000);

        Select month = new Select(driver.findElement(By.id("month")));
        month.selectByValue("11");
        String december = month.getFirstSelectedOption().getText();

        Assert.assertEquals(december,"December");

        Thread.sleep(2000);

        Select year = new Select(driver.findElement(By.id("year")));
        year.selectByVisibleText("1922");

        String year1 = year.getFirstSelectedOption().getText();

        Assert.assertEquals(year1,"1922");


    }
}
