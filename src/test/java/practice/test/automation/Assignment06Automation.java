package practice.test.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import practice.test.util.WebFactory;

import java.util.concurrent.TimeUnit;

public class Assignment06Automation {

    String url = "https://qa2.vytrack.com/user/login";
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException{

        driver = WebFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

        driver.findElement(By.id("prependedInput")).sendKeys("user36");
        driver.findElement(By.xpath("//input[@type = 'password']")).sendKeys("UserUser123");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[class = 'btn btn-uppercase btn-primary pull-right']")).click();
    }

    @Test
    public void TestAutomation() throws InterruptedException{

      driver.findElement(By.xpath("//span[@class = 'title title-level-1'][1]")).click();
      Thread.sleep(2000);
      driver.findElement(By.xpath("//*[.='Vehicles']")).click();

      // find refresh button using the class name
     WebElement refresh =  driver.findElement(By.className("fa-repeat"));

       // verify refresh button isDisplayed
        Assert.assertTrue(refresh.isDisplayed());
        Thread.sleep(2000);
       // click refresh after it's verified
        refresh.click();
        System.out.println("Passed");

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
