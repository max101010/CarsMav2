/*
 * 13. Убрать заданное значение
 * из листа в Map<String, List<String>>
 */

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * this is main class.
 */
public class Main {

    /**
     * a map for the task 13.
     */
    static Map<String, List<String>> map = new HashMap<>();
    /**
     * value for the task 13.
     */
    static String s = "1";

    /**
     * main method
     * @param args param
     */
    public static void main(String[] args) {
        addList();
        System.out.println(map);
        deleteVallue(map, s);
        System.out.println(map);
    }

    /**
     * this is method delete values.
     * @param map from which removed
     * @param string what is removed
     */
    private static void deleteVallue(Map<String, List<String>> map, String string) {
        List<String> list = new ArrayList<>();
        for (Map.Entry entry : map.entrySet()) {
            for (int i = 0; i < map.size(); i++) {
                list = (List) entry.getValue();
                if (list.get(i).equals(string)) {
                    list.remove(i);
                }
            }
            map.put((String) entry.getKey(), list);
        }
    }

    /**
     * adds values.
     */
    private static void addList() {
        List<String> listStr1 = new ArrayList<>();
        List<String> listStr2 = new ArrayList<>();
        List<String> listStr3 = new ArrayList<>();
        List<String> listStr4 = new ArrayList<>();
        listStr1.add("1");
        listStr1.add("2");
        listStr1.add("3");
        listStr1.add("4");
        listStr1.add("5");
        listStr2.add("B");
        listStr2.add("G");
        listStr2.add("C");
        listStr2.add("A");
        listStr2.add("E");
        listStr3.add("scvc");
        listStr3.add("dvse");
        listStr3.add("cvw");
        listStr3.add("awve");
        listStr3.add("wvw");
        listStr4.add("1");
        listStr4.add("2vww");
        listStr4.add("ce");
        listStr4.add("4");
        listStr4.add("dee");
        map.put("1", listStr1);
        map.put("50", listStr3);
        map.put("2", listStr2);
        map.put("50", listStr4);
    }

    
}
