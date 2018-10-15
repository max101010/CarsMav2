// Тест кейс 4
// Зайти на https://catalog.onliner.by/tabletpc
// В графе "Производитель"
// выбрать "Все 63 варианта"
// В появившемся окне выбрать
// 10 производителей из третьей колонки
// Убедиться, что в графе "Производитель"
// выбраны именно эти 10 производителей
// Убедиться, что врезультатах поиска
// нет других производителей

package tabletpc;

import executor.UtilsElements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * This class for the Mobile page.
 * <a>https://catalog.onliner.by/tabletpc</a>
 */
public class TabletPc {
    /**
     * Create a new instance of class Logger.
     * use slf4j
     */
    private static final Logger LOG = LoggerFactory.getLogger(TabletPc.class);
    /**
     * Create a new variable of interface WebDriver.
     */
    private WebDriver driver;

    /**
     * Public constructor.
     * for the instance of class TabletPc
     * open page <a>https://catalog.onliner.by/tabletpc</a>
     *
     * @param driver implementation of the WebDriver interface
     */
    public TabletPc(WebDriver driver) {
        this.driver = driver;
        LOG.info("view page - 'https://catalog.onliner.by/tabletpc'");
        driver.get("https://catalog.onliner.by/tabletpc");
    }

    /**
     * This method chooses 10 tablet PC companies.
     * method selects web elements in the opened frame
     * returns a new list of company names
     *
     * @return list of strings
     */
    public List<String> clickCompany() {
        LOG.info("method start: clickCompany()");
        final int countCompanies = 10;
        JavascriptExecutor jce = (JavascriptExecutor) driver;
        jce.executeScript("window.scrollBy(0,300)");
        LOG.debug(
                "create a new instance of JavaScriptExecutor and scroll down");
        driver.findElement(By.xpath(
                "//div[@id='schema-filter']/div[1]/div[3]/div[2]/div[1]/div")).click();
        LOG.debug("find the button - 'all 63 options' and click it");
        List<WebElement> boxesClick = driver.findElements(By.xpath(
                "//div[text()='p']/parent::div/following-sibling::div//span[@class='i-checkbox']"));
        LOG.debug("find the list of checkboxes in a frame - {}",
                boxesClick.toString());
        List<WebElement> boxesValues = driver.findElements(By.xpath(
                "//div[text()='p']/parent::div/following-sibling::div//span[@class='schema-filter__checkbox-text']"));
        LOG.debug("find the list of checkbox values in a frame - {}",
                boxesValues.toString());
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < countCompanies; i++) {
            boxesClick.get(i).click();
            result.add(boxesValues.get(i).getText());
        }
        LOG.debug("click 10 checkboxes and add values to the string list - {}",
                result.toString());
        result = UtilsElements.splitElements(result);
        LOG.debug("split strings by UtilsElements.splitElements() - {}",
                result.toString());
        return result;
    }

    /**
     * Method reads the checked checkboxes in the left frame.
     * if the checkbox is checked, it reads the company name
     * return list of company names
     *
     * @return list of strings
     */
    public List<String> checkCompany() {
        LOG.info("method start: checkCompany()");
        List<WebElement> cbxLeft = driver.findElements(By.xpath(
                "//div[@id='schema-filter']/div[1]/div[3]/div[2]/ul//input"));
        LOG.debug("search for a checkbox list of web elements on the left - {}",
                cbxLeft.toString());
        List<WebElement> cbxValues = driver.findElements(By.xpath(
                "//div[@id='schema-filter']/div[1]/div[3]/div[2]/ul//span[2]"));
        LOG.debug("search for a value list of web elements on the left - {}",
                cbxValues.toString());
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < cbxLeft.size(); i++) {
            if (cbxLeft.get(i).isSelected()) {
                result.add(cbxValues.get(i).getText());
            }
        }
        LOG.debug("create a new ArrayList and fill it with values - {}",
                result.toString());
        List<String> res = UtilsElements.splitElements(result);
        LOG.debug("split strings by UtilsElements.splitElements()");
        LOG.debug("return a list of companies - {}", res.toString());
        return res;
    }

    /**
     * The method reads company names in the search.
     * looking for a button 'next'
     * while a button exists, the method reads company names
     * returns a list of all company names in the search
     *
     * @return list of strings
     */
    public List<String> checkSearch() {
        LOG.info("method start: checkSearch()");
        List<String> result = new ArrayList<String>();
        LOG.debug("create the main ArrayList");
        while (true) {
            try {
                final int numMs = 2000;
                LOG.debug("Thread.sleep() - {}", Thread.currentThread());
                Thread.sleep(numMs);
            } catch (InterruptedException e) {
                LOG.error("InterruptedException");
                e.printStackTrace();
            }
            List<WebElement> buffElem = driver.findElements(By.xpath(
                    "//div[@class='schema-product__rating-group']/parent::div/parent::div/div[1]//span"));
            LOG.debug("search web element list - {}", buffElem.toString());
            List<String> buffString = UtilsElements.elemToText(buffElem);
            LOG.debug(
                    "convert of a list of Web elements into a list of strings - {}",
                    buffString.toString());
            result.addAll(buffString);
            LOG.debug("filling the main list - {}",
                    result.toString());
            List<WebElement> buttonNext = driver.findElements(By.xpath(
                    "//div[@id='schema-pagination']//a[@class='schema-pagination__main']"));
            LOG.debug("search the button 'next' - {}", buttonNext.toString());
            if (!buttonNext.isEmpty()) {
                LOG.debug("click buttonNext");
                buttonNext.get(0).click();
            } else {
                LOG.debug("button doesn't exist and exit the loop");
                break;
            }
        }
        result = UtilsElements.splitElements(result);
        LOG.debug("split strings by UtilsElements.splitElements()");
        LOG.debug("return a list of companies - {}", result.toString());
        return result;
    }


}


