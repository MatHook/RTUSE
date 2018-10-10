package OOPLabs.Lab3;

import java.util.Scanner;

public class lab3_1 {
    public static void main(String[] args) {
        Dish dish = new Dish();
        System.out.println("It's dish? " + dish.isCheck_dish());
        Cup c1 = new Cup();
        System.out.println("It's a dish " + c1.isCheck_dish()
                + " color is " + c1.getColor_cup()
                + " type is " + c1.getType_dish());
        Cup c2 = new Cup("blue", "Mug");
        System.out.println("It's a dish " + c2.isCheck_dish()
                + " color is " + c2.getColor_cup()
                + " type is " + c2.getType_dish());
        Plate p1 = new Plate();
        System.out.println("It's a dish " + p1.isCheck_dish()
                + " color is " + p1.getColor_plate()
                + " type is " + p1.getType_dish());
        Plate p2 = new Plate("red", "mesh");
        System.out.println("It's a dish " + p2.isCheck_dish()
                + " color is " + p2.getColor_plate()
                + " type is " + p2.getType_dish());
        Bowl b1 = new Bowl();
        System.out.println("It's a dish " + b1.isCheck_dish()
                + " color is " + b1.getColor_bowl()
                + " type is " + b1.getType_dish());
        Bowl b2 = new Bowl("brown", "Chashka");
        System.out.println("It's a dish " + b2.isCheck_dish()
                + " color is " + b2.getColor_bowl()
                + " type is " + b2.getType_dish());

    }
}

class Dish {
    private boolean check_dish;

    boolean isCheck_dish() {
        return true;
    }
}

class Cup extends Dish {
    private String color_cup;
    private String type_dish;

    Cup() {
        System.out.print("Enter type of dish: ");
        Scanner sc = new Scanner(System.in);
        type_dish = sc.nextLine();
        System.out.print("\nEnter color of cup: ");
        color_cup = sc.nextLine();
    }

    Cup(String c, String td) {
       c = color_cup;
       td = type_dish;
    }

    String getColor_cup() {
        return color_cup;
    }
    String getType_dish() {
        return type_dish;
    }
}
class Plate extends Dish {
    private String color_plate;
    private String type_dish;

    Plate() {
        System.out.print("Enter type of dish: ");
        Scanner sc = new Scanner(System.in);
        type_dish = sc.nextLine();
        System.out.print("\nEnter color of plate: ");
        color_plate = sc.nextLine();
    }

    Plate(String p, String td) {
        p = color_plate;
        td = type_dish;
    }

    String getColor_plate() {
        return color_plate;
    }
    String getType_dish() {
        return type_dish;
    }
}
class Bowl extends Dish {
    private String type_dish;
    private String color_bowl;
    Bowl() {
        System.out.print("Enter type of dish: ");
        Scanner sc = new Scanner(System.in);
        type_dish = sc.nextLine();
        System.out.print("\nEnter color of cup: ");
        color_bowl = sc.nextLine();
    }

    Bowl(String b, String td) {
        b = color_bowl;
        td = type_dish;
    }

    String getType_dish() {
        return type_dish;
    }
    String getColor_bowl() {
        return color_bowl;
    }
}
