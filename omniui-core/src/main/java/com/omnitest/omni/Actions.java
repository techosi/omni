package com.omnitest.omni;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

import static com.omnitest.omni.DriverFactory.getDriver;

/**
 * Created by rtatavarty on 8/28/17.
 */
public class Actions {
	
	/**
	 *   To open given URL in browser
	 */
	public static void openapplication(String URL) {
		getDriver().get(URL);
	}

	public static void type(By locator, String text) {
		getDriver().findElement(locator).sendKeys(text);

	}

	public static void click(By locator) {
		getDriver().findElement(locator).click();
	}

	public static void quit() {
		if (getDriver() != null) {
			getDriver().quit();
		}
	}
	
	/**
	 *   To close the browser 
	 */
	public static void close() {
		if (getDriver() != null) {
			getDriver().close();
		}
	}

	/**
	 *   To switch from another window to active window
	 */
	public static WebElement switchToActiveWindow() {
		return getDriver().switchTo().activeElement();
	}

	public static String getWindowHandle() {
		return getDriver().getWindowHandle();
	}

	public static Set<String> getAllWindowHandles() {
		return getDriver().getWindowHandles();
	}

	public static String getWindowTitle() {
		return getDriver().getTitle();
	}

}
