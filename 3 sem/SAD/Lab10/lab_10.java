package SAD.Lab10;

import java.util.*;

public class lab_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int N = sc.nextInt();
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            System.out.println("Enter " + (i + 1) + " element of array: ");
            array[i] = sc.nextInt();
        }
        System.out.println("Summ of elements array : " + summ(array, 0));
    }
    public static int summ(int[] n, int index) {
        if (index < n.length) {
            return n[index] + summ(n, index + 1);
        }
        return 0;
    }
}
