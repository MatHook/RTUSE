package OOPLabs.Lab4.Lab4_2;

import java.text.NumberFormat;
import java.util.Locale;

public class Metal implements Priceble {
    private int price;

    int getPrice() {
        return price;
    }

    Metal(int price) {
        this.price = price;
    }

    public void print() {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.ENGLISH);
        String cur_price_metal = format.format(price);
        System.out.println("Price is: " + cur_price_metal);
    }
}
