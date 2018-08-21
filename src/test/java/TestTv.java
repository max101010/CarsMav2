import executor.ReaderJson;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import tv.TvDiagonal;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestTv {

    private WebDriver driver;
    private static Map<String,String> values = ReaderJson.getValue("TestTv");


    @Before
    public  void setUpd() {
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://catalog.onliner.by/tv");
    }


    @Test
    public void testHeading() {
        System.out.println(Thread.currentThread().getId());
        TvDiagonal tvDiagonal = new TvDiagonal(driver);
        tvDiagonal.clickQuestion();
        String heading = tvDiagonal.getHeading();
        String fontHeading = tvDiagonal.getFontForHeading();
        Assert.assertEquals(values.get("text"), heading);
        Assert.assertEquals(values.get("heading_font"), fontHeading);
    }

    @Test
    public void testText() {
        System.out.println(Thread.currentThread().getId());
        TvDiagonal tvDiagonal = new TvDiagonal(driver);
        tvDiagonal.clickQuestion();
        String text = tvDiagonal.getText();
        String fontText = tvDiagonal.getFontForText();
        Assert.assertEquals(values.get("description"), text);
        Assert.assertEquals(values.get("description_font"), fontText);
    }


    @After
    public  void tearDown() {
        driver.quit();
    }


}
