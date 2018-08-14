import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import tv.TvDiagonal;

import java.util.concurrent.TimeUnit;

public class TestTv {

    private WebDriver driver;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "c:\\geckodriver.exe");
        driver = new ChromeDriver();
        // driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://catalog.onliner.by/tv");
    }

    @Test
    public void testHeading() {
        TvDiagonal tvDiagonal = new TvDiagonal(driver);
        tvDiagonal.clickQuestion();
        String heading = tvDiagonal.getHeading();
        String fontHeading = tvDiagonal.getFontForHeading();
        Assert.assertEquals("Диагональ", heading);
        Assert.assertEquals("700", fontHeading);
    }

    @Test
    public void testText() {
        TvDiagonal tvDiagonal = new TvDiagonal(driver);
        tvDiagonal.clickQuestion();
        String text = tvDiagonal.getText();
        String fontText = tvDiagonal.getFontForText();
        Assert.assertEquals("Размер диагонали экрана в дюймах." +
                " Минимальный комфортный размер зависит от расстояния между" +
                " экраном и зрителем, поскольку необходимо, чтобы изображение" +
                " занимало определенный процент поля зрения.", text);
        Assert.assertEquals("13px", fontText);
    }


    @After
    public void tearDown() {

        driver.quit();
    }


}
