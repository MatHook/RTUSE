package OOPPractice.Prac5;

public class prac5 {
    public static void main(String[] args) {
        //printN(3);
        //printNM(4);
        printNAB(1,4);
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

    public static void printNAB(int a, int b) {
        if (a < b) {
            for (int i = a; i <= b; i++)
                System.out.println(i);
        }
        else {
            for (int i = b; i <= b; i++)
                System.out.println(i);
        }
    }
}
