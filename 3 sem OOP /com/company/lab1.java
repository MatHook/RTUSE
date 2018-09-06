package com.company;
import java.util.*;

public class lab1 {

    public static void main(String[] args) {
        forefun(); //Sum of Array by for
        whilfun(); //Sum of Array by while
        dwhilfun(); //Sum of Array by do while
        System.out.println("Output Arguments:");
        for (int i = 0; i < args.length; i++) //Args out
            System.out.print(args[i] + " ");
        garmon(); // Harmonic output
        Randomizer3000(); //Random not sorted and sorted arrays
        factorialfun(5); //Factorial
        factorialrecfun(5); //Factorial in recursion metod
    }
    public static void forefun() {
        int[] array = {1, 31, 87, 23};
        int sum = 0;
        for (int i = 0; i < array.length; i++)
            sum += array[i];
        System.out.println("Sum by 'for' round:");
        System.out.println(sum);
    }
    public static void whilfun() {
        int[] array = {2, 32, 88, 24};
        int sum = 0;
        for (int i = 0; i < array.length; i++)
            sum += array[i];
        System.out.println("Sum by 'while' round:");
        System.out.println(sum);
    }
    public static void dwhilfun() {
        int[] array = {3, 33, 89, 25};
        int sum = 0;
        for (int i = 0; i < array.length; i++)
            sum += array[i];
        System.out.println("Sum by 'do while' round:");
        System.out.println(sum);
    }
    public static void garmon() {
        int[] array = new int[10];
        System.out.println("\nHarmonical output:");
        for (int i = 0; i < array.length; i++) {
            System.out.println((float)1/(i+1));
        }
    }
    public static void Randomizer3000() {
        Random rand = new Random();
        int[] array = new int[10];
        System.out.println("UnSorted array:");
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt();
            System.out.print(array[i] + " ");
        }
        Arrays.sort(array);
        System.out.println("\nSorted array:");
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
    }
    public static void factorialfun(int n) {
        int factor = 1;
        for (int i = 1; i <= n; i++)
            factor *= i;
        System.out.print("\nFactorial of " + n +" is " + factor + "\n");
    }
    public static int factorialrecfun(int n) {
        int result;
        if(n==1) {
            return 1;
        }
        System.out.println(result = n*factorialrecfun(n-1));
        return result;
    }
}
