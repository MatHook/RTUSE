package SAD.Lab10;

import java.util.*;

public class lab_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(summ(array, 0));
    }
    public static int summ(int[] n, int index) {
        if (index < n.length) {
            return n[index] + summ(n, index + 1);
        }
        return 0;
    }
}
