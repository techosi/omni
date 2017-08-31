package com.omnitest.omni;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import static com.omnitest.omni.DriverWrapper.setChromeCapabilities;

public class DriverFactory {
	
    
	public static final ThreadLocal<WebDriver> driverRun = new ThreadLocal<>();
    private static int SESSIONTIMEOUT = 60; //time in seconds
    private static boolean CONDITIONCHECK =true;

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
    public static void initChromeDriver(String platformName) {
        setWebDriver(new ChromeDriver(setChromeCapabilities(platformName)));
        setTimeout(SESSIONTIMEOUT);
        //getDriver().manage().window().maximize();
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
    

    /**
     * initialization FirefoxDriver
     */
    @SuppressWarnings("deprecation")
	public static void initFirefoxDriver() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(true);
        profile.setPreference("javascript.enabled", true);
        profile.setPreference("dom.max_script_run_time", 0);
        profile.setPreference("dom.max_chrome_script_run_time", 0);
        setTimeout(SESSIONTIMEOUT);
        getDriver().manage().window().maximize();
    }

    /**
     * initialization InternetExplorerDriver
     */
    public static void initInternetExplorerDriver() {
       
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setPlatform(Platform.WINDOWS);
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
        capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        setWebDriver(new InternetExplorerDriver(capabilities));
        setTimeout(SESSIONTIMEOUT);
        getDriver().manage().window().maximize();
    }

    /**
     * initialization ChromeDriver
     */
    public static void initChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(Arrays.asList("--start-maximized", "--test-type", "--ignore-certificate-errors", "--disable-popup-blocking", "--allow-running-insecure-content", "--disable-translate", "--always-authorize-plugins"));
        setWebDriver(new ChromeDriver(options));
        setTimeout(SESSIONTIMEOUT);
    }

    /**
     * initialization SafariDriver
     */
    public static void initSafariDriver() {
        setWebDriver(new SafariDriver());
        setTimeout(SESSIONTIMEOUT);
        getDriver().manage().window().maximize();
    }
}
