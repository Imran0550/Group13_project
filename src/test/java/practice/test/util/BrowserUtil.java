package practice.test.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrowserUtil {

    public static void sleep(int sec){

        try {
            Thread.sleep(sec * 1000);
        }catch (InterruptedException e){
            e.getStackTrace();
            System.out.println("Exception happened in the method");
        }
    }

    public static void ScrollDownUsingPixel(int pixels){

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        js.executeScript("window.scrollBy(0, "+pixels+")");

    }

    public static void scrollDownUsingWebElem(WebElement ele){

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        js.executeScript("arguments[0].scrollIntoView(true)",ele);
    }
}
