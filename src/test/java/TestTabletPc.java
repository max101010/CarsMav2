import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tabletpc.TabletPc;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestTabletPc {

    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.class);
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "c:\\geckodriver.exe");
        driver = new ChromeDriver();
        // driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testCompaniesInBox() {
        TabletPc tabletPc = new TabletPc(driver);
        List<String> listCompaniesInBox = tabletPc.clickCompany();
        List<String> listCompaniesInLeft = tabletPc.checkCompany();
        listCompaniesInBox.removeAll(listCompaniesInLeft);
        Assert.assertTrue(listCompaniesInBox.isEmpty());
    }

    @Test
    public void testCompaniesInSearch() {
        TabletPc tabletPc = new TabletPc(driver);
        List<String> listCompaniesInBox = tabletPc.clickCompany();
        List<String> listCompaniesInSearch = tabletPc.checkSearch();
        listCompaniesInSearch.removeAll(listCompaniesInBox);
        Assert.assertTrue(listCompaniesInSearch.isEmpty());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}

