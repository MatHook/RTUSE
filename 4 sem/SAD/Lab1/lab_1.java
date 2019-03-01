import java.util.Set;

public class lab_1 extends HashSet {
    public static void main(String[] args) {
        Set<Integer> numerous_1 = new HashSet<>();
        Set<Integer> numerous_2 = new HashSet<>();
        Set<Integer> numerous_3 = new HashSet<>();

        for (int i = 0; i < 5; i++) {
            numerous_1.add(i);
        }
        for (int i = 1; i < 6; i++) {
            numerous_2.add(i);
        }
        for (int i = 2; i < 7; i++) {
            numerous_3.add(i);
        }
        numerous_1.retainAll(numerous_2);
        numerous_1.retainAll(numerous_3);

        for (Integer numer : numerous_1) {
            System.out.println(numer);
        }
    }
}
