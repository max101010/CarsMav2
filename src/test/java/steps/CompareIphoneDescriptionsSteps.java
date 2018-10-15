package steps;

import executor.ReaderJson;

import io.github.bonigarcia.wdm.WebDriverManager;
import iphone.Iphone;
import org.jbehave.core.annotations.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CompareIphoneDescriptionsSteps {

    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.class);
    private static Map<String, String> values = ReaderJson.getValue("TestIphone");
    private static Collection<String> valuesForCompare;
    private static WebDriver driver;
    private static Set<String> keysForCompare;

    @Given("I open a browser for Iphone")
    public void openingBrowser() {
        if (driver == null) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
//            WebDriverManager.chromedriver().setup();
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--disable-extensions");
//            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        driver.manage().deleteAllCookies();
    }

    @When("I scroll down this page")
    public void getDescriptions() {
        Iphone iphone = new Iphone(driver);
        Set<String> keysForIphone = iphone.getMapForIphone().keySet();
        keysForCompare = values.keySet();
        keysForCompare.removeAll(keysForIphone);
        Collection<String> valuesForIphone = iphone.getMapForIphone().values();
        valuesForCompare = values.values();
        keysForCompare.removeAll(keysForIphone);
        log.info("compare keys two maps, result = {}", keysForCompare.isEmpty());
        valuesForCompare.removeAll(valuesForIphone);
        log.info("compare values two maps, result = {}", valuesForCompare.isEmpty());

    }

    @Then("Compare descriptions of Iphone")
    public void compareDescriptions() {
        Assert.assertTrue(keysForCompare.isEmpty());
        Assert.assertTrue(valuesForCompare.isEmpty());
    }

    @AfterStories
    public void closeBrowsersAfterStories() {
        driver.close();
    }

}


