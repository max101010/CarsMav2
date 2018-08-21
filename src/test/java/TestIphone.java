
import executor.ReaderJson;
import io.github.bonigarcia.wdm.WebDriverManager;
import iphone.Iphone;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class TestIphone {
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.class);
    private static Map<String,String> values = ReaderJson.getValue("TestIphone");
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
    public void testHeading() {
        Iphone iphone = new Iphone(driver);
        Set<String> keysForIphone = iphone.getMapForIphone().keySet();
        Set<String> keysForCompare = values.keySet();
        keysForCompare.removeAll(keysForIphone);
        Collection<String> valuesForIphone = iphone.getMapForIphone().values();
        Collection<String> valuesForCompare = values.values();
        keysForCompare.removeAll(keysForIphone);
        log.info("compare keys two maps, result = {}", keysForCompare.isEmpty());
        valuesForCompare.removeAll(valuesForIphone);
        log.info("compare values two maps, result = {}", valuesForCompare.isEmpty());
        Assert.assertTrue(keysForCompare.isEmpty());
        Assert.assertTrue(valuesForCompare.isEmpty());
    }


    @After
    public void tearDown() {
        driver.quit();
    }

}


