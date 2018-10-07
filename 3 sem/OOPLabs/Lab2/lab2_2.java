package OOPLabs.Lab2;

import java.util.Scanner;

public class lab2_2 {
    public static void main(String[] args) {
        Human human = new Human();
        Head head = new Head();
        Leg leg = new Leg();
    }
}

class Human {
    private int person_id;
    Human() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id of person: ");
        person_id = sc.nextInt();
    }

    public int getPerson_id() {
        return person_id;
    }
}

class Head extends Human {
    int hh = new Human().getPerson_id();

    Head() {
        boolean brain_empty = false;
        System.out.println(brain_empty);
    }
}

class Leg extends Human {
    int hh = new Human().getPerson_id();

    public Leg() {
        System.out.print("Enter quantity of legs: ");
        Scanner sc = new Scanner(System.in);
        int q_leg = sc.nextInt();
        System.out.print("\nLegs alive?");
        boolean leg_alive = sc.nextBoolean();
        System.out.print("\nQuantity of legs: " + q_leg);
    }
}

class Hand extends Human {
    int hh = new Human().getPerson_id();

    public Hand() {
        System.out.print("Enter quantity of hand: ");
        Scanner sc = new Scanner(System.in);
        int q_hands = sc.nextInt();
        System.out.print("\nHand long?");
        boolean l_hands = sc.nextBoolean();
    }
}