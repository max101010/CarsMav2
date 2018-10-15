package custom;

/**
 * This interface describes methods for custom checkbox.
 */
public interface CheckBox extends Element {
    /**
     * Helper method to switch.
     */
    void toggle();

    /**
     * Method to check the checkbox.
     */
    void check();

    /**
     * Method to uncheck the checkbox.
     */
    void uncheck();

    /**
     * The method checks whether the checkbox is checked or not.
     *
     * @return true or false
     */
    boolean isChecked();
}
