package OOPPractice.Prac5;

import java.util.Arrays;

public class prac5 {
    public static void main(String[] args) {
        int[] array = {1, 51, 13, 56, 2};
        int low = 0;
        int high = array.length - 1;
        //printN(3);
        //printNM(4);
        System.out.println(Arrays.toString(array));
        printRS(array, low, high);
        System.out.println(Arrays.toString(array));
    }

    public static void printN(int n) {
        if (n < 1)
            return;
        printN(n - 1);

        System.out.println(n);
    }

    public static void printNM(int n) {
        if (n < 1)
            return;

        printNM(n - 1);

        for(int i = 0; i < n; i++)
            System.out.print(n + " ");
    }

    public static void printRS(int[] a, int l, int h) {
        if (a.length == 0)
            return;

        if (l >= h)
            return;

        int middle = l + (h - l) / 2;
        int state = a[middle];

        int i = l, j = h;
        while (i <= j) {
            while (a[i] < state) {
                i++;
            }

            while (a[j] > state) {
                j--;
            }

            if (i <= j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }

        if (l < j)
            printRS(a, l, j);

        if (h > i)
            printRS(a, i, h);
    }

}
