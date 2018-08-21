import custom_elements.TablePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertEquals;

public class TestTable {
    private WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.myscore.com.ua/football/russia/premier-league/standings/");
    }
    @Test
    public void tableTest() {
        TablePage tablePage = new TablePage(driver);
        assertEquals("1.",tablePage.table.getRow(2).getCell(1).getText());
        assertEquals(17, tablePage.table.getTableSize());

    }

    @After
    public  void tearDown() {
        driver.quit();
    }

}