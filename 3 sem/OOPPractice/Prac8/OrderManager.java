package OOPPractice.Prac8;


import java.util.HashMap;

class OrderManager {
    HashMap<String, Order> orders;

    public OrderManager() {
        orders = new HashMap<>();
    }

    public void addOrder(String address, Order order) throws OrderAlreadyAddedException, IllegalAddressException {
        if (address.isEmpty())
            throw new IllegalAddressException();

        if (orders.containsKey(address))
            throw new OrderAlreadyAddedException();

        orders.put(address, order);
    }

    public Order getOrder(String address) {
        if (!orders.containsKey(address))
            return null;

        return orders.get(address);
    }

    public boolean removeOrder(String address) {
        if (!orders.containsKey(address))
            return false;

        orders.remove(address);

        return true;
    }

    public void addItemToOrder(String address, Item item) {
        if (orders.containsKey(address))
            orders.get(address).addItem(item);
    }

    public InternetOrder[] getIternetOrders() {
        Order[] orders = new Order[this.orders.size()];
        int i = 0;

        for (Order order : this.orders.values()) {
            if (order instanceof InternetOrder)
                orders[i++] = order;
        }

        InternetOrder[] result = new InternetOrder[i];

        for(int j = 0; j < i; j++) {
            result[j] = (InternetOrder) orders[j];
        }

        return result;
    }

    public int getCost() {
        int cost = 0;

        for (Order order : orders.values()) {
            cost += order.getCost();
        }

        return cost;
    }

    public int getAmount(String itemName) {
        int amount = 0;

        for (Order order : orders.values()) {
            amount += order.getAmount(itemName);
        }

        return amount;
    }
}
