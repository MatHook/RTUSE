package OOPPractice.Prac8;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        OrderManager orderManager = new OrderManager();

        Dish dish1 = new Dish(8, Dish.FRUIT, Dish.FRUIT_DESCRIPTION);
        Dish dish2 = new Dish(4, Dish.MEAT, Dish.MEAT_DESCRIPTION);

        Drink drink1 = new Drink(Drink.BEER, Drink.BEER_DESCRIPTION, 3);
        Drink drink2 = new Drink(Drink.BEER, Drink.BEER, 9);

        Order order = new InternetOrder();

        order.addItem(dish2);
        order.addItem(drink2);
        order.addItem(drink1);

        System.out.println("4 + 3 + 9 = (16) " + order.getCost());
        System.out.println("Beer =(2) " + order.getAmount(Drink.BEER));
        System.out.println("Labels =(Beer, Beer, Meat )" + Arrays.toString(order.getNames()));
        System.out.println("Sort by cost =(9, 4, 3) " + Arrays.toString(order.getItemsSortedByCost()));

        System.out.println("Labels =(Beer, Bear, Meat )" + Arrays.toString(order.getItems()));
        order.removeItem(Drink.BEER);
        System.out.println("Labels =(Beer, Meat) " + Arrays.toString(order.getItems()));

        order.addItem(drink1);
        order.removeAllItems(Drink.BEER);
        System.out.println("Labels =(Meat) " + Arrays.toString(order.getItems()));

        Order order1 = new InternetOrder(new Item[]{drink2, dish2});
        Order order2 = new InternetOrder(new Item[]{drink2, dish2});

        try {
            orderManager.addOrder("Sun", order);
            orderManager.addOrder("ISS", order1);
        } catch (OrderAlreadyAddedException e) {
            System.out.println("Wrong catch");
        }

        try {
            orderManager.addOrder("ISS", order2);
            System.out.println("Wrong catch");
        } catch (OrderAlreadyAddedException e) {
            System.out.println("Catched");
        }

        System.out.println("Cost orders =(13 + 4) " + orderManager.getCost());

        System.out.println("Meat =(2) " + orderManager.getAmount(Dish.MEAT));

        System.out.println("Orders of InternetOrder =(2) " + orderManager.getIternetOrders().length);

        orderManager.addItemToOrder("ISS", dish1);

        System.out.println("Cost orders =(13 + 12) " + orderManager.getCost());
    }
}
