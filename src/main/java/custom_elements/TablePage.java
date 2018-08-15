package custom_elements;

import com.github.webdriverextensions.WebDriverExtensionFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TablePage {
        public TablePage(WebDriver driver) {
            PageFactory.initElements(new WebDriverExtensionFieldDecorator(driver), this);
        }

        @FindBy(id = "table-type-1")
        public Table table;

    }

