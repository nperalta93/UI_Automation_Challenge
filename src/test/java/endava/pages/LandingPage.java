package endava.pages;

import static org.apache.logging.log4j.LogManager.getLogger;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage{

    private By sign;
    private final By searchBar = By.cssSelector("input[placeholder='Shop for used & new music gear...']");
    private final By searchButton = By.cssSelector(".site-search__controls__submit");
    private final By category = By.cssSelector(".category-flyout-header__link[data-header-category='drums']");
    private final By subCategory = By.xpath("//a[@href='https://reverb.com/c/drums-and-percussion/acoustic-drums']");
    private static final Logger log = getLogger(LandingPage.class.getName());

    public LandingPage(WebDriver driver){
        super(driver);
    }

    public ResultsPage search(String query){
        log.debug("Typing " + query + " in the search bar");
        driver.findElement(searchBar).sendKeys(query);
        log.debug("Clicking on the search button");
        driver.findElement(searchButton).click();
        log.info("Item found");
        return new ResultsPage(driver, query);
    }

    public SignUpPage singUpRedirect(String query){
        log.debug("Building the Xpath for the redirection");
        sign = By.xpath("//a[@href='/" + query + "']");
        log.debug("Clicking on the option requested");
        driver.findElement(sign).click();
        log.info("Redirected to the requested form");
        return new SignUpPage(driver);
    }

    public SignInPage signInRedirect(String query){
        log.debug("Building the Xpath for the redirection");
        sign = By.xpath("//a[@href='/" + query + "']");
        log.debug("Clicking on the option requested");
        driver.findElement(sign).click();
        log.info("Redirected to the requested form");
        return new SignInPage(driver);
    }

    public CategoryPage browseCategory(){
        log.debug("Clicking on the category selected");
        driver.findElement(category).click();
        log.debug("Clicking on the category selected");
        driver.findElement(subCategory).click();
        log.info("Redirected to the subcategory requested");
        return new CategoryPage(driver);
    }


}
