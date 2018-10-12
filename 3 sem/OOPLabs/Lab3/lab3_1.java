package OOPLabs.Lab3;

public class lab3_1 {
    public static void main(String[] args) {
        Dish dish = new Dish(true) {
            @Override
            public void displayInfo() {

            }
        };
    }
}

abstract class Dish {
    private boolean check_dish;

    Dish(boolean check_dish) {
        this.check_dish = check_dish;
    }

    public abstract void displayInfo();

    boolean isCheck_dish() {
        return check_dish;
    }
}

class Cup extends Dish {
    private String color_cup;
    private String type_dish;

    Cup(boolean check_dish) {
        super(check_dish);
    }

    public void displayInfo() {
        System.out.println("Color is " + color_cup
                + " type is " + type_dish
                + " specification is " + !super.isCheck_dish());
    }
}
class Plate extends Dish {
    private String color_plate;
    private String type_dish;

    Plate(boolean check_dish) {
        super(check_dish);
    }

    public void displayInfo() {
        System.out.println("Color is " + color_plate
                + " type is " + type_dish
                + " specification is " + !super.isCheck_dish());
    }
}
class Bowl extends Dish {
    private String type_dish;
    private String color_bowl;

    Bowl(boolean check_dish) {
        super(check_dish);
    }

    public void displayInfo() {
        System.out.println("Color is " + color_bowl
                + " type is " + type_dish
                + " specification as dish " + !super.isCheck_dish());
    }
}
