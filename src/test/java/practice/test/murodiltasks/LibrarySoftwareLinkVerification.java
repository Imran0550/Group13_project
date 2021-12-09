package practice.test.murodiltasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import practice.test.util.WebFactory;

import java.util.concurrent.TimeUnit;

public class LibrarySoftwareLinkVerification {

    WebDriver driver;
    String url = "http://library2.cybertekschool.com/login.html";

    @BeforeMethod
    public void setUp(){
        driver = WebFactory.getDriver("Chrome");
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void TC001(){
        WebElement login = driver.findElement(By.xpath("//input[@id = 'inputEmail']"));
        login.sendKeys("student11@library");
        WebElement pass = driver.findElement(By.xpath("//input[@id = 'inputPassword']"));
        pass.sendKeys("tScBPCUr");

        driver.findElement(By.className("btn btn-lg btn-primary btn-block")).click();
    }
}
