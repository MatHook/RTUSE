package SAD.Lab8;

import java.util.Scanner;

public class lab_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of matrix (MxN): ");
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] matrix = new int[M][N];
        input(matrix, M, N);
        output(matrix, M, N);
        msort(matrix, M, N);
        output(matrix, M, N);
    }
    public static void input(int[][] idarray, int max_m, int max_n) {
        Scanner sc_input = new Scanner(System.in);
        System.out.println("Input elements of matrix");
        for (int i = 0; i < max_m; i++) {
            for (int j = 0; j < max_n; j++) {
                idarray[i][j] = sc_input.nextInt();
            }
        }
    }
    public static void output(int[][] odarray,  int max_m, int max_n) {
        System.out.println("Output of matrix ");
        for (int i = 0; i < max_m; i++) {
            for (int j = 0; j < max_n; j++) {
                System.out.print(odarray[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static void msort(int[][] sdarray, int max_m, int max_n) {
        Scanner sc_sort = new Scanner(System.in);
        int t;

        System.out.print("Enter value: ");
        int value = sc_sort.nextInt();
        System.out.println("Value for sort: " + value);

        for (int i = 0; i < sdarray.length; i++) {
            for (int j = 0; j < sdarray.length; j++) {
                if (sdarray[i][j] == value) {
                    t = sdarray[i][j];
                    sdarray[i][j] = sdarray[0][max_n - j];
                    sdarray[0][max_n - j] = t;
                }
            }
        }
    }
}
