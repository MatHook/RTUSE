package OOPLabs.Lab4.Lab4_2;

public class Metal implements Priceble {
    private int price;

    int getPrice() {
        return price;
    }

    Metal(int price) {
        this.price = price;
    }

    public void print() {
        System.out.println("Price is: " + price + "$");
    }
}
