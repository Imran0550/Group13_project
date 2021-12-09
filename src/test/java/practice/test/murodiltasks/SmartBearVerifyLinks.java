package practice.test.murodiltasks;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import practice.test.util.SmartBearUtils;
import practice.test.util.WebFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearVerifyLinks {

    WebDriver driver;
    String url = "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx";
    Faker faker = new Faker();

    @BeforeMethod
    public void setUp(){
        driver = WebFactory.getDriver("Chrome");
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void TC001(){
        SmartBearUtils.loginToSmartBear(driver);

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("links count = " + links.size());

        links.forEach(e -> System.out.println(e.getText()));
    }
    @Test
    public void TC002(){
        SmartBearUtils.loginToSmartBear(driver);

        driver.findElement(By.linkText("Order")).click();

        Select select = new Select(driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_ddlProduct")));

        select.selectByIndex(1);
        WebElement quan = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity"));
        quan.sendKeys("2");
        driver.findElement(By.cssSelector("input[type= 'submit']")).click();

        WebElement name = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName"));

        name.sendKeys(faker.name().firstName());

        WebElement street = driver.findElement(By.xpath("//input[@id = 'ctl00_MainContent_fmwOrder_TextBox2']"));
        street.sendKeys(faker.address().streetAddress());

        WebElement city = driver.findElement(By.xpath("//input[@id = 'ctl00_MainContent_fmwOrder_TextBox3']"));
        city.sendKeys(faker.address().city());

        WebElement state = driver.findElement(By.xpath("//input[@id = 'ctl00_MainContent_fmwOrder_TextBox4']"));
        state.sendKeys(faker.address().state());

        WebElement zip = driver.findElement(By.xpath("//input[@id = 'ctl00_MainContent_fmwOrder_TextBox5']"));
        zip.sendKeys(faker.address().zipCode().substring(0,4));

        driver.findElement(By.xpath("//input[@value = 'Visa']")).click();

        WebElement card = driver.findElement(By.xpath("//input[@id= 'ctl00_MainContent_fmwOrder_TextBox6']"));
        card.sendKeys(faker.number().digits(10));

        WebElement date = driver.findElement(By.xpath("//input[@id= 'ctl00_MainContent_fmwOrder_TextBox1']"));
        date.sendKeys("01/23");

        date.findElement(By.xpath("//a[@id= 'ctl00_MainContent_fmwOrder_InsertButton']")).click();

        String text = driver.findElement(By.tagName("strong")).getText().trim();

        System.out.println(text);

        Assert.assertEquals(text,"New order has been successfully added.");

    }
}
