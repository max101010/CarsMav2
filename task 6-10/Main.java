/*
6. Преобразовать произвольный
массив строк в лист
7. Создать объект Man, с полями id,
name, age, sex. Создать список этих объектов.
Преобразовать в коллекцию, которая будет
содержать строковое представление
со значениями id и name.
8. Есть две коллекции
List<Map<String, List<String>>>
с разным содержанием. Сравните их
9. Сравние, что коллекция
List<Map<String, List<String>>>
содержит значения из List<List<String>>
10. Получить из коллекции
List<Map<String, String>> коллекцию,
где будут извлеченные значения из мапы
по заданному клучу
 */

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * This is main class.
 */
final class Main {

    /**
     * utility class has a private constructor.
     */
    private Main() {
    }

    /**
     * main class.
     *
     * @param args strings
     */
    public static void main(String[] args) {

        // The String [] and list for the task 6.
        String[] str = {"dfdfs", "faga", "adgasg", "asdgasg"};
        List<String> list = Arrays.asList(str);

        //task 7.
        Man man = new Man(15, "Ivan", 20, "male");
        Man man1 = new Man(12, "Petr", 15, "male");
        List<Man> listMan = new ArrayList<>();
        listMan.add(man);
        listMan.add(man1);
        Map<String, String> mapMan = new HashMap<>(listMan.size());
        for (Man man2 : listMan) {
            mapMan.put(String.valueOf(man2.getId()), man2.getName());
        }
        System.out.println(mapMan);

        //task 8.
        List<Map<String, List<String>>> list5 = new ArrayList<>();
        List<Map<String, List<String>>> list6 = new ArrayList<>();
        Map<String, List<String>> map1 = new HashMap<>();
        Map<String, List<String>> map2 = new HashMap<>();
        List<String> listStr1 = new ArrayList<>();
        List<String> listStr2 = new ArrayList<>();
        listStr1.add("1");
        listStr1.add("1");
        listStr2.add("1");
        listStr2.add("1");
        map1.put("1", listStr1);
        map2.put("1", listStr2);
        list5.add(map1);
        list6.add(map2);
        System.out.println(list5.equals(list6));
        List<List<String>> listS = new ArrayList<>();
        listS.add(listStr1);
        System.out.println(comareList(list5, listS));
        addlist();
        System.out.println(listst);
        System.out.println(listst(listst));
    }

    /**
     * method for the task 9.
     * @param list1 list one
     * @param list2 list two
     * @return true or false
     */
    private static boolean comareList(List<Map<String,
            List<String>>> list1, List<List<String>> list2) {
        List<String> list = new ArrayList<>();
        for (Map<String, List<String>> map : list1) {
            list.addAll(map.keySet());
            for (List<String> strings : map.values()) {
                list.addAll(strings);
            }
        }
        System.out.println(list);
        List<String> list3 = new ArrayList<>();
        for (List<String> strings : list2) {
            list3.addAll(strings);
        }
        System.out.println(list3);
        return list.containsAll(list3);
    }


    /**
     * map for the task 10.
     */
  private static Map<String, String> map = new HashMap<>();
    /**
     * map for the task 10.
     */
   private static Map<String, String> map1 = new HashMap<>();
    /**
     * map for the task 10.
     */
   private static Map<String, String> map2 = new HashMap<>();
    /**
     * list for the task 10.
     */
   private static List<Map<String, String>> listst = new ArrayList<>();

    /**
     * method for the task 10.
     */
    private static void addlist() {
        map.put("Maksim", "2155338");
        map.put("Dima", "d");
        map.put("Kiril", "2");
        map.put("Sasha", "2");
        map.put("Kate", "8");
        map.put("Marat", "8445");
        map2.put("Maksim", "d");
        map2.put("Dima", "d");
        map2.put("Kiril", "2");
        map2.put("Sasha", "2");
        map2.put("Kate", "8");
        map2.put("Lexr", "m");
        map1.put("Maksim", "m");
        map1.put("Dima", "d");
        map1.put("Kiril", "2");
        map1.put("Sasha", "2");
        map1.put("Kate", "8");
        map1.put("Igor", "z");
        listst.add(map);
        listst.add(map1);
        listst.add(map2);
    }

    /**
     * this method for the task 10.
     *
     * @param list with map values
     * @return values for a given key
     */
    private static List<String> listst(List<Map<String, String>> list) {
        List<String> list1 = new ArrayList<>();
        for (Map<String, String> stringMap : list) {
            for (Map.Entry<String, String> entry : stringMap.entrySet()) {
                if (entry.getKey().equals("Maksim")) {
                    list1.add(entry.getValue());
                }
            }
        }
        return list1;
    }
}

