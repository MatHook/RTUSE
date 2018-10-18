package OOPLabs.Lab3;

public class lab3_1 {
        public static void main(String[] args) {
            Cup c = new Cup(true, "Red", "Mug");
            Plate p = new Plate(true, "White", "Dessert");
            Bowl b = new Bowl(true, "Brown", "Canine");
            c.displayInfo();
            p.displayInfo();
            b.displayInfo();
    }
}

abstract class Dish {
    private boolean check_dish;

    boolean isCheck_dish() {
        return check_dish;
    }

    public Dish(boolean check_dish) {
        this.check_dish = check_dish;
    }

    public abstract void displayInfo();
}

class Cup extends Dish {
    private String color_cup;
    private String type_dish;

    Cup(boolean check_dish, String c_cup, String t_dish) {
        super(check_dish);
        this.color_cup = c_cup;
        this.type_dish = t_dish;
    }

    public void displayInfo() {
        System.out.println("Color is " + color_cup
                + " type is " + type_dish
                + " specification is " + super.isCheck_dish());
    }
}
class Plate extends Dish {
    private String color_plate;
    private String type_dish;

    Plate(boolean check_dish, String c_plate, String t_dish) {
        super(check_dish);
        this.color_plate = c_plate;
        this.type_dish = t_dish;
    }

    public void displayInfo() {
        System.out.println("Color is " + color_plate
                + " type is " + type_dish
                + " specification is " + super.isCheck_dish());
    }
}
class Bowl extends Dish {
    private String type_dish;
    private String color_bowl;

    Bowl(boolean check_dish, String c_bowl, String t_dish) {
        super(check_dish);
        this.color_bowl = c_bowl;
        this.type_dish = t_dish;
    }

    public void displayInfo() {
        System.out.println("Color is " + color_bowl
                + " type is " + type_dish
                + " specification as dish " + !super.isCheck_dish());
    }
}
