package practice.test.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Method {

    public static void loginToGasMileage() throws InterruptedException {

        WebDriver driver = WebFactory.getDriver("chrome");
        driver.manage().window().maximize();

        String url = "https://www.calculator.net";
        driver.get(url);

        WebElement search = driver.findElement(By.xpath("//input[@name = 'calcSearchTerm']"));
        search.sendKeys("gas mileage");
        Thread.sleep(2000);

        WebElement click = driver.findElement(By.linkText("Gas Mileage Calculator"));
        click.click();

        WebElement text = driver.findElement(By.tagName("h1"));

        if(text.isDisplayed()){
            System.out.println("Title verified");
        }else {
            System.out.println("Title verification failed");
        }

        Thread.sleep(2000);

        WebElement elm1 = driver.findElement(By.xpath("//input[@value = '12360']"));

        elm1.clear();
        elm1.sendKeys("7925");
        Thread.sleep(2000);

        WebElement elm2 = driver.findElement(By.cssSelector("input[value = '12000']"));

        elm2.clear();
        elm2.sendKeys("7550");
        Thread.sleep(2000);

        WebElement elm3 = driver.findElement(By.name("usgasputin"));

        elm3.clear();
        elm3.sendKeys("16");
        Thread.sleep(2000);

        WebElement elm4 = driver.findElement(By.id("usgasprice"));

        elm4.clear();
        elm4.sendKeys("3.55");
        Thread.sleep(2000);

        WebElement calculate = driver.findElement(By.xpath("//input[@alt = 'Calculate']"));
        calculate.click();

        String result = driver.findElement(By.tagName("b")).getText();
        System.out.println(result);
    }
}
