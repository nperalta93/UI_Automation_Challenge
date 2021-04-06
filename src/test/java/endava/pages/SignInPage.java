package endava.pages;

import static org.apache.logging.log4j.LogManager.getLogger;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class SignInPage extends BasePage{
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    private final By email = By.id("user_session_login");
    private final By password = By.id("user_session_password");
    private final By loginButton = By.xpath("//*[@class='form-group__fields']/*[@value='Log In']");
    private final By logged = By.xpath("//a[@href='/users/activations']");
    private final By wrongCredentials = By.cssSelector(".alert-box.alert-box--red.scaling-mb-2.size-90");
    private static final Logger log = getLogger(SignInPage.class.getName());

    public String signIn (String username, String pw){
        log.debug("Waiting on the page to be fully loaded");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        log.debug("Sending credentials to log in");
        driver.findElement(email).sendKeys(username);
        driver.findElement(password).sendKeys(pw);
        log.debug("Clicking the log in button");
        driver.findElement(loginButton).click();
        try{
            return driver.findElement(logged).getText();
        } catch (NoSuchElementException e) {
            return driver.findElement(wrongCredentials).getText();
        }
    }
}
