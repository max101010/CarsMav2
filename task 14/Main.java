/*
 * 14. Три потока должны безопасно работать
  * с Map<Long, Man>. Где Man - объект, см. #7
 */

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * this is main class.
 */
public class Main extends Thread {

    /**
     * this is map for the task 14.
     */
    private static Map<Long, Man> manMap = new ConcurrentHashMap<>();

    /**
     * main.
     * @param args str
     */
    public static void main(String[] args) {
        Man man = new Man(18, "Max", "male");
        Man man1 = new Man(19, "Dima", "male");
        Man man2 = new Man(18, "Kate", "female");
        Man man3 = new Man(45, "Nina", "female");

        manMap.put(1L, man);
        manMap.put(2L, man1);
        manMap.put(3L, man2);
        manMap.put(4L, man3);

        Main thread1 = new Main();
        Main thread2 = new Main();
        Main thread3 = new Main();
        thread1.start();
        thread2.start();
        thread3.start();
    }

    /**
     * this is method for the thread.
     */
    public void run() {
        for (Map.Entry entry : manMap.entrySet()) {
            Man man = (Man) entry.getValue();
            System.out.println(man.getName());
        }
    }

}
