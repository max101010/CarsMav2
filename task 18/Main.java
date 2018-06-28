/*
 * 18. (Для Map)Сгенерировать миллион
 * данных в коллекцию.
 * Найти оптимальные коллекции, чтобы:
 * получать элемент из середины, конца
 * удалять элемент из середны, конца
 * добавлять элемент
 */
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.Date;

/**
 * main class for the task 18.
 */
public class Main {

    /**
     * utility class has a private constructor.
     */
    private Main() {
    };

    /**
     * main method for the task 18.
     * @param args strings
     */
    public static void main(String[] args) {
        Map<Integer, Integer> hashmap = new HashMap();
        Map<Integer, Integer> linkedmap = new LinkedHashMap<>();
        Map<Integer, Integer> treemap = new TreeMap<>();
        Map<Integer, Integer> weakhashmap = new WeakHashMap<>();
        fill(hashmap);
        fill(linkedmap);
        fill(treemap);
        fill(weakhashmap);

        //100000 elements
        fillMs(hashmap); //10 ms
        fillMs(linkedmap); //14 ms
        fillMs(treemap); //28 ms
        fillMs(weakhashmap); //11 ms

        getTimeMsOfGet(hashmap); //33 ms
        getTimeMsOfGet(linkedmap); //8 ms
        getTimeMsOfGet(treemap); //18 ms
        getTimeMsOfGet(weakhashmap); //12 ms

        getTimeMsOfGetEnd(hashmap); //63
        getTimeMsOfGetEnd(linkedmap); //161
        getTimeMsOfGetEnd(treemap); //11
        getTimeMsOfGetEnd(weakhashmap); //10

        remTimeMsOfMid(hashmap); //9 ms
        remTimeMsOfMid(linkedmap); //12 ms
        remTimeMsOfMid(treemap); //54 ms
        remTimeMsOfMid(weakhashmap); //5 ms

        remTimeMsOfEnd(hashmap); //9 ms
        remTimeMsOfEnd(linkedmap); //8 ms
        remTimeMsOfEnd(treemap); //34 ms
        remTimeMsOfEnd(weakhashmap); //8 ms
    }

    /**
     * gets from the middle of the map.
     * @para map comparison map
     */
    private static void getMid(Map<Integer, Integer> map) {
        if (map.isEmpty()) {
            return;
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() == map.size() / 2) {
                System.out.println(entry.getValue());
            }
        }
    }

    /**
     * gets from the end of the map.
     * @para map comparison map
     */
    private static void getEnd(Map<Integer, Integer> map) {
        if (map.isEmpty()) {
            return;
        }
        int x = map.size() - 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() == x - 1) {
                System.out.println(entry.getValue());
            }
        }
    }

    /**
     * removes from the middle of the map.
     * @para map comparison map
     */
    private static void removeMid(Map<Integer, Integer> map) {
        if (map.isEmpty()) {
            return;
        }
        int x = map.size() / 2;
        for (int i = 0; i < x; i++) {
            map.remove(x);
        }
    }

    /**
     * removes from the end of the map.
     * @para map comparison map
     */
    private static void removeEnd(Map<Integer, Integer> map) {
        if (map.isEmpty()) {
            return;
        }
        int x = map.size() - 1;
        for (int i = map.size() - 1; i > 0; i--) {
            map.remove(i);
        }
    }

    /**
     * fills values.
     * @para map comparison map
     */
    private static void fill(Map map) {
        for (int i = 0, k = 0; i < 100000; i++) {
            map.put(i, k);
            k++;
        }
    }

    /**
     * counts the time of getting an element from the middle.
     * @param map comparison map
     * @return time
     */
    private static long getTimeMsOfGet(Map map) {
        Date currentDate = new Date();
        getMid(map);
        Date newDate = new Date();
        long msDelay = newDate.getTime() - currentDate.getTime();
        System.out.println("Time delay is: " + msDelay + " in ms");
        return msDelay;
    }

    /**
     * counts the time of getting an element from the end.
     * @param map comparison map
     * @return time
     */
    private static long getTimeMsOfGetEnd(Map map) {
        Date currentDate = new Date();
        getEnd(map);
        Date newDate = new Date();
        long msDelay = newDate.getTime() - currentDate.getTime();
        System.out.println("Time delay is: " + msDelay + " in ms");
        return msDelay;
    }

    /**
     * counts the time of removing an element from the middle.
     * @param map comparison map
     * @return time
     */
    private static long remTimeMsOfMid(Map map) {
        Date currentDate = new Date();
        removeMid(map);
        Date newDate = new Date();
        long msDelay = newDate.getTime() - currentDate.getTime();
        System.out.println("Time delay is: " + msDelay + " in ms");
        return msDelay;
    }

    /**
     * counts the time of removing an element from the end.
     * @param map comparison map
     * @return time
     */
    private static long remTimeMsOfEnd(Map map) {
        Date currentDate = new Date();
        removeEnd(map);
        Date newDate = new Date();
        long msDelay = newDate.getTime() - currentDate.getTime();
        System.out.println("Time delay is: " + msDelay + " in ms");
        return msDelay;
    }

    /**
     * counts the time of filling.
     * @param map comparison map
     * @return time
     */
    private static long fillMs(Map map) {
        Date currentDate = new Date();
        fill(map);
        Date newDate = new Date();
        long msDelay = newDate.getTime() - currentDate.getTime();
        System.out.println("Time delay is: " + msDelay + " in ms");
        return msDelay;
    }

}
