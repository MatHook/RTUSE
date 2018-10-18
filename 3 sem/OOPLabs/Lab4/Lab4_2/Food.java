package OOPLabs.Lab4.Lab4_2;

import java.text.NumberFormat;
import java.util.Locale;

public class Food implements Priceble {
    private int price;

    int getPrice() {
        return price;
    }

    Food(int price) {
        this.price = price;
    }

    public void print() {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        String cur_price_food = format.format(price);
        System.out.println("Price is: " + cur_price_food);
    }
}
