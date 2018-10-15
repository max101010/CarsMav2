package executor;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * It's a utilitarian class.
 * it contains static methods
 * that are often used in classes
 */
public class UtilsElements {
    /**
     * Create a new instance of class Logger.
     * use slf4j
     */
    private static final Logger LOG = LoggerFactory.
            getLogger(UtilsElements.class);

    /**
     * Private constructor.
     * this is class contains
     * only static methods
     */
    private UtilsElements() {
        throw new IllegalArgumentException();
    }

    /**
     * This method converts.
     * the list of Web Elements
     * into a list of strings
     *
     * @param list of web elements
     * @return a new list of strings
     */
    public static List<String> elemToText(List<WebElement> list) {
        LOG.info("method start: elemToText(List<WebElement> list");
        List<String> result = new ArrayList<String>();
        LOG.debug("create a new ArrayList<String>");
        for (WebElement element : list) {
            result.add(element.getText());
        }
        LOG.debug("return a list of string - {}", result.toString());
        return result;
    }

    /**
     * This method separates the strings.
     * in the list into separate words by spaces
     *
     * @param list of strings
     * @return a new list of strings
     */
    public static List<String> splitElements(List<String> list) {
        LOG.info("method start: splitElements(List<String> list");
        List<String> result = new ArrayList<String>();
        LOG.debug("create a new ArrayList<String>");
        for (int i = 0; i < list.size(); i++) {
            String[] arr = list.get(i).split("\\s+");
            result.add(i, arr[0]);
        }
        LOG.debug("return a list of string - {}", result.toString());
        return result;
    }

    /**
     * This method separates the strings.
     * in the list into separate words by commas
     *
     * @param list of web elements
     * @return list of strings
     */
    public static List<String> split(List<WebElement> list) {
        LOG.info("method start: split(List<WebElement> list");
        List<String> result = new ArrayList<String>();
        LOG.debug("create a new ArrayList<String>");
        for (WebElement element : list) {
            String[] array = element.getText().split("\\s*,\\s*");
            result.add(array[0]);
        }
        LOG.debug("return a list of string - {}", result.toString());
        return result;
    }

    /**
     * This method checks.
     * if a string is the number of type double
     *
     * @param str verification string
     * @return boolean: true or false
     */
    public static boolean isNumeric(String str) {
        LOG.info("method start: isNumeric(String str)");
        try {
            Double.parseDouble(str);
            LOG.debug("return true if Double.parseDouble(str)");
            return true;
        } catch (NumberFormatException e) {
            LOG.error("invalid numeric format - {}", e);
            return false;
        }
    }
}


