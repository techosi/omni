package com.omnitest.omni;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

class DriverWrapper {

    static DesiredCapabilities setChromeCapabilities(String platformName) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("test-type");
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        if(platformName.equalsIgnoreCase("mac"))
            capabilities.setPlatform(Platform.MAC);
        else
            capabilities.setPlatform(Platform.WIN8);

    return capabilities;
}

}
