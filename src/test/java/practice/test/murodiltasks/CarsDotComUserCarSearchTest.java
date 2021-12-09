package practice.test.murodiltasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import practice.test.util.WebFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CarsDotComUserCarSearchTest {

    String url = "https://www.cars.com";
    WebDriver driver;

    @BeforeMethod
    public void setDriver(){
        driver = WebFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }
    @Test(priority = 1)
    public void defaultValuesTest(){
        //verify the tilte
        Assert.assertEquals(driver.getTitle(),"New Cars, Used Cars, Car Dealers, Prices & Reviews | Cars.com");

        //locate cars.com icon
        WebElement image = driver.findElement(By.xpath("//img[@alt = 'Cars.com Homepage']"));
        //verify that its displayed
        Assert.assertTrue(image.isDisplayed());


       Select five = new Select(driver.findElement(By.xpath("//select[@data-component = 'vehicle-search']")));
        System.out.println("=> "+five.getFirstSelectedOption().getText());
        Select four = new Select(driver.findElement(By.xpath("//select[@id = 'makes']")));
        System.out.println("=> "+four.getFirstSelectedOption().getText());
        Select three = new Select(driver.findElement(By.xpath("//select[@id = 'models']")));
        System.out.println("=> "+three.getFirstSelectedOption().getText());
        Select two = new Select(driver.findElement(By.xpath("//select[@id = 'make-model-max-price']")));
        System.out.println("=> "+two.getFirstSelectedOption().getText());
        Select one = new Select(driver.findElement(By.xpath("//select[@id = 'make-model-maximum-distance']")));
        System.out.println("=> "+one.getFirstSelectedOption().getText());

        WebElement zipCode = driver.findElement(By.id("make-model-zip"));
        Assert.assertEquals(22401,22401);

    }

    @Test(priority = 2)
    public void usedTeslaSearchTest(){
        Select five = new Select(driver.findElement(By.xpath("//select[@data-component = 'vehicle-search']")));
        five.selectByValue("used");
        Select four = new Select(driver.findElement(By.xpath("//select[@id = 'makes']")));
        four.selectByVisibleText("Tesla");
        Select three = new Select(driver.findElement(By.id("models")));
        three.selectByVisibleText("Model 3");
        Select two = new Select(driver.findElement(By.xpath("//select[@id = 'make-model-max-price']")));
        two.selectByValue("50000");
        Select one = new Select(driver.findElement(By.xpath("//select[@id = 'make-model-maximum-distance']")));
        one.selectByVisibleText("200 miles");

        driver.findElement(By.xpath("//button[@class = 'sds-button'][1]")).click();

        WebElement header = driver.findElement(By.cssSelector("h1[class = 'sds-heading--1 sds-page-section__title']"));
        Assert.assertTrue(header.getText().contains("Model 3"));
        WebElement result = driver.findElement(By.xpath("(//span[@class = 'total-filter-count'])[2]"));
        String result2 = result.getText().substring(0,3);
        int res = Integer.parseInt(result2);
        Assert.assertTrue(res >200 && res < 500 );
        WebElement model3 = driver.findElement(By.xpath("//input[@id = 'model_tesla-model_3']"));
        Assert.assertTrue(model3.isSelected());
        WebElement modelS = driver.findElement(By.xpath("//input[@id = 'model_tesla-model_s']"));
        Assert.assertTrue(!modelS.isSelected());



    }
    @Test(priority = 3)
    public void usedTeslaAdvancedSearchTest()throws InterruptedException{

        WebElement advancedSearch = driver.findElement(By.xpath("//a[@class='search-advanced']"));
        advancedSearch.click();

        WebElement search = driver.findElement(By.xpath("//h1[@class= 'sds-heading--1']"));
        Assert.assertTrue(search.isDisplayed());

        Select select = new Select(driver.findElement(By.xpath("//select[@name= 'maximum_distance']")));
        select.selectByValue("500");
        Select select2 = new Select(driver.findElement(By.xpath("//select[@id = 'desktop-stock-type-select']")));
        select2.selectByVisibleText("Used");
        Select select3 = new Select(driver.findElement(By.xpath("//select[@id = 'desktop-make_select']")));
        select3.selectByVisibleText("Tesla");

        Thread.sleep(2000);

        WebElement checkbox1 = driver.findElement(By.xpath("//label[@for= 'desktop_tesla-model_3']"));
        checkbox1.click();
//        Thread.sleep(2000);
//        WebElement checkbox2 = driver.findElement(By.xpath("//input[@id = 'desktop_tesla-model_s']"));
//        checkbox2.click();
//        Thread.sleep(2000);
//        WebElement checkbox3 = driver.findElement(By.xpath("//input[@id = 'desktop_tesla-model_x']"));
//        checkbox3.click();
//        Thread.sleep(2000);
//        WebElement checkbox4 = driver.findElement(By.xpath("//input[@id = 'desktop_tesla-model_y']"));
        //checkbox4.click();


        driver.findElement(By.xpath("(//button[@type= 'submit'])[1]")).click();





    }
}
