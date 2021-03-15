package endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ResultsPage {
    private WebDriver driver;
    private final By filteredBy;
    private final By minValue = By.xpath("//*[@id='minValue']");
    private final By maxValue = By.xpath("//*[@id='maxValue']");
//  TO DO: find a better locator for set
    private final By set = By.cssSelector("body>main>section>div:nth-child(2)>div>div>div.faceted-grid>div>div.faceted-grid__facets>div>div>div:nth-child(2)>div:nth-child(5)>div.search-input-group>form>div>button");
//  TO DO: Replace the hard-coded values. Find out why does not work when the xpaths are create with the parameters of the query
    private final By filterPrice = By.xpath("//*[@class='search-pill__term'][contains(text(), '$1,200 – $2,300')]");
    private final By order = By.xpath("//*[@id='sort']/option[4]");

    public ResultsPage(WebDriver driver, String query) {
        this.driver = driver;
        this.filteredBy = By.xpath("//*[@class='search-pill__term'][contains(text(),'" + query + "')]");
    }
    public String getFilter(){
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        return driver.findElement(filteredBy).getText().replace("\"", "");
    }

    public String pricerFilter(String valueMin, String valueMax){
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.findElement(minValue).sendKeys(valueMin);
        driver.findElement(maxValue).sendKeys(valueMax);
        driver.findElement(set).click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        return driver.findElement(filterPrice).getText();
    }

    public String highToLow(){
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.findElement(order).click();
        return "piece of shit";
    }
}
