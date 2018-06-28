/*
 * 20. Создать множество с числами.
 * Суммировать соседние числа попарно,
 * пока не останется одно число
 */

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

/**
 * main class for the task 20.
 */
public class Main {

    /**
     * set for the task 20.
     */
    private static Set<Integer> set = new HashSet<>();

    /**
     * utility class has a private constructor.
     */
    private Main() {
    }
    /**
     * main method for the task 20.
     * @param args strings
     * @throws InterruptedException exception
     */
    public static void main(String[] args) throws InterruptedException {
        addSet();
        sumSet();
    }

    /**
     * adds sets.
     */
    private static void addSet() {
        for (int i = 0; i < 9; i++) {
            set.add(i);
        }
    }

    /**
     * summarizes the values.
     * @throws InterruptedException exception
     */
    private static void sumSet() throws InterruptedException {
        int[] mass = new int[set.size()];
        int[] buffer = new int[set.size()];
        int count = 0;
        for (Integer integer : set) {
            mass[count] = integer;
            count++;
        }
        System.out.println(Arrays.toString(mass));
        while (mass[1] != 0) {
            for (int i = 0, k = 0; i < mass.length / 2; i++) {
                buffer[i] = mass[k] + mass[k + 1];
                k += 2;
            }
            mass = buffer;
            System.out.println(Arrays.toString(mass));
        }
    }

}
