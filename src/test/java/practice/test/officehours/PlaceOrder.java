package practice.test.officehours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import practice.test.TestBase;
import practice.test.util.BrowserUtil;
import practice.test.util.ConfigurationReader;
import practice.test.util.Driver;
import practice.test.util.OfficeHours;

public class PlaceOrder extends TestBase {

int expectedPrice = 0;
    @Test
    public void placeOrder(){

        driver.get(ConfigurationReader.getProperty("demo"));

       expectedPrice += OfficeHours.addProduct("Laptops","Sony vaio i7");
        //adding iphone
        expectedPrice += OfficeHours.addProduct("Phones","Iphone 6 32gb");

        //adding apple laptop
        expectedPrice += OfficeHours.addProduct("Monitors","Apple monitor 24");

        System.out.println(expectedPrice);

        OfficeHours.getLink("Cart").click();

        BrowserUtil.sleep(2);

        Driver.getDriver().findElement(By.xpath("//tbody//tr//td[contains(text(),'Iphone 6 32gb')]//..//td[.='Delete']/a")).click();

        BrowserUtil.sleep(2);




    }

}
