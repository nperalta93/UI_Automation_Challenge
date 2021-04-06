package endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryPage extends BasePage{
    private final By categoryTitle = By.cssSelector(".cms-centered-page-head__title");

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(categoryTitle));
        return driver.findElement(categoryTitle).getText();
    }
}
