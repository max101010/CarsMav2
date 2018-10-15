package custom;

import com.github.webdriverextensions.WebDriverExtensionFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class to look for the table.
 */
public class TablePage {
    /**
     * @param driver instance of WebDriver
     */
    public TablePage(WebDriver driver) {
        PageFactory
                .initElements(
                        new WebDriverExtensionFieldDecorator(driver),
                        this);
    }

    /**
     * Search table.
     */
    @FindBy(id = "table-type-1")
    public Table table;

}
