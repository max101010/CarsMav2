package steps;

import custom.TablePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertEquals;

public class VerificationOfTheCustomViewsForTableSteps {

    private static WebDriver driver;
    private static TablePage tablePage;

    @Given("I open a browser for table tests")
    public void openingBrowserForTable() {
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

    @Given("I enter $uri for the table test")
    public void openLink() {
        driver.get("https://www.myscore.com.ua/football/russia/premier-league/standings/");
    }

    @When("I select a table")
    public void selectTheTable() {
        tablePage = new TablePage(driver);
    }

    @Then("The number of the first line is 1")
    public void compareFirstLineNumber() {
        assertEquals("1.", tablePage.table.getRow(2).getCell(1).getText());
    }

    @Then("The size of the table is 17")
    public void compareTableSize() {
        assertEquals(17, tablePage.table.getTableSize());
    }

    @AfterStories
    public void closeBrowsersAfterStories() {
        driver.close();
    }


}



