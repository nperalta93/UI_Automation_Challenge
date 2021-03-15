package endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage{

    private final By signUpLink = By.xpath("//a[@href='/signup']");
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

    public SignUpPage redirect(){
        driver.findElement(signUpLink).click();
        return new SignUpPage(driver);
    }

    public DrumsPercussionPage browseCategory(){
        driver.findElement(category).click();
        driver.findElement(subCategory).click();
        return new DrumsPercussionPage(driver);
    }


}
