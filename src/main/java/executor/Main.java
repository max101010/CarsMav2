package executor;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is main class.
 */
public class Main {

    /**
     * Create a new instance of class Logger.
     * use slf4j
     */
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);
    /**
     * Create a new variable of interface WebDriver.
     */
    private static WebDriver driver;

    /**
     * This is main method.
     * empty because it's created for testing
     *
     * @param args input values of the main method
     */
    public static void main(String[] args) {
        LOG.info("method start: main(String[] args)");
/*
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
*/
    }
}
