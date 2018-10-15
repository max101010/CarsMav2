package steps;

import executor.ReaderJson;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.jbehave.core.annotations.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import tv.TvDiagonal;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ComparisonDescriptionsForTvOnTheSiteSteps {

    private static WebDriver driver = null;
    private static Map<String,String> values = ReaderJson.getValue("TestTv");
    private static String heading;
    private static String fontHeading;
    private static String text;
    private static String fontText;

    @Given("I open a browser for TV")
    public void openingBrowserForTv() {
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

    @When("I enter $url - page of Tv")
    public void enterPage() {

        driver.get("https://catalog.onliner.by/tv");
        System.out.println(values);
    }

    @When("I get heading texts")
    public void getHeadinsForTv() {
        System.out.println(Thread.currentThread().getId());
        TvDiagonal tvDiagonal = new TvDiagonal(driver);
        tvDiagonal.clickQuestion();
        heading = tvDiagonal.getHeading();
        fontHeading = tvDiagonal.getFontForHeading();
    }

    @Then("Headers match")
    public void compareHeadinsForTv() {
        Assert.assertEquals(values.get("text"), heading);
        Assert.assertEquals(values.get("heading_font"), fontHeading);
    }

    @When("I get description texts")
    public void getDescriptionText() {
        System.out.println(Thread.currentThread().getId());
        TvDiagonal tvDiagonal = new TvDiagonal(driver);
        tvDiagonal.clickQuestion();
        text = tvDiagonal.getText();
        fontText = tvDiagonal.getFontForText();
    }

    @Then("Descriptions match")
    public void compareTexts() {
        Assert.assertEquals(values.get("description"), text);
        Assert.assertEquals(values.get("description_font"), fontText);
    }

    @AfterStories
    public void closeBrowsersAfterStories() {
        driver.quit();
    }


}
