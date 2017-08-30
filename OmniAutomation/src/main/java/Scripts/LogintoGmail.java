package Scripts;

import org.junit.Test;

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

/**
 * Created by vchilukuri on 8/28/17.
 */
public class LogintoGmail {

    @Test
    public void logintest () throws InterruptedException {
        initChromeDriver(System.getProperty("os.name").toLowerCase());
        openapplication("https://www.gmail.com");
        type(email_text, "omnitestautomation");
        click(next_btn);
        Thread.sleep(1000);
        type(pass_text, "framework");
        Thread.sleep(1000);
        click(sign_btn);
        Thread.sleep(1000);
        click(sign_header_btn);
        Thread.sleep(1000);
        click(logout_btn);
        getDriver().quit();
    }
}
