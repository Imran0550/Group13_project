package practice.test.murodiltasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import practice.test.util.WebFactory;

import java.util.List;

public class TC02FindElementsApple {
    public static void main(String[] args) throws InterruptedException {

        String url = "https://www.apple.com";

        WebDriver driver = WebFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(url);

        WebElement apple = driver.findElement(By.linkText("iPhone"));
        apple.click();
        Thread.sleep(2000);

        List<WebElement> links = driver.findElements(By.tagName("a"));
        int count =0;
        int countb =0;

        for(WebElement each : links){
            System.out.println(each.getText());

            if(each.getText().isEmpty()){
                count++;
            }else if(!each.getText().isEmpty()){
                countb++;
            }

        }
        System.out.println("Number of links that are empty " + count);
        System.out.println("Number of links that has text " + countb);
        System.out.println("Total links " + links.size());

    }
}
