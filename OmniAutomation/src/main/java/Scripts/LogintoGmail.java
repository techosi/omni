package Scripts;

import com.omnitest.omni.ExtentReportsClass;
import org.testng.annotations.Test;

import static ObjectRepository.LoginPage.email_text;
import static ObjectRepository.LoginPage.logout_btn;
import static ObjectRepository.LoginPage.next_btn;
import static ObjectRepository.LoginPage.pass_text;
import static ObjectRepository.LoginPage.sign_btn;
import static ObjectRepository.LoginPage.sign_header_btn;
import static com.omnitest.omni.Actions.click;
import static com.omnitest.omni.Actions.openapplication;
import static com.omnitest.omni.Actions.type;
import static com.omnitest.omni.DriverFactory.getDriver;
import static com.omnitest.omni.DriverFactory.initChromeDriver;
import static org.junit.Assert.assertTrue;

/**
 * Created by vchilukuri on 8/28/17.
 */
public class LogintoGmail extends ExtentReportsClass {

    @Test
    public void loginTest () throws Exception {

            initChromeDriver(System.getProperty("os.name").toLowerCase());
            openapplication("https://www.gmail.com");
            assertTrue(getDriver().getTitle().equals("Gmail"));
            logSuccess("gmail openend");
            type(email_text, "omnitestautomation");
            click(next_btn);
            Thread.sleep(1000);
            type(pass_text, "framework");
            Thread.sleep(1000);
            click(sign_btn);
            Thread.sleep(1000);
            logSuccess("login successful");
            click(sign_header_btn);
            Thread.sleep(1000);
            click(logout_btn);
    }

    @Test
    public void failTest () throws Exception {
        initChromeDriver(System.getProperty("os.name").toLowerCase());
        openapplication("https://www.twitter.com");
        type(email_text, "omnitestautomation");
    }
}
