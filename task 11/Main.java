/*
 * 11. Преобразовать все значения из
 * List<String> в List<Double>.
 * Добавить проверку на то, что это число
 */

import java.util.ArrayList;
import java.util.List;

/**
 * main class.
 */
public class Main {

    /**
     * private constructor for the utility class.
     */
    private Main() {
    };

    /**
     * method for the task 11.
     * @param args
     */
    public static void main(String[] args) {
        List<String> listString = new ArrayList<>();
        List<Double> listDouble = new ArrayList<>();
         listString.add("1.0");
         listString.add("1.5");
         listString.add("m");
         listString.add("1.6");
         listString.add("1.7");
        for (String s : listString) {
            try {
                listDouble.add(Double.valueOf(s));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            }
        System.out.println(listDouble);
    }

}
