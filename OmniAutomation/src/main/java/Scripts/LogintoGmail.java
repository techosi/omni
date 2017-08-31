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
import static com.omnitest.omni.Reporter.endReport;
import static com.omnitest.omni.Reporter.logSuccess;
import static com.omnitest.omni.Reporter.startReport;
import static com.omnitest.omni.Reporter.takeScreenShot;

/**
 * Created by vchilukuri on 8/28/17.
 */
public class LogintoGmail {

    @Test
    public void loginTest () throws Exception {
        try {
            startReport();
            initChromeDriver(System.getProperty("os.name").toLowerCase());
            openapplication("https://www.gmail.com");
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
            endReport();
        }
        catch (Exception e) {
            takeScreenShot(getDriver(), "failed", e.toString());
            endReport();
        }

    }
}
