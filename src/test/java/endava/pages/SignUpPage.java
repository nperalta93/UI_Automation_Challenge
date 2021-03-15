package endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void SignUp(String propName, String propLastName, String propEmail, String propPassword){
        driver.findElement(firstName).sendKeys(propName);
        driver.findElement(lastName).sendKeys(propLastName);
        driver.findElement(email).sendKeys(propEmail);
        driver.findElement(password).sendKeys(propPassword);

        By signUpButton = By.xpath("//*[@class='form-group__fields']/*[@value='Sign Up']");//cssSelector("input[type=submit]");
//        WebDriverWait wait = new WebDriverWait(driver, 3);
//        wait.until(ExpectedConditions.elementToBeClickable(signUpButton));
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.findElement(signUpButton).click();
    }




}
