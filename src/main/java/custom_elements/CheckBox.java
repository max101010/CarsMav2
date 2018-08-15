package custom_elements;

public interface CheckBox extends Element {
    void toggle();
    void check();
    void uncheck();
    boolean isChecked();
}