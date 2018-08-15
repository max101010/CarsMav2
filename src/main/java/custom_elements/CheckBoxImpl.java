package custom_elements;

import org.openqa.selenium.WebElement;


    public class CheckBoxImpl extends ElementImpl implements CheckBox {

        public CheckBoxImpl(WebElement element) {
            super(element);
        }

        public void toggle() {
            getWrappedElement().click();
        }

        public void check() {
            if (!isChecked()) {
                toggle();
            }
        }

        public void uncheck() {
            if (isChecked()) {
                toggle();
            }
        }

        public boolean isChecked() {
            return getWrappedElement().isSelected();
        }
    }

