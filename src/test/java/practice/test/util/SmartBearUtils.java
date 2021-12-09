package practice.test.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SmartBearUtils {

    public static void loginToSmartBear(WebDriver driver){

        WebElement username = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        WebElement pass = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        WebElement login = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));

        username.sendKeys("Tester");
        pass.sendKeys("test");
        login.click();

    }
}
