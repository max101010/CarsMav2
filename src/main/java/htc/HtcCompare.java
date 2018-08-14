// Тест кейс 5
// Зайти на https://catalog.onliner.by/
// В строке поиска набрать HTC
// В появившемся окне отметить
// 2 любых телефона
// и нажать "2 товара в сравнении"
// В новом окне убедиться,
// что показываются именно
// выбранные телефоны
// (имя, описание, цена)
package htc;

import executor.UtilsElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class for the HTCCompare page.
 */
public class HtcCompare {

    /**
     * Create a new instance of class Logger.
     * use slf4j
     */
    private static final Logger LOG = LoggerFactory.getLogger(HtcCompare.class);
    /**
     * Create a new variable of interface WebDriver.
     */
    private WebDriver driver;

    /**
     * Public constructor.
     * for the instance of class HTC
     *
     * @param driver implementation of the WebDriver interface
     */
    public HtcCompare(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * This method compares 2 selected phones.
     * compered headlines
     * @return boolean: false or true
     */
    public boolean comparePhones() {
       LOG.info("start method comparePhones");
        driver.switchTo().defaultContent();
        LOG.debug("driver switch to default window");
        List<WebElement> elementsTitles = driver.findElements(By.xpath(
                "//span[@class='product-summary__caption']"));
        LOG.debug("find elements of title phones - {}", elementsTitles);
        Set<String> titlesText = new HashSet<String>(
                UtilsElements.elemToText(elementsTitles));
        LOG.debug("modification list of webelements to strings");
        HTC htc = new HTC();
        LOG.debug("create new instance - {}", htc.toString());
        htc.titlesForCompare.removeAll(titlesText);
        boolean b = htc.titlesForCompare.isEmpty();
        LOG.info("compare two pages, result - {}",
                htc.titlesForCompare.isEmpty());
        return htc.titlesForCompare.isEmpty();
    }
}
