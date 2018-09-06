package com.company;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays.*;

public class lab1 {

    public static void main(String[] args) {
        forefun(); //Sum of Array by for
        whilfun(); //Sum of Array by while
        dwhilfun(); //Sum of Array by do while
        for (int i = 0; i < args.length; i++) //Args out
            System.out.println(args[i]);
        garmon(); // Harmonic output
        Randomizer3000(); //Random not sorted and sorted arrays
        factorialfun(5);
    }
    public static void forefun() {
        int[] array = {1, 31, 87, 23};
        int sum = 0;
        for (int i = 0; i < array.length; i++)
            sum += array[i];
        System.out.println(sum);
    }
    public static void whilfun() {
        int[] array = {2, 32, 88, 24};
        int sum = 0;
        for (int i = 0; i < array.length; i++)
            sum += array[i];
        System.out.println(sum);
    }
    public static void dwhilfun() {
        int[] array = {3, 33, 89, 25};
        int sum = 0;
        for (int i = 0; i < array.length; i++)
            sum += array[i];
        System.out.println(sum);
    }
    public static void garmon() {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            System.out.println((float)1/(i+1));
        }
    }
    public static void Randomizer3000() {
        Random rand = new Random();
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt();
            System.out.println(array[i] + " ");
        }
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++)
            System.out.println(array[i] + " ");
    }
    public static void factorialfun(int n) {
        int factor = 1;
        for (int i = 1; i <= n; i++)
            factor *= i;
        System.out.println(factor);
    }
}
