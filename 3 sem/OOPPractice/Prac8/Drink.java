package OOPPractice.Prac8;

class Drink implements Item {
    public final static String SODA = "Soda";
    public final static String BEER = "Beer";

    public final static String SODA_DESCRIPTION = "Bottle with sida";
    public final static String BEER_DESCRIPTION = "Bottle with beer";

    private final String name;
    private final String description;
    private final int cost;

    Drink(String name, String description, int cost) {
        this.name = name;
        this.description = description;
        this.cost = cost;
    }


    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public String getLablel() {
        return name;
    }

    @Override
    public String getDiscription() {
        return description;
    }

    public String toString() {
        return String.format("%s (%d$)",
                getLablel(),
                getCost()
        );
    }
}
