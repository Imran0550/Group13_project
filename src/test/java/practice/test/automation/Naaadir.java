package practice.test.automation;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Naaadir {

    public static List<WebElement> list(ArrayList<WebElement> list1){

        List<WebElement> list = new ArrayList<>();

        for(WebElement each : list1){

            if(!each.getText().equals(" ")){
                list.add(each);
            }

        }

        return list;
    }
}
