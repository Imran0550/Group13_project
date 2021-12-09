package practice.test.officehours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import practice.test.util.WebFactory;

import java.util.concurrent.TimeUnit;

public class TotalOrderPriceCalculation {

    String url = "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx";
    WebDriver driver;

    String username = "Tester";
    String pass = "test";

    @BeforeMethod
    public void setDriver(){
        driver = WebFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void Test01(){

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(username);
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(pass);

        driver.findElement(By.cssSelector("input[type = 'submit']")).click();

        driver.findElement(By.linkText("Order")).click();

        Select select = new Select(driver.findElement(By.xpath("//select[@name ='ctl00$MainContent$fmwOrder$ddlProduct' ]")));

        Assert.assertEquals(select.getFirstSelectedOption().getText(),"MyMoney");

        select.selectByValue("FamilyAlbum");

        WebElement quantity = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        quantity.sendKeys("2");
    }
}
