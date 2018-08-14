
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
    public void testHeading() {
        Map<String, String> mapForCompare = new HashMap<String, String>();
        mapForCompare.put("Ёмкость аккумулятора", "1 960 мА·ч");
        mapForCompare.put("Время разговора", "14 часов");
        mapForCompare.put("Время ожидания", "1 неделя, 3 суток");
        mapForCompare.put("Тип аккумулятора", "Li-ion");
        Iphone iphone = new Iphone(driver);
        Set<String> keysForIphone = iphone.getMapForIphone().keySet();
        Set<String> keysForCompare = mapForCompare.keySet();
        keysForCompare.removeAll(keysForIphone);
        Collection<String> valuesForIphone = iphone.getMapForIphone().values();
        Collection<String> valuesForCompare = mapForCompare.values();
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


