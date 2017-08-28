package Customization;

import Configuration.ChromeBrowser;
import org.openqa.selenium.By;

/**
 * Created by vchilukuri on 8/28/17.
 */
public class ChromeDriver extends ChromeBrowser {

    public static void launchapplication(String URL){
        driver.get(URL);

    }

    public static void type(By locator, String text){
        driver.findElement(locator).sendKeys(text);

    }

    public static void click ( By locator){
        driver.findElement(locator).click();
    }
}
