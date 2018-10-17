package OOPLabs.Lab4.Lab4_2;

public class lab4_2 {
    public static void main(String[] args) {
        display(new Metal(400));
        display(new Food(50));
    }
    private static void display(Priceble p) {
        p.print();
    }
}

