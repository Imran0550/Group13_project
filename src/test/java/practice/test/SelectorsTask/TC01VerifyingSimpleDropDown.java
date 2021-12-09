package practice.test.SelectorsTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import practice.test.util.WebFactory;

import java.util.concurrent.TimeUnit;

public class TC01VerifyingSimpleDropDown {

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

        WebElement simple = driver.findElement(By.xpath("//select[@id = 'dropdown']/option[1]"));

        Assert.assertEquals(simple.getText(),"Please select an option");

        Thread.sleep(2000);
        WebElement state = driver.findElement(By.xpath("//*[.='Select a State']"));

        Assert.assertEquals(state.getText(),"Select a State");
    }
}
