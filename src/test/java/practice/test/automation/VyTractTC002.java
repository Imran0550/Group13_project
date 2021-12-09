package practice.test.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import practice.test.util.WebFactory;

public class VyTractTC002 {

@Test
    public void test() throws InterruptedException {

        WebDriver driver = WebFactory.getDriver("chrome");
        driver.manage().window().maximize();
        String url = "https://qa2.vytrack.com/user/login";
        driver.get(url);

        driver.findElement(By.id("prependedInput")).sendKeys("user36");
        driver.findElement(By.xpath("//input[@type = 'password']")).sendKeys("UserUser123");
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("button[class = 'btn btn-uppercase btn-primary pull-right']")).click();
        Thread.sleep(10000);

        WebElement link = driver.findElement(By.xpath("//li//a[@class = 'dropdown-toggle']"));
        link.click();

        Thread.sleep(10000);
        WebElement user = driver.findElement(By.xpath("//*[.='My User']"));
        user.click();
        Thread.sleep(10000);

        WebElement config = driver.findElement(By.cssSelector("a[title = 'Configuration']"));
        config.click();
        Thread.sleep(10000);
        WebElement reset = driver.findElement(By.xpath("//button[@type = 'reset']"));
        reset.click();
        Thread.sleep(10000);


        WebElement ok = driver.findElement(By.xpath("//div//a[@class = 'btn ok btn-primary']"));

        if (ok.isDisplayed()) {
            ok.click();
            System.out.println("PASS: setting reset successfully");
        } else {
            System.out.println("FAILED: setting didn't reset");
        }


    }

}
