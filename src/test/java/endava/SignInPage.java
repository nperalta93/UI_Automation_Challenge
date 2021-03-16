package endava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class SignInPage {
    private WebDriver driver;
    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By email = By.cssSelector("input#user_session_login");
    private final By password = By.id("user_session_password");
    private final By loginButton = By.xpath("//*[@class='form-group__fields']/*[@value='Log In']");
    private By logged;

    public String signIn (String username, String pw){
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.findElement(email).sendKeys(username);
        driver.findElement(password).sendKeys(pw);
        driver.findElement(loginButton).click();
        logged = By.cssSelector(".site-bg--white [data-signed-in]");
        if (!driver.findElement(logged).getAttribute("data-signed-in").equals("true")) {
            By wrongCredentials = By.cssSelector(".alert-box.alert-box--red.scaling-mb-2.size-90");
            return driver.findElement(wrongCredentials).getText();
        }
        else {
            return driver.findElement(logged).getAttribute("data-signed-in");
        }
    }
}
