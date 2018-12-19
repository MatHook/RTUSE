package OOPPractice.Prac8;

public class InternetOrder implements Order {
    private class Node {
        public Node prev;
        public Node next;

        public Item item;

        public Node(Item item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

        public void clear() {
            item = null;
            prev = null;
            next = null;
        }
    }

    private Node head;
    private Node tail;

    private int size;

    public InternetOrder() {
        this(new Item[]{});
    }

    public InternetOrder(Item[] items) {
        head = new Node(null, null, null);
        tail = head;

        size = 0;

        for (Item item : items) {
            addItem(item);
        }
    }

    public boolean addItem(Item item) {
        Node node = new Node(item, tail, null);

        tail.next = node;

        tail = node;

        size++;

        return true;
    }

    public boolean removeItem(String itemName) {
        Node current = tail;

        while (current.item != null) {
            if (current.item.getLablel().equals(itemName)) {
                current.prev.next = current.next;

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }

                current.clear();

                size--;

                return true;
            }

            current = current.prev;
        }

        return false;
    }

    public boolean removeAllItems(String itemName) {
        boolean removed = false;

        while (removeItem(itemName))
            removed = true;

        return removed;
    }

    public int getSize() {
        return size;
    }

    public Item[] getItems() {
        Item[] items = new Item[size];

        Node current = tail;
        int i = 0;

        while (current.item != null) {
            items[i++] = current.item;

            current = current.prev;
        }

        return items;
    }

    public int getCost() {
        int cost = 0;

        Node current = tail;

        while (current.item != null) {
            cost += current.item.getCost();

            current = current.prev;
        }

        return cost;
    }

    public int getAmount(String itemName) {
        int amount = 0;

        Node current = tail;

        while (current.item != null) {
            if (current.item.getLablel().equals(itemName)) {
                amount += 1;
            }

            current = current.prev;
        }

        return amount;
    }

    public String[] getNames() {
        String[] names = new String[size];

        Node current = tail;
        int i = 0;

        while (current.item != null) {
            String itemName = current.item.getLablel();
            boolean found = false;

            for (String name : names) {
                if (name != null && name.equals(itemName)) {
                    found = true;
                    break;
                }
            }

            if (!found)
                names[i++] = itemName;

            current = current.prev;
        }

        String[] result = new String[i];

        for(int j = 0; j < i; j++)
            result[j] = names[j];

        return result;
    }

    public Item[] getItemsSortedByCost() {
        Item[] items = getItems();

        // Bubble sort
        for (int i = 0; i < size - 1; i++)
            for (int j = 0; j < size - i -1; j++) {
                if (items[j].getCost() < items[j + 1].getCost()) {
                    Item temp = items[j];
                    items[j] = items[j + 1];
                    items[j + 1] = temp;
                }
            }

        return items;
    }
}
