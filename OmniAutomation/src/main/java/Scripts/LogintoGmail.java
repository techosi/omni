package Scripts;

import ObjectRepository.LoginPage;
import com.omnitest.omni.DriverFactory;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static Customization.ChromeDriver.click;
import static Customization.ChromeDriver.launchapplication;
import static Customization.ChromeDriver.type;
import static com.omnitest.omni.DriverFactory.driverRun;
import static com.omnitest.omni.DriverFactory.getDriver;

/**
 * Created by vchilukuri on 8/28/17.
 */
public class LogintoGmail {

    @Test
    public void logintest () throws InterruptedException {
/*        System.setProperty("webdriver.chrome.driver", "/Users/vchilukuri/chromedriver");
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
        Thread.sleep(100);*/
        DriverFactory.initChromeDriver("Windows");
        getDriver().get("https://www.google.co.in");
        getDriver().quit();
    }
}
