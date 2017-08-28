package customization;

import org.openqa.selenium.By;
import configuration.ChromeBrowser;

/**
 * Created by vchilukuri on 8/24/17.
 */
public class ChromeDriver extends ChromeBrowser {


    public void launchapplication(String URL){
        driver.get(URL);

    }

    public void type(By locator, String text){
        driver.findElement(locator).sendKeys(text);

    }

    public void click ( By locator){
        driver.findElement(locator).click();
    }
}