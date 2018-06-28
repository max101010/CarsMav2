/*
 * 19. Сделать коллекцию из результатов
 * пересечения двух множеств
 */
import java.util.HashSet;
import java.util.Set;

/**
 * this is class for the task 19.
 */
public class Main {

    /**
     * set №1 for the task 19.
     */
  private static Set<Integer> set = new HashSet<>();
    /**
     * set №2 for the task 19.
     */
   private static Set<Integer> set1 = new HashSet<>();

    /**
     * utility class has a private constructor.
     */
   private Main() {
   };

    /**
     * main class for the task 19.
     * @param args
     */
    public static void main(String[] args) {
        addSet();
        intersection(set, set1);
        System.out.println(set);
    }

    /**
     * returns the result of the intersection.
     * @param set1 set №1
     * @param set2 set №2
     * @return set of intersections
     */
    private static Set<Integer>
    intersection(Set<Integer> set1, Set<Integer> set2) {
        set2.retainAll(set1);
        set1.retainAll(set2);
        return set1;
    }

    /**
     * adds values for the set N2.
     */
    private static void addSet() {
        for (int i = 0; i < 50; i++) {
            set.add(i);
            if (i > 25) {
                set1.add(i);
            }
        }
    }

    /**
     * adds values for the set №1.
     */
    private static void addSet1() {
        set.add(1);
        set.add(8);
        set.add(6);
        set.add(13);
        set.add(123);
        set1.add(5);
        set1.add(17);
        set1.add(8);
        set1.add(1);
        set1.add(13);
    }

}
