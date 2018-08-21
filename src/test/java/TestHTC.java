
import htc.HTC;
import htc.HtcCompare;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class TestHTC {
    private WebDriver driver;

    @Before
    public void setUp() {
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        HTC htc = new HTC(driver);
        htc.selectPhone();
    }

    @Test
    public void testHTC() {
        HtcCompare htcCompare = new HtcCompare(driver);
        boolean comparePhones = htcCompare.comparePhones();
        Assert.assertTrue(comparePhones);
    }


    @After
    public void tearDown() {
        driver.quit();
    }

}
