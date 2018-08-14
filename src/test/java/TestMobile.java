import iphone.Iphone;
import mobile.Mobile;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestMobile {

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
    public void testCountCheckboxes() {
        final int countCheckboxes = 30;
        Mobile mobile = new Mobile(driver);
        Assert.assertEquals(mobile.clickPhone(), countCheckboxes);
    }

    @Test
    public void testCountTitles() {
        final int countTitles = 30;
        Mobile mobile = new Mobile(driver);
        Assert.assertEquals(mobile.getCountHeadings(), countTitles);
    }

    @Test
    public void testCountDescriptions() {
        final int countDescriptions = 30;
        Mobile mobile = new Mobile(driver);
        Assert.assertEquals(mobile.getCountDescriptions(), countDescriptions);
    }

    @Test
    public void testCountPrices() {
        final int countPrices = 30;
        Mobile mobile = new Mobile(driver);
        Assert.assertEquals(mobile.getCountPrices(), countPrices);
    }

    @Test
    public void testNumberFormat() {
        Mobile mobile = new Mobile(driver);
        Assert.assertTrue(mobile.isFormat());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
