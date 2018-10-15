//Тест кейс 3
//Зайти на https://catalog.onliner.by/mobile/apple/iphone732
//Прокрутить до "Аккумулятор и время работы"
//Убедиться, что:
//Тип аккумулятора = Li-ion
//Ёмкость аккумулятора = 1 960 мА·ч
//Время разговора = 14 часов
//Время ожидания = 1 неделя, 3 суток
package iphone;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class for the Iphone page.
 * <a>https://catalog.onliner.by/mobile/apple/iphone732</a>
 */
public class Iphone {
    /**
     * Create a new instance of class Logger.
     * use slf4j
     */
    private static final Logger LOG = LoggerFactory.getLogger(Iphone.class);
    /**
     * Create a new variable of interface WebDriver.
     */
    private WebDriver driver;

    /**
     * Public constructor.
     * for the instance of class Iphone
     * open page <a>https://catalog.onliner.by/mobile/apple/iphone732</a>
     *
     * @param driver implementation of the WebDriver interface
     */
    public Iphone(WebDriver driver) {
        this.driver = driver;
        LOG.info("view page - 'https://catalog.onliner.by/mobile/apple/iphone732'");
        driver.get("https://catalog.onliner.by/mobile/apple/iphone732");
    }

    /**
     * This method finds web elements.
     * gets their text value to the map
     *
     * @return map with the string key and value
     */
    public Map<String, String> getMapForIphone() {
        LOG.info("start method getMapForIphone");
        JavascriptExecutor exc = (JavascriptExecutor) driver;
        exc.executeScript("window.scrollBy(0,5000)");
        LOG.debug("create new instance JavascriptExecutor and scroll down");
        Map<String, String> result = new HashMap<String, String>();
        LOG.debug("create new Map<String,String> - {}", result.toString());
        List<WebElement> buff = driver.findElements(By.xpath(
                ".//table[@class='product-specs__table']/tbody[14]//tr/following-sibling::*//td"));
        LOG.debug("find webelements");
        for (int i = 0; i < buff.size(); i += 2) {
            result.put(buff.get(i).getText(), buff.get(i + 1).getText());
            result.remove("Несъёмный аккумулятор");
        }
        LOG.info("create new Map<String,String> - {}", result.toString());
        return result;
    }


}

