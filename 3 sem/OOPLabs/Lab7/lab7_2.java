package OOPLabs.Lab7;

import java.util.LinkedList;

public class lab7_2 {
    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<Integer>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        System.out.println("First number is " + numbers.get(0));
        System.out.println("Count of LinkedList is " + numbers.size());
    }
}
