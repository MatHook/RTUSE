package OOPLabs.Lab3;

public class lab3_3 {
    public static void main(String[] args) {
        Bed bed = new Bed("Roca", "Red", "Soft");
        Cupboard cupboard = new Cupboard("Scavolin", "Black", "medium");
        FurnitureShop furnitureShop = new FurnitureShop("ANDERSSEN", 59, "soft to hard");
        bed.displayInfo();
        cupboard.displayInfo();
        furnitureShop.displayInfo();
    }
}

abstract class Furniture {
    private String mark_furn;

    String getMark_furn() {
        return mark_furn;
    }

    Furniture(String mark_furn) {
        this.mark_furn = mark_furn;
    }

    public abstract void displayInfo();
}

class Bed extends Furniture {
    private String furniture_color;
    private String furniture_rigidity;

    Bed(String mark_furn, String f_color, String f_rigidity) {
        super(mark_furn);
        this.furniture_color = f_color;
        this.furniture_rigidity = f_rigidity;
    }

    public void displayInfo() {
        System.out.println("Mark of furniture: " + super.getMark_furn()
                + "\ncolor: " + furniture_color
                + "\nrigidity of it: " + furniture_rigidity);
    }
}

class Cupboard extends Furniture {
    private String furniture_color;
    private String furniture_rigidity;

    Cupboard(String mark_furn, String f_color, String f_rigidity) {
        super(mark_furn);
        this.furniture_color = f_color;
        this.furniture_rigidity = f_rigidity;
    }

    public void displayInfo() {
        System.out.println("Mark of furniture: " + super.getMark_furn()
                + "\ncolor: " + furniture_color
                + "\nrigidity of it: " + furniture_rigidity);
    }
}

class FurnitureShop extends Furniture{
    private int quantity_furniture;
    private String type_furniture;

    FurnitureShop(String mark_furn, int q_furniture, String t_furniture) {
        super(mark_furn);
        this.quantity_furniture = q_furniture;
        this.type_furniture = t_furniture;
    }

    public void displayInfo() {
        System.out.println("Mark of furniture: " + super.getMark_furn()
                + "\nquantity of it: " + quantity_furniture
                + "\ntype is: " + type_furniture);
    }
}