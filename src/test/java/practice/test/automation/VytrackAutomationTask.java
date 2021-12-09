package practice.test.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import practice.test.util.Driver;
import practice.test.util.WebFactory;

import java.util.Collections;
import java.util.List;

public class VytrackAutomationTask {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebFactory.getDriver("chrome");
        driver.manage().window().maximize();
        String url = "https://qa2.vytrack.com/user/login";
        driver.get(url);

        driver.findElement(By.id("prependedInput")).sendKeys("user36");
        driver.findElement(By.xpath("//input[@type = 'password']")).sendKeys("UserUser123");
        driver.findElement(By.cssSelector("button[class = 'btn btn-uppercase btn-primary pull-right']")).click();
        Thread.sleep(2000);


        driver.navigate().to("https://qa2.vytrack.com/entity/Extend_Entity_Carreservation");
Thread.sleep(2000);
        List<WebElement> all = driver.findElements(By.xpath("//tr[@class = 'grid-row row-click-action']"));

        System.out.println(all.size());

        Collections.shuffle(all);
        all.get(0).click();
//
     String expTitle = driver.getTitle();

     if(expTitle.contains("Car")){
         System.out.println("PASS");
     }else {
         System.out.println("FAILED");
     }


    }
}
