package endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class SignUpPage {

    private WebDriver driver;
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By firstName = By.id("user_first_name");
    private final By lastName =  By.id("user_last_name");
    private final By email = By.id("user_email");
    private final By password = By.id("user_password");
    private By logged;

    public String SignUp(String propName, String propLastName, String propEmail, String propPassword){
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.findElement(firstName).sendKeys(propName);
        driver.findElement(lastName).sendKeys(propLastName);
        driver.findElement(email).sendKeys(propEmail);
        driver.findElement(password).sendKeys(propPassword);
        driver.findElement(password).sendKeys(Keys.ENTER);
        logged = By.cssSelector(".site-bg--white [data-signed-in]");
        return driver.findElement(logged).getAttribute("data-signed-in");
    }
}
