package practice.test.murodiltasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import practice.test.util.WebFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC0FindElements {
    public static void main(String[] args) {

        WebDriver driver = WebFactory.getDriver("chrome");
        driver.manage().window().maximize();

        String url = "https://www.merriam-webster.com/";
        driver.get(url);

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        int count =0;
        int countA = 0;
        for(WebElement each : allLinks){
            System.out.println(each.getText());

            if(each.getText().isEmpty()){
                count++;
            }else if(!each.getText().isEmpty()){
                countA++;
            }
        }
        System.out.println("Links that are missing text " + count);
        System.out.println("Links that has text " + countA);
        System.out.println("Total links " +allLinks.size());

    }
}
