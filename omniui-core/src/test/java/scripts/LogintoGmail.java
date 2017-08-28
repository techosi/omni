package scripts;

import customization.ChromeDriver;
import Object_Repository.LoginPage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by vchilukuri on 8/24/17.
 */
public class LogintoGmail extends ChromeDriver {

        @Test
        public void logintest () throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "/Users/vchilukuri/chromedriver");
            WebDriver driver = new org.openqa.selenium.chrome.ChromeDriver();
            driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
            launchapplication("https://www.gmail.com");
            type(LoginPage.email_text, "omnitestautomation");
            click(LoginPage.next_btn);
            Thread.sleep(1000);
            type(LoginPage.pass_text, "framework");
            click(LoginPage.sign_btn);
            Thread.sleep(1000);
            click(LoginPage.sign_header_btn);
            Thread.sleep(100);
        }
    }
