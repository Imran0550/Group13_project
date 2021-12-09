package practice.test.util;

import org.openqa.selenium.WebDriver;

public class BrowserUtil {

    public static void sleep(int sec){

        try {
            Thread.sleep(sec * 1000);
        }catch (InterruptedException e){
            e.getStackTrace();
            System.out.println("Exception happened in the method");
        }
    }
}
