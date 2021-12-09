package practice.test.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import practice.test.TestBase;
import practice.test.util.BrowserUtil;
import practice.test.util.ConfigurationReader;
import practice.test.util.WebFactory;

import java.util.concurrent.TimeUnit;

public class BOFATask extends TestBase {

    @Test
    public void TC001(){
       driver.get(ConfigurationReader.getProperty("website"));
    driver.findElement(By.xpath("//div/input[@id='onlineId1']"));
    driver.findElement(By.xpath("//div/input[@id='passcode1']"));

        BrowserUtil.sleep(2);
        driver.findElement(By.xpath("//button[@id='signIn']")).click();

        driver.findElement(By.xpath("//span[.='SEND CODE']")).click();

        BrowserUtil.sleep(1);

        driver.findElement(By.cssSelector("#tlpvt-acw-authnum"));

        driver.findElement(By.cssSelector("#yes-recognize")).click();
        driver.findElement(By.xpath("//span[.='SUBMIT']")).click();

    }
}
