package endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import static org.apache.logging.log4j.LogManager.getLogger;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SignUpPage extends BasePage{

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    private final By firstName = By.id("user_first_name");
    private final By lastName =  By.id("user_last_name");
    private final By email = By.id("user_email");
    private final By password = By.id("user_password");
    private By logged = By.xpath("//a[@href='/users/activations']");
    private static final Logger log = getLogger(SignUpPage.class.getName());

    public String SignUp(String propName, String propLastName, String propEmail, String propPassword){
        log.debug("Waiting on the page to be fully loaded");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        log.debug("Typing in the form requests to create a new account");
        driver.findElement(firstName).sendKeys(propName);
        driver.findElement(lastName).sendKeys(propLastName);
        driver.findElement(email).sendKeys(propEmail);
        driver.findElement(password).sendKeys(propPassword);
        log.debug("Clicking to create a new account");
        driver.findElement(password).sendKeys(Keys.ENTER);
        log.info("Account created");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(logged));
        return driver.findElement(logged).getText();
    }
}
