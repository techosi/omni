package configuration;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class ChromeBrowser {
    public static WebDriver driver;

    @BeforeClass
    public static void beforeClass() {

        System.setProperty("webdriver.chrome.driver", "/Users/vchilukuri/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void afterClass() {
        driver.quit();
    }

}

