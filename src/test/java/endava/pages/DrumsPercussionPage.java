package endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DrumsPercussionPage {
    private final By categoryTitle = By.cssSelector(".cms-centered-page-head__title");
    private WebDriver driver;

    public DrumsPercussionPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle(){
        return driver.findElement(categoryTitle).getText();
    }
}
