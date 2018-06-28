//12. Отсортировать внешний и
// внутренний листы в List<Map<String, List<String>>>

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * main class.
 */
public class Main {

    /**
     * sorting list.
     */
    private static List<Map<String, List<String>>> list = new ArrayList<>();

    /**
     * private constructor for the utility class.
     */
    private Main() {
    };

    /**
     * main class.
     *
     * @param args strings
     */
    public static void main(String[] args) {
        addList();
        System.out.println(list);
        sortList();
        for (Map<String, List<String>> map : list) {
            System.out.println(map);
        }
    }

    /**
     * sorts list.
     */
    private static void sortList() {
        for (Map<String, List<String>> map : list) {
            for (Map.Entry entry : map.entrySet()) {
                //sorts the internal list alphabetically
                Collections.sort((List) entry.getValue(),
                        new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                });
            }
        }
        Collections.sort(list, new Comparator<Map<String, List<String>>>() {
            @Override
            //sorts the external list by the number of values
            public int compare(Map<String, List<String>> o1,
                               Map<String, List<String>> o2) {
                return o1.size() - o2.size();
            }
        });
    }

    /**
     * adds values.
     */
    private static void addList() {
        Map<String, List<String>> map1 = new HashMap<>();
        Map<String, List<String>> map2 = new HashMap<>();
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
        map1.put("1", listStr1);
        map1.put("50", listStr3);
        map1.put("2", listStr2);
        map2.put("50", listStr4);
        list.add(map1);
        list.add(map2);
    }

}
