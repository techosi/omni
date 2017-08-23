package com.omni.omniutils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DriverFactory {
	
    
	public static final ThreadLocal<WebDriver> driverRun = new ThreadLocal<>();
    public static int SESSIONTIMEOUT = 60; //time in seconds
    public static boolean CONDITIONCHECK =true;

    public static WebDriver getDriver() {
        return driverRun.get();
    }

    public static void setWebDriver(WebDriver webDriver) {
        driverRun.set(webDriver);
    }
    
    public static void setTimeout(int timeout) {
        getDriver().manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        getDriver().manage().timeouts().setScriptTimeout(timeout, TimeUnit.SECONDS);
    }

    /**
     * Set Default timeout for WebDriver
     */
    public static void setDefaultTimeout(int timeout) {
        SESSIONTIMEOUT = timeout;
    }

    /**
     * Set Default check condition for wait methods
     */
    public static void setDefaultCheckCondition(boolean checkCondition) {
    	CONDITIONCHECK = checkCondition;
    }


    /**
     * initialization RemoteWebDriver
     *
     */
    public static void initRemoteWebDriver(String remoteUrl, Capabilities capabilities) throws MalformedURLException {
        setWebDriver(new RemoteWebDriver(new URL(remoteUrl), capabilities));
        setTimeout(SESSIONTIMEOUT);
        getDriver().manage().window().maximize();
    }

    /**
     * initialization FirefoxDriver
     *
     */
    public static void initFirefoxDriver(Capabilities capabilities) {
        setWebDriver(new FirefoxDriver(capabilities));
        setTimeout(SESSIONTIMEOUT);
        getDriver().manage().window().maximize();
    }

    /**
     * initialization ChromeDriver
     *
     */
    public static void initChromeDriver(Capabilities capabilities) {
        setWebDriver(new ChromeDriver(capabilities));
        setTimeout(SESSIONTIMEOUT);
        getDriver().manage().window().maximize();
    }

    /**
     * initialization SafariDriver
     *
     */
    public static void initSafariDriver(Capabilities capabilities) {
        setWebDriver(new SafariDriver(capabilities));
        setTimeout(SESSIONTIMEOUT);
        getDriver().manage().window().maximize();
    }

    /**
     * initialization InternetExplorerDriver
     *
     */
    public static void initInternetExplorerDriver(Capabilities capabilities) {
        setWebDriver(new InternetExplorerDriver(capabilities));
        setTimeout(SESSIONTIMEOUT);
        getDriver().manage().window().maximize();
    }

    /**
     * initialization HtmlUnitDriver
     *
     */
    public static void initHtmlUnitDriver(Capabilities capabilities) {
        setWebDriver(new HtmlUnitDriver(capabilities));
        setTimeout(SESSIONTIMEOUT);
        getDriver().manage().window().maximize();
    }
    
    public static void deletecookie(){
    	Cookie cookie = null;
		getDriver().manage().deleteCookie(cookie);
    }
    
    
    /**
     * Delete all cookies after session complete
     */
    public static void deleteCookies() {
        getDriver().manage().deleteAllCookies();
        
    }
    
    /**
     * get browser cookies
     */
    
    public static void getAllCookies() {
        getDriver().manage().getCookies();
    }
    
    /**
     * get cookie
     */

    public static void getCookie() {
        getDriver().manage().getCookieNamed(null);
        
    }    
}
