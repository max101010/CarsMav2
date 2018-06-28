/*
 * 15. Убрать дубликаты из List<List<String>>
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * main class.
 */
public class Main {

    /**
     * this list for the task 15.
     */
    private static List<List<String>> list = new ArrayList<>();

    /**
     * utility clas has a private constructor.
     */
    private Main() {
    };

    /**
     * main method.
     * @param args strings
     */
    public static void main(String[] args) {
        addList();
        System.out.println(list);
        deleteDup();
        System.out.println(list);
    }

    /**
     * removes duplicates.
     */
    private static void deleteDup() {
        Set<String> set;
        for (int i = 0; i < list.size(); i++) {
            set = new HashSet<>(list.get(i));
            list.get(i).clear();
            list.get(i).addAll(set);
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
        listStr1.add("1");
        listStr1.add("1");
        listStr1.add("4");
        listStr1.add("5");
        listStr2.add("B");
        listStr2.add("G");
        listStr2.add("A");
        listStr2.add("A");
        listStr2.add("E");
        listStr3.add("scvc");
        listStr3.add("dvse");
        listStr3.add("cvw");
        listStr3.add("awve");
        listStr3.add("wvw");
        listStr4.add("4");
        listStr4.add("2vww");
        listStr4.add("ce");
        listStr4.add("4");
        listStr4.add("dee");
        list.add(listStr1);
        list.add(listStr2);
        list.add(listStr3);
        list.add(listStr4);
    }

}
