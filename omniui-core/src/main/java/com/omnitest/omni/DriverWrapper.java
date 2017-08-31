package com.omnitest.omni;

import org.apache.http.impl.client.DefaultServiceUnavailableRetryStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

class DriverWrapper {
    
    /**
    * Rama Tatavarthy
    **/
	
    public static final String FIREFOX = "firefox";
    public static final String CHROME = "chrome";
    public static final String IE = "ie";
    public static final String SAFARI = "safari";
    

    public static DesiredCapabilities setChromeCapabilities(String platformName) {

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
    
    public static DesiredCapabilities setDriverCapabilities(String driver){
    	
    	DesiredCapabilities dCapabilities = null;
    
		if (driver.equalsIgnoreCase(FIREFOX)){
    		dCapabilities = DesiredCapabilities.firefox();
    	}
		if (driver.equalsIgnoreCase(IE)) {
            dCapabilities = DesiredCapabilities.internetExplorer();
		}                        
        if (driver.equalsIgnoreCase(CHROME)) {
            dCapabilities = DesiredCapabilities.chrome();		 	
        }
        
        return dCapabilities;   
    }

}
