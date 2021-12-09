package practice.test.officehourspractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import practice.test.util.WebFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC01BasicLoginAuthentication {

    @Test
    public void Basic() throws InterruptedException {

        WebDriver driver = WebFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String url = " http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx";
        driver.get(url);

        String expectedTitle = "Web Orders Login";
        String actTitle = driver.getTitle();

        System.out.println(actTitle.equals(expectedTitle));
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.xpath("//input[@type = 'password']")).sendKeys("test");
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();

        String homePageTitle = "Web Orders";
        String actualTitle = driver.getTitle();

        System.out.println(actualTitle.equals(homePageTitle));


        driver.findElement(By.linkText("Check All")).click();

        List<WebElement> all = driver.findElements(By.xpath("//input[@type = 'checkbox']"));
        System.out.println(all.size());

        for(WebElement each : all){
            if(each.isSelected() != true){
                System.out.println("Not all are selected");
                break;
            }
        }
        System.out.println();
        System.out.println();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//p//a[@id = 'ctl00_MainContent_btnUncheckAll']")).click();

        List<WebElement> all2 = driver.findElements(By.xpath("//input[@type = 'checkbox']"));

        for(WebElement each2 :all2){
            if (each2.isSelected() != false);
            System.out.println("Not all buttons unchecked");
            break;
            }

        Thread.sleep(2000);
        List<WebElement> all3 = driver.findElements(By.xpath("//input[@type = 'checkbox']"));



      int size = all3.size();
        System.out.println(size);
        WebElement paul = driver.findElement(By.xpath("//tr//td[.='Paul Brown']/../td[1]/input"));
        paul.click();
      driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();
        List<WebElement> all4 = driver.findElements(By.xpath("//input[@type = 'checkbox']"));
Thread.sleep(2000);
      int size2 = all4.size();
        System.out.println(size2);
      if(size2 < size){
          System.out.println("Passed!");
      }



    }
}
