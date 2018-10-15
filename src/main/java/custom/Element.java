package custom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.interactions.Locatable;

/**
 * This interface is designed to combine interfaces.
 */
public interface Element extends WebElement, WrapsElement, Locatable {

}


