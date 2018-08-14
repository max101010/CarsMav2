
import htc.HTC;
import htc.HtcCompare;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class TestHTC {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "c:\\geckodriver.exe");
        driver = new ChromeDriver();
        // driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        HTC htc = new HTC(driver);
        htc.selectPhone();
    }

    @Test
    public void testHeading() {
        HtcCompare htcCompare = new HtcCompare(driver);
        boolean comparePhones = htcCompare.comparePhones();
        Assert.assertTrue(comparePhones);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
