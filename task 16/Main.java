/*
 * 16. Преобразовать лист в строку.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * main class.
 */
public class Main {

    /**
     * string for the task 16.
     */
    private static String s;
    /**
     * list for the task 16.
     */
    private static List<String> list = new ArrayList<>();

    /**
     * main method.
     * @param args strings
     */

    /**
     * utility class has a private constructor.
     */
    private Main() {
    };

    /**
     * main method for the task 16.
     * @param args strings
     */
    public static void main(String[] args) {
        addLisr();
        strList();
        System.out.println(s);
    }

    /**
     * adds values.
     */
    private static void addLisr() {
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
    }

    /**
     * converts a list to a string.
     */
    private static void strList() {
        s = Arrays.toString(list.toArray());
    }

}
