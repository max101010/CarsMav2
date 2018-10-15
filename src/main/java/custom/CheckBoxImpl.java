package custom;

import org.openqa.selenium.WebElement;

/**
 * Class contains custom methods for checkbox.
 */
public class CheckBoxImpl extends ElementImpl implements CheckBox {

    /**
     * Public constructor of CheckBoxIml class.
     *
     * @param element of WebElement class.
     */
    public CheckBoxImpl(WebElement element) {
        super(element);
    }

    /**
     * Helper method to switch.
     */
    public void toggle() {
        getWrappedElement().click();
    }

    /**
     * Method to check the checkbox.
     */
    public void check() {
        if (!isChecked()) {
            toggle();
        }
    }

    /**
     * Method to uncheck the checkbox.
     */
    public void uncheck() {
        if (isChecked()) {
            toggle();
        }
    }

    /**
     * The method checks the selected checkbox or not.
     *
     * @return true or false
     */
    public boolean isChecked() {
        return getWrappedElement().isSelected();
    }
}

