package OOPLabs.Lab3;

import java.util.Scanner;

public class lab3_2 {
    public static void main(String[] main) {
        Hasky h1 = new Hasky();
        System.out.println("Name of dog is " + h1.getName()
                + " age of dog " + h1.getAge()
                + " alive: " + h1.isAlive_check());
        Hasky h2 = new Hasky("Bill", 2);
        System.out.println("Name of dog is "
                + h2.getName() + " age of dog " + h2.getAge()
                + " alive: " + h2.isAlive_check());
        Bulldog b1 = new Bulldog();
        System.out.println("Name of dog is " + b1.getName()
                + " age of dog " + b1.getAge()
                + " alive: " + b1.isAlive_check());
        Bulldog b2 = new Bulldog("Dan", 7);
        System.out.println("Name of dog is " + b2.getName() + " age of dog " + b2.getAge() + " alive: " + b2.isAlive_check());
    }
}

abstract class Dog {
    private boolean alive_check;

    boolean isAlive_check() {
        return true;
    }
}

class Hasky extends Dog {
    private String name;
    private int age;
    private Scanner sc = new Scanner(System.in);
    Hasky() {
        System.out.println("Age of dog is");
        age = sc.nextInt();
        System.out.println("Enter Name of dog");
        name = sc.nextLine();
    }

    Hasky(String n, int y) {
        n = name;
        y = age;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }
}

class Bulldog extends Dog {
    private String name;
    private int age;
    private Scanner sc = new Scanner(System.in);
    Bulldog() {
        System.out.println("Age of dog is");
        age = sc.nextInt();
        System.out.println("Enter Name of dog");
        name = sc.nextLine();
    }

    Bulldog(String n, int y) {
        n = name;
        y = age;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }
}