package com.omnitest.omni;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

class DriverWrapper {
    
    /**
    * Rama Tatavarthy
    **/

    static DesiredCapabilities setChromeCapabilities(String platformName) {

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-extensions");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("test-type");
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        if(platformName.contains("mac")){
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            capabilities.setPlatform(Platform.MAC);
        }
        else{
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            capabilities.setPlatform(Platform.WINDOWS);

        }

    return capabilities;
}

}
