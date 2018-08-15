// Тест кейс 5
// Зайти на https://catalog.onliner.by/
// В строке поиска набрать HTC
// В появившемся окне
// отметить 2 любых телефона
// и нажать "2 товара в сравнении"
// В новом окне убедиться,
// что показываются именно
// выбранные телефоны
// (имя, описание, цена)

package htc;

import executor.UtilsElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.ArrayList;
import java.util.List;

/**
 * This class for the HTC page.
 */
public class HTC {

    /**
     * Create a new instance of class Logger.
     * use slf4j
     */
    private static final Logger LOG = LoggerFactory.getLogger(HTC.class);
    /**
     * Create a new ArrayList.
     * added titles for comparison
     */
    List<String> titlesForCompare = new ArrayList<String>();
    /**
     * Create a new variable of interface WebDriver.
     */
    private WebDriver driver;

    /**
     * Public constructor.
     * for the instance of class HTC
     * open page - <a>https://catalog.onliner.by</a>
     *
     * @param driver implementation of the WebDriver interface
     */
    public HTC(WebDriver driver) {
        LOG.info("view page - 'https://catalog.onliner.by'");
        this.driver = driver;
        driver.get("https://catalog.onliner.by");
    }

    /**
     * Public default constructor.
     * used in the class of HtcCompare
     */
    public HTC() {

    }

    /**
     * This method finds the search string.
     * sends HTC
     * selects randomly from 10 products 2 phones,
     * presses the compare button and moves to the next page
     *
     * @return new instance of class HtcCompare
     */
    public HtcCompare selectPhone() {
        LOG.info("start method selectPhone");
        WebElement element = driver.
                findElement(By.xpath("//input[@class='fast-search__input']"));
        LOG.debug("find element - input line {}", element);
        element.sendKeys("HTC");
        LOG.debug("send 'HTC'");
        if (driver instanceof FirefoxDriver) {
            driver.switchTo().frame(0);
            LOG.info("use FirefoxDriver");
        } else if (driver instanceof ChromeDriver) {
            driver.switchTo().frame(1);
            LOG.info("use ChromeDriver");
        }
        try {
            LOG.debug("Thread.sleep - {}", Thread.currentThread());
            final int numMs = 3000;
            Thread.sleep(numMs);
        } catch (InterruptedException e) {
            LOG.error("Thread.sleep is error {}", e);
            e.printStackTrace();
        }
        //find checkboxes
        List<WebElement> listCheckBox = driver.
                findElements(By.xpath("//span[@class='i-checkbox__faux']"));
        LOG.debug("find checkboxes - {}", listCheckBox);
        //find descriptions
        List<WebElement> listDesciptions = driver.
                findElements(By.xpath("//a [@class='product__description']"));
        LOG.debug("find listDescriptions - {}", listDesciptions);
        List<String> listDescrString = UtilsElements.split(listDesciptions);
        LOG.debug("get listDescrptions - {}", listDescrString);
        List<WebElement> titles = driver.
                findElements(By.xpath("//a[@class='product__title-link']"));
        LOG.debug("find List<WebElement> of titles - {}", titles);
        List<String> titlesString = UtilsElements.elemToText(titles);
        LOG.debug("get titles as a sting - {} ", titlesString);
        int count = 0;
        int getNumber = -1;
        try {
            final int numMs = 2000;
            Thread.sleep(numMs);
            LOG.debug("thread sleep - {}", Thread.currentThread());
        } catch (InterruptedException e) {
            e.printStackTrace();
            LOG.error("InterruptedException - {}", e);
        }
        while (count < 2) {
            final int limit = 10;
            int num = (int) (Math.random() * limit);
            if (listDescrString.get(num).
                    equals("Android") && getNumber != num) {
                listCheckBox.get(num).click();
                titlesForCompare.add(titlesString.get(num));
                getNumber = num;
                count++;
            }
        }
        LOG.info("choice of two phones");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement elementButton = driver.findElement(By.xpath(
                "//a[@class='compare-button__sub compare-button__sub_main']"));
        LOG.debug("search compare button - {}", elementButton);
        elementButton.click();
        LOG.debug("click compare button - {}", elementButton);
        LOG.info("go to a new page");
        return new HtcCompare(driver);
    }


}


