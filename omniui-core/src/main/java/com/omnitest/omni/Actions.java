package com.omnitest.omni;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.omnitest.omni.DriverFactory.getDriver;

/**
 * Created by rtatavarty on 8/28/17.
 */
public class Actions {

    public static void openapplication(String URL){
        getDriver().get(URL);

    }

    public static void type(By locator, String text){
        getDriver().findElement(locator).sendKeys(text);

    }

    public static void click ( By locator){
        getDriver().findElement(locator).click();
    }

}
