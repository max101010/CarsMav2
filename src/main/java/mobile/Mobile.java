// Тест кейс 2
// Зайти на https://catalog.onliner.by/mobile
// Убедиться, что показывается
// 30 товаров на странице
// Проверить, что у каждого товара
// есть название, описание и цена
// Проверить, что цена имеет формат "xxx,xx"

package mobile;

import executor.UtilsElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class for the Mobile page.
 * <a>https://catalog.onliner.by/mobile</a>
 */
public class Mobile {

    /**
     * Create a new instance of class Logger.
     * use slf4j
     */
    private static final Logger LOG = LoggerFactory.getLogger(Mobile.class);
    /**
     * Create a new variable of interface WebDriver.
     */
    private WebDriver driver;

    /**
     * Public constructor.
     * for the instance of class Mobile
     * open page <a>https://catalog.onliner.by/mobile</a>
     *
     * @param driver implementation of the WebDriver interface
     */
    public Mobile(WebDriver driver) {
        this.driver = driver;
        driver.get("https://catalog.onliner.by/mobile");
        LOG.info("view page - 'https://catalog.onliner.by/mobile'");
    }

    /**
     * This method finds checkboxes.
     * for mobile phones
     *
     * @return int - size of checkbox list
     */
    public int clickPhone() {
        LOG.info("method start: clickPhone()");
        List<WebElement> checkboxes = driver.findElements(By.xpath(
                "//div[@class='schema-product__group']/div/div/div/div/label/span/span"));
        LOG.debug("find checkboxes of phones - {}", checkboxes.toString());
        LOG.debug("return a size of list, size = {}", checkboxes.size());
        return checkboxes.size();
    }

    /**
     * Method returns a list of headers.
     * for mobile phones
     *
     * @return list of strings
     */
    public List<String> getHeading() {
        LOG.info("method start: getHeading()");
        List<String> headings = UtilsElements.elemToText(findHeadings());
        LOG.debug("getting a string list from a web element list: {}",
                headings.toString());
        return headings;
    }

    /**
     * Method returns a size of heading list.
     *
     * @return int - size of heading list
     */
    public int getCountHeadings() {
        LOG.info("method start: getCountHeadings()");
        LOG.debug("getting size of heading list, size = {}",
                findHeadings().size());
        return findHeadings().size();
    }

    /**
     * This method returns the list of font sizes.
     *
     * @return list of strings
     */
    public List<String> getFontWeight() {
        LOG.info("method start: getFontWeight()");
        List<String> fontWeights = new ArrayList<String>();
        for (WebElement element : findHeadings()) {
            fontWeights.add(element.getCssValue("font-weight"));
        }
        LOG.debug("return the list of font sizes");
        return fontWeights;
    }

    /**
     * This method returns the list of descriptions.
     * for all mobile phones on the page
     *
     * @return list of strings
     */
    public List<String> getMobileDescriptions() {
        LOG.info("method start: getMobileDescriptions()");
        List<String> texts = UtilsElements.elemToText(findDescriptions());
        LOG.debug("return a string list of descriptions: {}", texts.toString());
        return texts;
    }

    /**
     * This method returns the number of descriptions in the list.
     *
     * @return int - the size of the description list
     */
    public int getCountDescriptions() {
        LOG.info("method start: getCountDescriptions()");
        LOG.debug("return a size of description list, size = ",
                findDescriptions().size());
        return findDescriptions().size();
    }

    /**
     * Method returns a list of prices.
     * for mobile phones
     *
     * @return list of strings
     */
    public String[] getMobilePrices() {
        LOG.info("method start: getMobilePrices()");
        List<String> prices = UtilsElements.elemToText(findPrices());
        LOG.debug("getting a string list of prices");
        final int arrSize = 30;
        String[] arrPrices = new String[arrSize];
        LOG.debug("create a new array with size 30");
        int count = 0;
        if (prices.size() <= arrSize) {
            for (String price : prices) {
                String[] buff = price.split("\\s+");
                arrPrices[count++] = buff[0];
            }
        } else {
            LOG.error("list more than 30, size = {}", prices.size());
            throw new IndexOutOfBoundsException("list more than 30, size = " + prices.size());
        }
        LOG.debug("return String[], {}", Arrays.toString(arrPrices));
        return arrPrices;
    }

    /**
     * This method returns the number of prices in the list.
     *
     * @return int - the size of the description list
     */
    public int getCountPrices() {
        LOG.info("method start: getCountPrices()");
        LOG.debug("return size of a price list, size = {}",
                findPrices().size());
        return findPrices().size();
    }

    /**
     * This method checks the format of the price.
     * format - 'xxx.xx' or 'xxxx.xx'
     *
     * @return boolean - true or false
     */
    public boolean isFormat() {
        final int numFormatBeforeMin = 3;
        final int numFormatBeforeMax = 4;
        final int numFormatAfter = 2;
        LOG.info("method start: isFormat()");
        String[] prices = getMobilePrices();
        LOG.debug("create a new String[] and fill it with a method: getMobilePrices: {}", Arrays.toString(prices));
        for (String price : prices) {
            if (price == null) {
                LOG.error("an element of array is equal to null");
                continue;
            }
            price = price.replaceAll(",", ".");
            LOG.debug("replace ',' in the array - {}", price);
            if (!UtilsElements.isNumeric(price)) {
                LOG.error("string is not the number format");
                return false;
            }
            String[] splitter = price.split("\\.");
            if (splitter[1].length() != numFormatAfter) {
                LOG.error("the number of digits after the point is incorrect");
                return false;
            } else if (splitter[0].length() != numFormatBeforeMin
                    && splitter[0].length() != numFormatBeforeMax) {
                LOG.error("the number of digits before the point is incorrect");
                return false;
            }
        }
        LOG.info("return: true");
        return true;
    }

    /**
     * This method looks for web elements for a list of headers.
     *
     * @return list of web elements
     */
    private List<WebElement> findHeadings() {
        LOG.info("method start: findHeadings");
        List<WebElement> result = driver.findElements(By.xpath(
                "//div[@class='schema-product__info']/parent::div/div[1]//span"));
        LOG.debug("getting a web element list of heading - {}",
                result.toString());
        return result;
    }

    /**
     * This method looks for web elements for a list of descriptions.
     *
     * @return list of web elements
     */
    private List<WebElement> findDescriptions() {
        LOG.info("method start: findDescriptions");
        List<WebElement> result = driver.findElements(By.xpath(
                "//div[@class='schema-product__info']/parent::div/div[2]//span"));
        LOG.debug("getting a web element list of descriptions - {}",
                result.toString());
        return result;
    }

    /**
     * This method looks for web elements for a list of prices.
     *
     * @return list of web elements
     */
    private List<WebElement> findPrices() {
        LOG.info("method start: findPrices()");
        List<WebElement> result = driver.findElements(By.xpath(
                "//div[@class='schema-product__price-group']/div[1]/div[1]//span"));
        LOG.debug("getting a web element list of prices - {}", result);
        return result;

    }


}


