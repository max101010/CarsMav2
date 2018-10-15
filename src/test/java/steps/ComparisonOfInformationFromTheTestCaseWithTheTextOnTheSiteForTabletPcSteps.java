package steps;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tabletpc.TabletPc;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ComparisonOfInformationFromTheTestCaseWithTheTextOnTheSiteForTabletPcSteps {

    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.class);
    private static WebDriver driver;
    private static List<String> listCompaniesInBoxForOnTheLeft;
    private static List<String> listCompaniesInSearch;
    private static List<String> listCompaniesInBoxForInTheSearch;

    @Given("I open a browser for tabletPC tests")
    public void openingBrowserForTabletPC() {
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

    @When("I select the companies on the left")
    public void selectCompanies() {
        TabletPc tabletPc = new TabletPc(driver);
        listCompaniesInBoxForOnTheLeft = tabletPc.clickCompany();
        List<String> listCompaniesInLeft = tabletPc.checkCompany();
        listCompaniesInBoxForOnTheLeft.removeAll(listCompaniesInLeft);
    }

    @When("I select the companies in the search")
    public void selectCompaniesInSearch() {
        TabletPc tabletPc = new TabletPc(driver);
        listCompaniesInBoxForInTheSearch = tabletPc.clickCompany();
        listCompaniesInSearch = tabletPc.checkSearch();
        listCompaniesInSearch.removeAll(listCompaniesInBoxForInTheSearch);
    }

    @Then("Company verification on the left")
    public void compareCompaniesOnTheLeft() {
        Assert
                .assertTrue(listCompaniesInBoxForOnTheLeft.isEmpty());
    }

    @Then("Company verification in the search")
    public void compareCompaniesInTheSearch() {
        Assert
                .assertTrue(listCompaniesInSearch.isEmpty());
    }

    @AfterStories
    public void closeBrowsersAfterStories() {
        driver.close();
    }


}


