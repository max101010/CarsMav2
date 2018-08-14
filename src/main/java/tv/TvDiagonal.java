// Тест кейс 1
// Зайти на https://catalog.onliner.by/tv
// Нажать знак вопроса напротив "Диагональ"
// Проверить, что запись имеет текст
// c такими параметрами стиля:
// Диагональ (жирный)
// Размер диагонали экрана в дюймах.
// Минимальный комфортный размер
// зависит от расстояния между экраном
// и зрителем, поскольку необходимо,
// чтобы изображение занимало
// определенный процент поля зрения.
// (нормальный шрифт)

package tv;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class for the Mobile page.
 * <a>https://catalog.onliner.by/tv</a>
 */
public class TvDiagonal {

    /**
     * Create a new instance of class Logger.
     * use slf4j
     */
    private static final Logger LOG = LoggerFactory.getLogger(TvDiagonal.class);
    /**
     * Create a new variable of interface WebDriver.
     */
    private WebDriver driver;

    /**
     * Public constructor.
     * for the instance of class TvDiagonal
     * open page <a>https://catalog.onliner.by/tv</a>
     *
     * @param driver implementation of the WebDriver interface
     */
    public TvDiagonal(WebDriver driver) {
        LOG.info("view page - 'https://catalog.onliner.by/tv'");
        this.driver = driver;
        driver.get("https://catalog.onliner.by/tv");
    }

    /**
     * The method looks for the question button and clicks on it.
     */
    public void clickQuestion() {
        LOG.info("method start: clickQuestion()");
        By mailButton = By.xpath(
                "//div[text()='Диагональ']/parent::div/parent::div/preceding-sibling::div");
        LOG.debug("find button 'mailButton' - {}", mailButton.toString());
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,1000)");
        LOG.debug("create new instance JavascriptExecutor and scroll down");
        LOG.debug("click button 'mailButton'");
        driver.findElement(mailButton).click();
    }


    /**
     * The method finds the web element of the header and reads the text.
     *
     * @return string of heading
     */
    public String getHeading() {
        LOG.info("method start: getHeading()");
        WebElement element = driver.findElement(By.xpath(
                "//div[@id='schema-filter']/div[1]/div[7]/div[1]/div[2]/div/div[1]"));
        LOG.debug("return text from web element");
        return element.getText();
    }

    /**
     * Method reads the font size of the header.
     *
     * @return string - the size of the header
     */
    public String getFontForHeading() {
        LOG.info("method start: getFontForHeading()");
        WebElement element = driver.findElement(By.xpath(
                "//div[@id='schema-filter']/div[1]/div[7]/div[1]/div[2]/div/div[1]"));
        LOG.debug("return css from web element - {}",
                element.getCssValue("font-weight"));
        return element.getCssValue("font-weight");
    }

    /**
     * Method reads the font size of the description.
     *
     * @return string - the size of the description
     */
    public String getFontForText() {
        LOG.info("method start: getFontForText()");
        WebElement element = driver.findElement(By.xpath(
                "//div[@id='schema-filter']/div[1]/div[7]/div[1]/div[2]/div/div[1]"));
        LOG.debug("return css from web element - {}", element.getCssValue("font-weight"));
        return element.getCssValue("font-size");
    }

    /**
     * The method finds the web element of the description and reads the text.
     *
     * @return string of heading
     */
    public String getText() {
        LOG.info("method start: getText()");
        WebElement element = driver.findElement(By.xpath(
                "//div[@id='schema-filter']/div[1]/div[7]/div[1]/div[2]/div/div[2]"));
        LOG.debug("return text from web element");
        return element.getText();
    }


}
