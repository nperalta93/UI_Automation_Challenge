package endava;

import static org.apache.logging.log4j.LogManager.getLogger;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class SignInPage {
    private WebDriver driver;
    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By email = By.id("user_session_login");
    private final By password = By.id("user_session_password");
    private final By loginButton = By.xpath("//*[@class='form-group__fields']/*[@value='Log In']");
    private static final Logger log = getLogger(SignInPage.class.getName());
    private By logged;

    public String signIn (String username, String pw){
        log.debug("Waiting on the page to be fully loaded");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        log.debug("Sending credentials to log in");
        driver.findElement(email).sendKeys(username);
        driver.findElement(password).sendKeys(pw);
        log.debug("Clicking the log in button");
        driver.findElement(loginButton).click();
        logged = By.cssSelector(".site-bg--white [data-signed-in]");
        if (!driver.findElement(logged).getAttribute("data-signed-in").equals("true")) {
            By wrongCredentials = By.cssSelector(".alert-box.alert-box--red.scaling-mb-2.size-90");
            log.info("The credentials are incorrect. Log in is not possible");
            return driver.findElement(wrongCredentials).getText();
        }
        else {
            log.info("Successful login");
            return driver.findElement(logged).getAttribute("data-signed-in");
        }
    }
}
