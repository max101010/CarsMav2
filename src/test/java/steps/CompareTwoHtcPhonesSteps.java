package steps;

import htc.HTC;
import htc.HtcCompare;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.jbehave.core.annotations.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class CompareTwoHtcPhonesSteps {

    private static WebDriver driver = null;

    @Given("I open a browser")
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

    @When("I enter $url and select two HTC phones")
    public void selectTwoHtcPhones() {
        HTC htc = new HTC(driver);
        htc.selectPhone();
    }

    @Then("Descriptions of the same")
    public void compareHtcPhones() {
        HtcCompare htcCompare = new HtcCompare(driver);
        boolean comparePhones = htcCompare.comparePhones();
        Assert.assertTrue(comparePhones);
    }

    @AfterStories
    public void closeBrowsersAfterStories() {
        driver.close();
    }

}
