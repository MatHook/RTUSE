package OOPPractice.Prac8;

public interface Order {
    public boolean addItem(Item item);
    public boolean removeItem(String itemName);
    public boolean removeAllItems(String itemName);
    public Item[] getItems();
    public int getCost();
    public int getAmount(String itemName);
    public String[] getNames();
    public Item[] getItemsSortedByCost();
}
