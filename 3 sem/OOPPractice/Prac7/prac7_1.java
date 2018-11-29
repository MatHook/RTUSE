package OOPPractice.Prac7;

import java.util.ArrayDeque;
import java.util.Scanner;

public class prac7_1 {
    public static void main(String[] args) {
        ArrayDeque<Integer> deque1 = new ArrayDeque<Integer>();
        ArrayDeque<Integer> deque2 = new ArrayDeque<Integer>();

        Scanner incs = new Scanner(System.in);
        Scanner sc = new Scanner(incs.nextLine());

        for (int i = 0; i < 5; i++) {
            deque1.addLast(sc.nextInt());
        }

        sc = new Scanner(incs.nextLine());

        for (int i = 0; i < 5; i++) {
            deque2.addLast(sc.nextInt());
        }

        for (int i = 0; i < 106; i++) {
            if (deque1.isEmpty()) {
                System.out.printf("%s %s\n", "second", i);
                return;
            }

            if (deque2.isEmpty()) {
                System.out.printf("%s %d\n", "first", i);
                return;
            }

            int card1 = deque1.pop();
            int card2 = deque2.pop();

            ArrayDeque<Integer> winner = ((card1 == 0 && card2 == 9) || (card1 > card2 && (card1 != 9 || card2 != 0))) ? deque1 : deque2;

            winner.addLast(card1);
            winner.addLast(card2);
        }

        System.out.println("botva");
    }
}
