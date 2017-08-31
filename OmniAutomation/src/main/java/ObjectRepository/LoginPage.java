package ObjectRepository;

import org.openqa.selenium.By;
/**
 * Created by vchilukuri on 8/28/17.
 */
public class LoginPage {

    public static By email_text = By.cssSelector("#identifierId");
    public static By next_btn = By.cssSelector(".RveJvd.snByac");
    public static By pass_text = By.cssSelector(".whsOnd.zHQkBf");
    public static By sign_btn = By.xpath("//*[@id='passwordNext']/content/span");
    public static By sign_header_btn = By.xpath("//div[5]/div[1]/a/span");
    public static By logout_btn = By.cssSelector("#gb_71");
}
