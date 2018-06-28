/*
 * 21. Задать два стека,
 * поменять информацию местами
 */

import java.util.Stack;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * this is main class for the task 21.
 */
public class Main {

    /**
     * utility class has a private constructor.
     */
    private Main() {
    }
    /**
     * main method for the task 21.
     * @param args strings
     */
    public static void main(String[] args) {
        Stack<Integer> st1 = new Stack<Integer>();
        Stack<Integer> st2 = new Stack<Integer>();
        st1.push(10);
        st1.push(20);
        st2.push(30);
        st2.push(40);
        System.out.println("First stack before " + st1);
        System.out.println("Second stack before " + st2);
        Iterator<Integer> i = st1.iterator();
        Iterator<Integer> i2 = st2.iterator();
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        while (i.hasNext()) {
            list.add(i.next());
        }
        while (i2.hasNext()) {
            list2.add(i2.next());
        }
        st1.clear();
        for (int j = 0; j < list2.size(); j++) {
            st1.push(list2.get(j));
        }
        st2.clear();
        for (int j = 0; j < list.size(); j++) {
            st2.push(list.get(j));
        }
        System.out.println("First stack after " + st1);
        System.out.println("Second stack after " + st2);
    }

}

