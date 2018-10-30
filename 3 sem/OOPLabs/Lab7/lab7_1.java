package OOPLabs.Lab7;

import java.util.ArrayList;

public class lab7_1 {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("RED");
        colors.add("BLUE");
        colors.add("BLACK");

        System.out.printf("Count elements of arraylist %d \n", colors.size());
        for (String ccc : colors) {
            System.out.println(ccc);
        }
        if (colors.contains("BLACK")) {
            System.out.println("It contains black color");
        }
    }
}
