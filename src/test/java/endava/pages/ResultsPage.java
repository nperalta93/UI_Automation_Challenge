package endava.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import static org.apache.logging.log4j.LogManager.getLogger;

import java.util.concurrent.TimeUnit;

public class ResultsPage {
    private WebDriver driver;
    private final By filteredBy;
    private final By minValue = By.xpath("//*[@id='minValue']");
    private final By maxValue = By.xpath("//*[@id='maxValue']");
//  TO DO: Replace the hard-coded values. Find out why does not work when the XPaths are create with the parameters of the query
    private final By filterPrice = By.xpath("//*[@class='search-pill__term'][contains(text(), '$1,200 – $2,300')]");
    private final By order = By.xpath("//*[@id='sort']/option[4]");
    private static final Logger log = getLogger(ResultsPage.class.getName());

    public ResultsPage(WebDriver driver, String query) {
        this.driver = driver;
        this.filteredBy = By.xpath("//*[@class='search-pill__term'][contains(text(),'" + query + "')]");
    }
    public String getFilter(){
        log.debug("Waiting on the page to be fully loaded");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        log.info("Filter of the search founded");
        return driver.findElement(filteredBy).getText().replace("\"", "");
    }

    public String priceFilter(String valueMin, String valueMax){
        log.debug("Waiting on the page to be fully loaded");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        log.debug("Typing in the values of the price filter");
        driver.findElement(minValue).sendKeys(valueMin);
        driver.findElement(maxValue).sendKeys(valueMax);
        log.debug("Clicking on the button to set the filter");
        driver.findElement(maxValue).sendKeys(Keys.ENTER);
        log.debug("Waiting on the filter to be applied to the page");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        log.info("Filter applied successfully");
        return driver.findElement(filterPrice).getText();
    }

    public void highToLow(){
        log.debug("Waiting on the page to be fully loaded");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        log.debug("Applying order");
        driver.findElement(order).click();
    }
}
