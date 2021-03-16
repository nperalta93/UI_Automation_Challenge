package endava.pages;

import endava.SignInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage{

    private By sign;
    private final By searchBar = By.cssSelector("input[placeholder='Shop for used & new music gear...']");
    private final By searchButton = By.cssSelector(".site-search__controls__submit");
    private final By category = By.cssSelector(".category-flyout-header__link[data-header-category='drums']");
    private final By subCategory = By.xpath("//a[@href='https://reverb.com/c/drums-and-percussion/acoustic-drums']");
    private WebDriver driver;

    public LandingPage(WebDriver driver){
        this.driver = driver;
    }

    public ResultsPage search(String query){
        driver.findElement(searchBar).sendKeys(query);
        driver.findElement(searchButton).click();
        return new ResultsPage(driver, query);
    }

    public SignUpPage singUpRedirect(String query){
        sign = By.xpath("//a[@href='/" + query + "']");
        driver.findElement(sign).click();
        return new SignUpPage(driver);
    }

    public SignInPage signInRedirect(String query){
        sign = By.xpath("//a[@href='/" + query + "']");
        driver.findElement(sign).click();
        return new SignInPage(driver);
    }

    public DrumsPercussionPage browseCategory(){
        driver.findElement(category).click();
        driver.findElement(subCategory).click();
        return new DrumsPercussionPage(driver);
    }


}
