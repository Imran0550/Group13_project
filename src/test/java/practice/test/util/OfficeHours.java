package practice.test.util;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OfficeHours {

    static Alert alert;

    public static WebElement getLink(String str){

        return Driver.getDriver().findElement(By.partialLinkText(str));
    }

    public static int addProduct(String category, String product){

             getLink(category).click();
             getLink(product).click();


             //getting the product price

        WebElement priceContainer = Driver.getDriver().findElement(By.xpath("//h3"));
        int productPrice = Integer.parseInt(priceContainer.getText().substring(1,4));

         //click on add to cart
        getLink("Add to cart").click();
       BrowserUtil.sleep(2);
        //switch to alert to handle alert
        alert = Driver.getDriver().switchTo().alert();
        alert.accept();

        getLink("Home").click();

        return productPrice;

    }
}
