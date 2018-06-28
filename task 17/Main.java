/*
 * 17. Сгенерировать миллион данных
 * в коллекцию.
 * Найти оптимальные коллекции, чтобы:
 * получать элемент из середины, конца
 * удалять элемент из середны, конца
 * добавлять элемент
 */
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Date;

/**
 * main class for the task 17.
 */
public class Main {

    /**
     * utility class has a private constructor.
     */
    private Main() {
    };

    /**
     * main method for the task 17.
     * @param args strings
     */
    public static void main(String[] args) {
        List<Object> arrayList = new ArrayList<>();
        List<Object> linkedList = new LinkedList<>();
        fill(arrayList);
        fill(linkedList);

        //Get elements from middle
        System.out.println(getTimeMsOfGet(arrayList)); //0 ms
        System.out.println(getTimeMsOfGet(linkedList)); //2503 ms

        //Get elements from end
        System.out.println(getTimeMsOfGetEnd(arrayList)); //4 ms
        System.out.println(getTimeMsOfGetEnd(linkedList)); //6 ms

        //remove elements from middle(10000 elements)
        System.out.println(remTimeMsOfGetMid(arrayList));  //2 ms
        System.out.println(remTimeMsOfGetMid(linkedList)); //11 ms

        //remove elements from end(10000 elements)
        System.out.println(remTimeMsOfGetEnd(arrayList));
        System.out.println(remTimeMsOfGetEnd(linkedList));

        //add elements from end(1000000 elements)
        System.out.println(addTimeMsOfGetEnd(arrayList)); //0 ms
        System.out.println(addTimeMsOfGetEnd(linkedList)); //0 ms

        //add elements from middle(10000 elements)
        System.out.println(addTimeMsOfGetMid(arrayList)); //10313 ms
        System.out.println(addTimeMsOfGetMid(linkedList)); //52 ms
    }

    /**
     * gets from the middle of the list.
     * @param list comparison list
     */
    private static void getMid(List list) {
        if (list.isEmpty()) {
            return;
        }
        int x = list.size() / 2;
        for (int i = 0; i < 100; i++) {
            list.get(x);
        }
    }

    /**
     * gets from the end of the list.
     * @param list comparison list
     */
    private static void getEnd(List list) {
        if (list.isEmpty()) {
            return;
        }
        int x = list.size() - 1;
        for (int i = 0; i < 1000000; i++) {
            list.get(x);
        }
    }

    /**
     * removes from the middle of the list.
     * @param list comparison list
     */
    private static void removeMid(List list) {
        ListIterator<Integer> in = list.listIterator(list.size() / 2);
        for (int i = 0; i < 100; i++) {
            in.next();
            in.remove();
        }
    }

    /**
     * remves from the end of the list.
     * @param list comparison list
     */
    private static void removeEnd(List list) {
        if (list.isEmpty()) {
            return;
        }
        int x = list.size() - 1;
        for (int i = list.size() - 1; i > list.size() / 2; i--) {
            list.remove(i);
        }
    }

    /**
     * adds from the end of the list.
     * @param list comparison list
     */
    private static void addMid(List list) {
        ListIterator in = list.listIterator(list.size() / 2);
        for (int i = 0; i < 1000; i++) {
            in.next();
            in.add("jj");
        }
    }

    /**
     * adds from the end of the list.
     * @param list comparison list
     */
    private static void addEnd(List list) {
        if (list.isEmpty()) {
            return;
        }
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
    }

    /**
     * fills the list.
     * @param list comparison list
     */
    private static List fill(List list) {
        for (int i = 0; i < 10000000; i++) {
            list.add(new Object());
        }
        return list;
    }

    /**
     * counts the time of getting an element from the middle.
     * @param list comparison list
     * @return time
     */
    private static long getTimeMsOfGet(List list) {
        Date currentDate = new Date();
        getMid(list);
        Date newDate = new Date();
        long msDelay = newDate.getTime() - currentDate.getTime();
        System.out.println("Time delay is: " + msDelay + " in ms");
        return msDelay;
    }

    /**
     * counts the time of getting an element from the end.
     * @param list comparison list
     * @return time
     */
    private static long getTimeMsOfGetEnd(List list) {
        Date currentDate = new Date();
        getEnd(list);
        Date newDate = new Date();
        long msDelay = newDate.getTime() - currentDate.getTime();
        System.out.println("Time delay is: " + msDelay + " in ms");
        return msDelay;
    }

    /**
     * counts the time of removing an element from the middle.
     * @param list comparison list
     * @return time
     */
    private static long remTimeMsOfGetMid(List list) {
        Date currentDate = new Date();
        removeMid(list);
        Date newDate = new Date();
        long msDelay = newDate.getTime() - currentDate.getTime();
        System.out.println("Time delay is: " + msDelay + " in ms");
        return msDelay;
    }

    /**
     * counts the time of removing an element from the end.
     * @param list comparison list
     * @return time
     */
    private static long remTimeMsOfGetEnd(List list) {
        Date currentDate = new Date();
        removeEnd(list);
        Date newDate = new Date();
        long msDelay = newDate.getTime() - currentDate.getTime();
        System.out.println("Time delay is: " + msDelay + " in ms");
        return msDelay;
    }

    /**
     * counts the time of filling an element from the middle.
     * @param list comparison list
     * @return time
     */
    private static long fillMs(List list) {
        Date currentDate = new Date();
        fill(list);
        Date newDate = new Date();
        long msDelay = newDate.getTime() - currentDate.getTime();
        System.out.println("Time delay is: " + msDelay + " in ms");
        return msDelay;
    }

    /**
     * counts the time of adding an element from the middle.
     * @param list comparison list
     * @return time
     */
    private static long addTimeMsOfGetMid(List list) {
        Date currentDate = new Date();
        addMid(list);
        Date newDate = new Date();
        long msDelay = newDate.getTime() - currentDate.getTime();
        System.out.println("Time delay is: " + msDelay + " in ms");
        return msDelay;
    }

    /**
     * counts the time of adding an element from the end.
     * @param list comparison list
     * @return time
     */
    private static long addTimeMsOfGetEnd(List list) {
        Date currentDate = new Date();
        addEnd(list);
        Date newDate = new Date();
        long msDelay = newDate.getTime() - currentDate.getTime();
        System.out.println("Time delay is: " + msDelay + " in ms");
        return msDelay;
    }

}
