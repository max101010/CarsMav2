import executor.ReaderJson;
import io.github.bonigarcia.wdm.WebDriverManager;
import mobile.Mobile;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestMobile {

    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.class);
    private static Map<String,String> values = ReaderJson.getValue("TestMobile");
    private WebDriver driver;

    @Before
    public void setUp() {
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testCountCheckboxes() {
        Mobile mobile = new Mobile(driver);
        Assert.assertEquals(mobile.clickPhone(), values.get("countCheckboxes"));
    }

    @Test
    public void testCountTitles() {
        Mobile mobile = new Mobile(driver);
        Assert.assertEquals(mobile.getCountHeadings(),values.get("countTitles"));
    }

    @Test
    public void testCountDescriptions() {
        Mobile mobile = new Mobile(driver);
        Assert.assertEquals(mobile.getCountDescriptions(), values.get("countDescriptions"));
    }

    @Test
    public void testCountPrices() {
        Mobile mobile = new Mobile(driver);
        Assert.assertEquals(mobile.getCountPrices(), values.get("countPrices"));
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
