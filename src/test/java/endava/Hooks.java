package endava;

import endava.pages.LandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Hooks {
    protected WebDriver driver;
    protected LandingPage landing;
    protected static Properties props;

    @BeforeClass
    public void createTestEnvironment(){
        props = new Properties();
        try {
            props.load(new FileInputStream("website.properties"));
        }catch (IOException var2){
            System.out.println("An error occurred trying to read the properties file");
        }
    }

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(props.getProperty("url"));
        landing = new LandingPage(driver);
    }

    @AfterTest
    public void dismantle(){
        driver.quit();
    }
}
