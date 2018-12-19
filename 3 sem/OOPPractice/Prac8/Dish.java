package OOPPractice.Prac8;

class Dish implements Item {
    public final static String FRUIT = "Fruit";
    public final static String MEAT = "Meat";

    public final static String FRUIT_DESCRIPTION = "Plate with fruits";
    public final static String MEAT_DESCRIPTION = "Plate with meat";
    private final int cost;
    private final String label;
    private final String description;

    public Dish(String label, String description) {
        this(0, label, description);
    }
    Dish(int cost, String label, String description){
        if (label.isEmpty() || description.isEmpty() || cost < 0)
            throw new IllegalArgumentException();
        this.cost = cost;
        this.label = label;
        this.description= description;
    }
    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public String getLablel() {
        return label;
    }

    @Override
    public String getDiscription() {
        return description;
    }

    public String toString() {
        return String.format(
                "%s (%d$)",
                getLablel(),
                getCost()
        );
    }
}
