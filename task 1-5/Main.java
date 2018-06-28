/*
 1. Получить все значения в коллекцию,
где данные будут доступны по рядам таблицы,
а значения для конкретного ряда
по ключу - имени колонки
 2. Результат первого задания отфильтровать,
результатом будет такая же коллекция,
только с колонками first name и age
 3. Первое задание, только изначально
получаем значения только
для выбранных колонок
 4. Из результатов первого задания
получить коллекцию,
содержащую только только имена колонок
 5. Результат первого задания
 отсортировать по first name
 */
package task;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import java.util.Comparator;

/**
 * This is main class.
 */
final class Main {

    /**
     * utility class has private constructor.
     */
    private Main() {

    }

    /**
     * This is the main list.
     */
    private static List<Map<String, String>> list = new ArrayList<>();
    /**
     * map value of the main list.
     */
    private static Map<String, String> map1 = new HashMap<String, String>();
    /**
     * map value of the main list.
     */
    private static Map<String, String> map2 = new HashMap<String, String>();
    /**
     * map value of the main list.
     */
    private static Map<String, String> map3 = new HashMap<String, String>();
    /**
     * map value of the main list.
     */
    private static Map<String, String> map4 = new HashMap<String, String>();

    /**
     * main method.
     * @param args strings
     */
    public static void main(String[] args) {

        String line = "|first name|last name|age|sex|";
        String name1 = "|Ivan|Ivanou|18|male|";
        String name2 = "|Olga|Ivanova|5|female|";
        String name3 = "|Sergey|Vasiliev|48|male|";
        String name4 = "|Katja|Novikava|5|female|";
        str(line, name1, map1);
        str(line, name2, map2);
        str(line, name3, map3);
        str(line, name4, map4);
        addMap();
        sortList(list);
        System.out.println(list);
        System.out.println(nameColumn(list));
    }

    /**
     * method for the task 1.
     * adds strings to the map and list.
     * @param str string value for the map
     * @param str2 string value for the map
     * @param map map value for the list
     */
    private static void str(String str, String str2, Map<String, String> map) {
        List<String> key = new ArrayList<>();
        List<String> value = new ArrayList<>();
        Collections.addAll(key, str.substring(1).split("\\|"));
        Collections.addAll(value, str2.substring(1).split("\\|"));
        for (int i = 0; i < key.size(); i++) {
            map.put(key.get(i), value.get(i));
        }
    }

    /**
     * task 1.
     * adds maps to the main list
     */
    private static void addMap() {
        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);
    }

    /**
     * task 2.
     * filters maps by first name and age
     */
    private static void filterMap() {
        map1.remove("last name");
        map1.remove("sex");
        map2.remove("last name");
        map2.remove("sex");
        map3.remove("last name");
        map3.remove("sex");
        map4.remove("last name");
        map4.remove("sex");
        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);
    }

    /**
     * method for the task 3.
     * the method splits the strings
     * @param str the value for the map
     * @param str2 the value for the map
     * @param map the value for the main list
     */
    private static void addChoice(String str, String str2,
                                  Map<String, String> map) {
        List<String> key = new ArrayList<>();
        List<String> value = new ArrayList<>();
        Collections.addAll(key, str.substring(1).split("\\|"));
        Collections.addAll(value, str2.substring(1).split("\\|"));
        for (int i = 0; i < key.size(); i++) {
            if (key.get(i).equals("last name")) {
                map.put(key.get(i), value.get(i));
            }
            if (key.get(i).equals("sex")) {
                map.put(key.get(i), value.get(i));
            }
         }
    }

    /**
     * method for the task 4.
     * @param list1 is the main list
     * @return only map keys
     */
    private static List<String> nameColumn(List<Map<String, String>> list1) {
        List<String> listKey = new ArrayList<>();
        for (Map.Entry<String, String> entry : list1.get(0).entrySet()) {
            listKey.add(entry.getKey());
        }
        return listKey;
    }

    /**
     * method for the task 5.
     * @param list1 is the main list for the sorting
     */
    private static void sortList(List<Map<String, String>> list1) {
        Collections.sort(list1, new Comparator<Map<String, String>>() {
            @Override
            public int compare(Map<String, String> o1, Map<String, String> o2) {

                return o1.get("first name").compareTo(o2.get("first name"));
            }
        });
    }

}
