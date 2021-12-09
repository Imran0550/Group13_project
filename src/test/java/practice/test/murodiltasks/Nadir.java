package practice.test.murodiltasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import practice.test.util.WebFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Nadir {


    String url = "http://te.dev.secureci.com/Exercise2.html";
    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver = WebFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

    }

    @Test
    public void Test01(){


        List<WebElement> list = driver.findElements(By.xpath("//div[@class = 'slider round']"));

        for(WebElement each : list){
            each.click();
        }

    }

    @AfterMethod
    public void tearDown(){
       // driver.quit();
    }
}
