package custom;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.interactions.internal.Coordinates;

import java.util.List;

/**
 * Skeleton class for custom elements.
 */
public abstract class ElementImpl implements Element {

    /**
     * Web element.
     */
    private final WebElement element;

    /**
     * Constructor.
     * @param element WebElement.
     */
    ElementImpl(final WebElement element) {
        this.element = element;
    }

    public void click() {
        element.click();
    }

    public void submit() {
        element.submit();
    }

    public void sendKeys(CharSequence... keysToSend) {
        element.sendKeys(keysToSend);
    }

    public void clear() {
        element.clear();
    }

    public String getTagName() {
        return element.getTagName();
    }

    public String getAttribute(String s) {
        return element.getAttribute(s);
    }

    public boolean isSelected() {
        return element.isSelected();
    }

    public boolean isEnabled() {
        return element.isEnabled();
    }

    public String getText() {
        return element.getText();
    }

    public List<WebElement> findElements(By by) {
        return null;
    }

    public WebElement findElement(By by) {
        return null;
    }

    public boolean isDisplayed() {
        return false;
    }

    public Point getLocation() {
        return null;
    }

    public Dimension getSize() {
        return null;
    }

    public Rectangle getRect() {
        return null;
    }

    public String getCssValue(String s) {
        return null;
    }

    public <X> X getScreenshotAs(
            OutputType<X> outputType) throws WebDriverException {
        return null;
    }

    public WebElement getWrappedElement() {
        return element;
    }

    public Coordinates getCoordinates() {
        return null;
    }


}

