package practice.test.officehours;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import practice.test.util.WebFactory;

import java.util.concurrent.TimeUnit;

public class PriceTestOne {
    WebDriver driver;
    String url = "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx";

    @BeforeMethod
    public void setDriver(){
        driver = WebFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }

    @AfterMethod
    public void tearDown(){
       // driver.quit();
    }

    @Test
    public void testOne(){
        //login with username : Tester, password : test
   driver.findElement(By.cssSelector("#ctl00_MainContent_username")).sendKeys("Tester");
   driver.findElement(By.cssSelector("#ctl00_MainContent_password")).sendKeys("test" + Keys.ENTER);
   driver.findElement(By.linkText("Order")).click();

   //verify under product information, Selected option is MYMoney

        Select select = new Select(driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_ddlProduct")));

        Assert.assertTrue(select.getFirstSelectedOption().getText().equals("MyMoney"), "Text do NoT match");

        //select FamilyAlbum
        select.selectByIndex(1);
        //make quantity 2
     WebElement quantity = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity"));
     int quan = 2;
     quantity.sendKeys(Keys.DELETE +"2");

     WebElement pricePerElement = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtUnitPrice"));
        System.out.println(pricePerElement.getText());
       int priceUnit = Integer.parseInt(pricePerElement.getAttribute("value"));
        System.out.println("priceUnit = " + priceUnit);
        driver.findElement(By.className("btn_dark")).click();
        int expectedPrice = 2 * priceUnit;
        int actualTotalPrice = Integer.parseInt(driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtTotal")).getAttribute("value"));

        System.out.println("Expected price = " + expectedPrice);
        System.out.println("Actual price =" + actualTotalPrice );

        Assert.assertEquals(expectedPrice,actualTotalPrice);

    }
}
/*
Total Order Price Calculation 1
- Go to:  http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
- Login with username: Tester, password: test
- Click  Order button
- Verify under Product Information, selected option is “MyMoney”
-Then select FamilyAlbum, make quantity 2, and click Calculate,
- Then verify Total is equal to Quantity*PricePerUnit
 */
